package com.kyle.jscbpm.man;

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
public class ManDAO {

	private int memoCount;
	
	@Autowired SqlSession ss;
	
	public void writeMan(HttpServletRequest req,HttpServletResponse res) {
		try {
			String path = req.getSession().getServletContext().getRealPath("resources/img");
			MultipartRequest mr = new MultipartRequest(req, path, 30 * 1024 * 1024, "UTF-8",
					new DefaultFileRenamePolicy());
			String js_txt = mr.getParameter("js_txt");
			String js_file = mr.getFilesystemName("js_file");
			js_file = URLEncoder.encode(js_file, "UTF-8");
			js_file = js_file.replace("+", " ");

			Man m = new Man(null, js_txt, null, js_file);

			if (ss.getMapper(ManMapper.class).writeMan(m) == 1) {
				req.setAttribute("r", "작성성공");
				memoCount++;
			}
		} catch (Exception e) {
			req.setAttribute("r", "작성실패");
			e.printStackTrace();
		}
	}

	public void getAllMemo(HttpServletRequest req, HttpServletResponse res) {
		req.setAttribute("AllMemo", ss.getMapper(ManMapper.class).getAllMemo());
	}

	public void gettAllMemoCount(HttpServletRequest req, HttpServletResponse res){
		memoCount = ss.getMapper(ManMapper.class).getAllMemoCount();
	}

	public void paging(int pageNo, HttpServletRequest req, HttpServletResponse res) {
		@SuppressWarnings("unchecked")
		List<Man> searchMsgs = (List<Man>) req.getSession().getAttribute("searchMsgs");

		double count = 5.0;
		req.setAttribute("curPage", pageNo);
		
		
		if (searchMsgs != null && searchMsgs.size()>0) {
			// 검색
			int pageCount = (int) Math.ceil(searchMsgs.size()/count);
			req.setAttribute("pageCount", pageCount);
			
			int start = (searchMsgs.size() - ((pageNo - 1) * (int) count));
			int end = (pageNo == pageCount) ? 1 : (start - ((int) count - 1));
			
			ArrayList<Man>men = new ArrayList<Man>();
			Man m = null;

			for (int i = start - 1; i >= end - 1; i--) {
				m = searchMsgs.get(i);
				men.add(m);
			}
			req.setAttribute("AllMemo", men);

		}else if (memoCount >0) {
			// 검색없을때 그냥 조회
			int pageCount = (int) Math.ceil(memoCount / count);
			req.setAttribute("pageCount", pageCount);

			int start = (memoCount - ((pageNo - 1) * (int) count));
			int end = (pageNo == pageCount) ? 1 : (start - ((int) count - 1));
			
			MemoNo mn = new MemoNo(new BigDecimal(start), new BigDecimal(end));
			
			req.setAttribute("AllMemo", ss.getMapper(ManMapper.class).getMemo(mn));
		}
	}

	public void search(Man m,HttpServletRequest req, HttpServletResponse res){
		List<Man>searchMsgs = ss.getMapper(ManMapper.class).search(m);
		req.getSession().setAttribute("searchMsgs", searchMsgs);
	}

	public void clearSearch(HttpServletRequest req, HttpServletResponse res){
		req.getSession().setAttribute("searchMsgs", null);
	}

	public void delete(HttpServletRequest req, HttpServletResponse res){
		BigDecimal js_no = new BigDecimal(req.getParameter("js_no"));
		Man m = new Man(js_no, null, null, null);
		
		if (ss.getMapper(ManMapper.class).delete(m)==1) {
			req.setAttribute("r", "삭제성공");
			memoCount--;
		}
	}
}
