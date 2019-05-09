package com.kyle.jscbpm.naver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kyle.jscbpm.man.ManDAO;
import com.kyle.jscbpm.member.MemberDAO;
import com.kyle.jscbpm.memo.MemoDAO;
import com.kyle.jscbpm.weather.WeatherDAO;

@Controller
public class NaverController {
	
	@Autowired MemberDAO mdao;
	@Autowired MemoDAO wdao;
	@Autowired ManDAO adao;
	@Autowired NaverDAO ndao;
	
	@RequestMapping(value = "/go.naver", method = RequestMethod.GET)
	public String goNaver(HttpServletRequest req, HttpServletResponse res) {
		mdao.loginCheck(req, res);
		WeatherDAO.getWeather(req, res);
		req.setAttribute("contentPage", "naver/show.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/search.naver", method = RequestMethod.GET)
	public String searchNaver(HttpServletRequest req, HttpServletResponse res) {
		mdao.loginCheck(req, res);
		ndao.callNaver(req, res);
		WeatherDAO.getWeather(req, res);
		req.setAttribute("contentPage", "naver/show.jsp");
		return "index";
	}
}
