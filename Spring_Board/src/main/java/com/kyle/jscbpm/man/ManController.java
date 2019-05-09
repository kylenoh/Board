package com.kyle.jscbpm.man;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kyle.jscbpm.member.MemberDAO;
import com.kyle.jscbpm.weather.WeatherDAO;

@Controller
public class ManController {
	
	@Autowired MemberDAO mdao;
	@Autowired ManDAO adao;
	
	@RequestMapping(value = "/run.man", method = RequestMethod.GET)
	public String Man(HttpServletRequest req, HttpServletResponse res) {
		mdao.loginCheck(req, res);
		adao.paging(1, req, res);
		adao.clearSearch(req, res);
		WeatherDAO.getWeather(req, res);
		req.setAttribute("contentPage", "Man/Mens.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/go.writeMan", method = RequestMethod.POST)
	public String writeMan(HttpServletRequest req, HttpServletResponse res) {
		mdao.loginCheck(req, res);
		adao.writeMan(req, res);
		adao.paging(1, req, res);
		adao.clearSearch(req, res);
		WeatherDAO.getWeather(req, res);
		req.setAttribute("contentPage", "Man/Mens.jsp");
		return "index";
	}
	@RequestMapping(value = "/page.change", method = RequestMethod.GET)
	public String pageChange(HttpServletRequest req, HttpServletResponse res) {
		mdao.loginCheck(req, res);
		adao.paging(Integer.parseInt(req.getParameter("p")), req, res);
		adao.clearSearch(req, res);
		WeatherDAO.getWeather(req, res);
		req.setAttribute("contentPage", "Man/Mens.jsp");
		return "index";
	}
	@RequestMapping(value = "/mens.search", method = RequestMethod.GET)
	public String search(Man m,HttpServletRequest req, HttpServletResponse res) {
		mdao.loginCheck(req, res);
		adao.search(m, req, res);
		adao.paging(1, req, res);
		adao.clearSearch(req, res);
		WeatherDAO.getWeather(req, res);
		req.setAttribute("contentPage", "Man/Mens.jsp");
		return "index";
	}
	@RequestMapping(value = "/go.delMan", method = RequestMethod.GET)
	public String delete(HttpServletRequest req, HttpServletResponse res) {
		mdao.loginCheck(req, res);
		adao.delete(req, res);
		adao.clearSearch(req, res);
		adao.paging(1, req, res);
		WeatherDAO.getWeather(req, res);
		req.setAttribute("contentPage", "Man/Mens.jsp");
		return "index";
	}
}
