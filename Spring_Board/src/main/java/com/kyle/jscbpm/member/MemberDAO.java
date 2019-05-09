package com.kyle.jscbpm.member;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class MemberDAO {
	
	@Autowired SqlSession ss;
	
	public void reg(Member m,HttpServletRequest req,HttpServletResponse res){
		try {
			String path = req.getSession().getServletContext().getRealPath("resources/img");
			System.out.println(path);
			MultipartRequest mr = new MultipartRequest(req, path, 30*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
			String js_id = mr.getParameter("js_id");
			String js_pw = mr.getParameter("js_pw");
			String js_name = mr.getParameter("js_name");
			String js_email = mr.getParameter("js_email");
			String js_addr = mr.getParameter("js_addr");
			String js_photo = mr.getFilesystemName("js_photo");
			js_photo = URLEncoder.encode(js_photo, "UTF-8");
			js_photo = js_photo.replace("+", " ");

			m = new Member(js_id, js_pw, js_name, js_email, js_addr, js_photo);
			
			if (ss.getMapper(MemberMapper.class).reg(m)==1) {
				req.setAttribute("r", "등록성공");
			}
		} catch (Exception e) {
			req.setAttribute("r", "등록실패");
			e.printStackTrace();
		}
		
	}

	public void login(Member m,HttpServletRequest req,HttpServletResponse res){
		try {
			Member m2 = ss.getMapper(MemberMapper.class).getMemberById(m);

			if (m2!=null) {
				if (m2.getJs_pw().equals(m.getJs_pw())) {
					req.getSession().setAttribute("loginMember", m2);
					req.getSession().setMaxInactiveInterval(15 * 60);
					
					String js_auto = req.getParameter("js_auto");
					if (js_auto != null) {
						Cookie autoLoginID = new Cookie("autoLoginID", m2.getJs_id());
						autoLoginID.setMaxAge(1 * 60 * 60 * 24);
						res.addCookie(autoLoginID);
					}
				}else {
					req.setAttribute("r", "비밀번호 오류");
				}
			}else {
				req.setAttribute("r", "ID 오류");
			}
		} catch (Exception e) {
			req.setAttribute("r", "DB서버  오류");
			e.printStackTrace();
		}finally {
		}
	}
	
	public boolean loginCheck(HttpServletRequest req,HttpServletResponse res){
		Member m = (Member) req.getSession().getAttribute("loginMember");
		
		if (m!=null) {
			req.setAttribute("loginPage", "Member/loginOK.jsp");
			return true;
		}
		req.setAttribute("loginPage", "Member/login.jsp");
		return false;
	}

	public void autologin(Member m,HttpServletRequest req, HttpServletResponse res) {
		Cookie[] cookies = req.getCookies();

		if (cookies != null) { // 쿠키 있으면 실행
			for (Cookie c : cookies) {
				if (c.getName().equals("autoLoginID")) {
					String js_id = c.getValue();
					if (js_id != null && js_id != "") {
						Member m2  = ss.getMapper(MemberMapper.class).getMemberById(m);
						
						if (m2 != null) {
							req.getSession().setAttribute("loginMember", m2);
							req.getSession().setMaxInactiveInterval(15*60*60*60);
						}else {
							req.setAttribute("r", "아이디오류");
						}
					}
				}
				break;
			}
		}
	}

	public void logout(HttpServletRequest req, HttpServletResponse res) {
		req.getSession().setAttribute("loginMember", null);

		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("autoLoginID")) {
					c.setValue(null);
					res.addCookie(c);
				}
			}
		}
	}

	public void update(HttpServletRequest req, HttpServletResponse res){
		try {
		String path = req.getSession().getServletContext().getRealPath("resources/img");
		MultipartRequest mr = new MultipartRequest(req, path, 30*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
		
		String js_id = mr.getParameter("js_id");
		String js_pw = mr.getParameter("js_pw");
		String js_name = mr.getParameter("js_name");
		String js_email = mr.getParameter("js_email");
		String js_addr = mr.getParameter("js_addr");
		String js_photo = mr.getFilesystemName("js_photo");
		js_photo = URLEncoder.encode(js_photo, "UTF-8");
		js_photo = js_photo.replace("+", " ");
		
		Member m = new Member(js_id, js_pw, js_name, js_email, js_addr, js_photo);
		if (ss.getMapper(MemberMapper.class).updateMember(m)==1) {
			req.setAttribute("r", "업데이트 성공");
			req.getSession().setAttribute("loginMember", m);
			req.getSession().setMaxInactiveInterval(15 * 60);
		}
		System.out.println(js_id);
		System.out.println(js_pw);
		System.out.println(js_name);
		} catch (IOException e) {
			req.setAttribute("r", "업데이트 실패");
			e.printStackTrace();
		}
	}
	
	public void delete(Member m,HttpServletRequest req,HttpServletResponse res){
		try {
			if (ss.getMapper(MemberMapper.class).deleteMember(m)==1) {
				req.setAttribute("r", "삭제성공");
			}
		} catch (Exception e) {
			req.setAttribute("r", "삭제실패");
			e.printStackTrace();
		}
	}

	public Members getAllJSON(Member m,HttpServletRequest req,HttpServletResponse res){
		Member m1 = ss.getMapper(MemberMapper.class).getMemberById(m);
		ArrayList<Member>al = new ArrayList<Member>();
		al.add(m1);
		Members m2 = new Members(al);
		return m2;
		
	} 
}
