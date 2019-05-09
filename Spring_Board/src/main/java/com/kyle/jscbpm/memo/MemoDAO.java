package com.kyle.jscbpm.memo;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class MemoDAO {
	
	private int ReviewCount;
	
	@Autowired SqlSession ss;
	
	public void writeMemo(HttpServletRequest req,HttpServletResponse res){
		try {
			String path = req.getSession().getServletContext().getRealPath("resources/img");
			MultipartRequest mr = new MultipartRequest(req, path, 30*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
			String js_writer = mr.getParameter("js_writer");
			String js_txt = mr.getParameter("js_txt");
			String js_file = mr.getFilesystemName("js_file");
			js_file = URLEncoder.encode(js_file, "UTF-8");
			js_file = js_file.replace("+", " ");
			
			Memo m = new Memo(null, js_writer, js_txt, null, js_file, null);
			
			if (ss.getMapper(MemoMapper.class).writeMemo(m)==1) {
				ReviewCount++;
				req.setAttribute("r", "작성성공");
			}
		} catch (Exception e) {
			req.setAttribute("r", "작성실패");
			e.printStackTrace();
		}
	}
	
	public void getReviewCount(HttpServletRequest req,HttpServletResponse res){
		ReviewCount = ss.getMapper(MemoMapper.class).getReviewCount();
	}
	
	public void paging(int pageNo, HttpServletRequest req, HttpServletResponse res) {
		@SuppressWarnings("unchecked")
		List<Memo> searchMsgs = (List<Memo>) req.getSession().getAttribute("searchMsgs");

		double count = 5.0;
		req.setAttribute("curPage", pageNo);
		if (searchMsgs != null && searchMsgs.size()>0) {
			// 검색
			int pageCount = (int) Math.ceil(searchMsgs.size()/count);
			req.setAttribute("pageCount", pageCount);
			
			int start = (searchMsgs.size() - ((pageNo - 1) * (int) count));
			int end = (pageNo == pageCount) ? 1 : (start - ((int) count - 1));
			
			ArrayList<Memo>Reviews = new ArrayList<Memo>();
			Memo m = null;

			for (int i = start - 1; i >= end - 1; i--) {
				m = searchMsgs.get(i);
				m.setJs_memo_Reply(ss.getMapper(MemoMapper.class).getReply());
				Reviews.add(m);
			}
			req.setAttribute("AllMemo", Reviews);

		}else if (ReviewCount >0) {
			// 검색없을때 그냥 조회
			int pageCount = (int) Math.ceil(ReviewCount / count);
			System.out.println(pageCount);
			req.setAttribute("pageCount", pageCount);

			int start = (ReviewCount - ((pageNo - 1) * (int) count));
			int end = (pageNo == pageCount) ? 1 : (start - ((int) count - 1));
			
			ReveiwNo rn = new ReveiwNo(new BigDecimal(start), new BigDecimal(end));

			List<Memo>allmemo = ss.getMapper(MemoMapper.class).getReview(rn);

			for (Memo m2 : allmemo) {
				m2.setJs_memo_Reply(ss.getMapper(MemoMapper.class).getReply());
			}
			
			req.setAttribute("AllMemo", allmemo);
		}
	}
	
	public void search(Memo m,HttpServletRequest req,HttpServletResponse res){
		List<Memo>searchMsgs = ss.getMapper(MemoMapper.class).search(m);
		req.getSession().setAttribute("searchMsgs", searchMsgs);
	}
	
	public void clearSearch(HttpServletRequest req, HttpServletResponse res){
		req.getSession().setAttribute("searchMsgs", null);
	}
	
	public void delMemo(Memo m,HttpServletRequest req, HttpServletResponse res){
		if (ss.getMapper(MemoMapper.class).delReview(m)==1) {
			req.setAttribute("r", "삭제성공");
			ReviewCount--;
		}
	}
	
	public void update(Memo m,HttpServletRequest req, HttpServletResponse res){
		ss.getMapper(MemoMapper.class).update(m);
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void writeReply(MemoReply mp,HttpServletRequest req,HttpServletResponse res){
		ss.getMapper(MemoMapper.class).writeReply(mp);
	}
	
	public void deleteReply(MemoReply mp,HttpServletRequest req,HttpServletResponse res){
		ss.getMapper(MemoMapper.class).deleteReply(mp);
	}
}
