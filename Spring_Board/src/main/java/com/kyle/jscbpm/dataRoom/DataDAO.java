package com.kyle.jscbpm.dataRoom;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class DataDAO {
	
	@Autowired SqlSession ss;
	
	public void upload(HttpServletRequest req,HttpServletResponse res){
		try {
			String path = req.getSession().getServletContext().getRealPath("resources/file");
			MultipartRequest mr = new MultipartRequest(req, path,30*1024*1024,"UTF-8",new DefaultFileRenamePolicy());
			
			String js_uploader = mr.getParameter("js_uploader");
			String js_title = mr.getParameter("js_title");
			String js_cate = mr.getParameter("js_cate");
			String js_file = mr.getFilesystemName("js_file");
			js_file = URLEncoder.encode(js_file, "UTF-8");
			js_file = js_file.replace("+", " ");
			
			Data d = new Data(null, js_uploader, js_title, js_cate, js_file, null);
			
			ss.getMapper(DataMapper.class).upload(d);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getAllFile(HttpServletRequest req,HttpServletResponse res){
		List<Data>datas = ss.getMapper(DataMapper.class).select();
		
		req.setAttribute("datas", datas);
	}
	public void deleteData(Data d,HttpServletRequest req,HttpServletResponse res){
		ss.getMapper(DataMapper.class).deleteData(d);
	}
}
