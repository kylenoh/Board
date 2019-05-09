package com.kyle.jscbpm.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kyle.jscbpm.weather.WeatherDAO;

@Controller
public class MemberController {

	@Autowired
	MemberDAO mdao;

	@RequestMapping(value = "/go.join", method = RequestMethod.GET)
	public String Join(HttpServletRequest req, HttpServletResponse res) {
		if (mdao.loginCheck(req, res)) {

		}
		WeatherDAO.getWeather(req, res);
		req.setAttribute("contentPage", "Member/join.jsp");
		return "index";
	}

	@RequestMapping(value = "/go.reg", method = RequestMethod.POST)
	public String reg(Member m, HttpServletRequest req, HttpServletResponse res) {
		if (mdao.loginCheck(req, res)) {

		}
		WeatherDAO.getWeather(req, res);
		mdao.reg(m, req, res);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/chk.login", method = RequestMethod.POST)
	public String login(Member m, HttpServletRequest req, HttpServletResponse res) {
		mdao.login(m, req, res);
		mdao.loginCheck(req, res);
		WeatherDAO.getWeather(req, res);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	@RequestMapping(value = "/go.bye", method = RequestMethod.GET)
	public String Bye(HttpServletRequest req, HttpServletResponse res) {
		mdao.logout(req, res);
		mdao.loginCheck(req, res);
		WeatherDAO.getWeather(req, res);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	@RequestMapping(value = "/go.update", method = RequestMethod.GET)
	public String Update(HttpServletRequest req, HttpServletResponse res) {
		if (mdao.loginCheck(req, res)) {
		}
		WeatherDAO.getWeather(req, res);
		req.setAttribute("contentPage", "Member/detail.jsp");
		return "index";
	}
	@RequestMapping(value = "/run.update", method = RequestMethod.POST)
	public String runUpdate(HttpServletRequest req, HttpServletResponse res) {
		mdao.update(req, res);
		mdao.loginCheck(req, res);
		WeatherDAO.getWeather(req, res);
		req.setAttribute("contentPage", "Member/detail.jsp");
		return "index";
	}
	@RequestMapping(value = "/run.delete", method = RequestMethod.GET)
	public String runDelete(Member m,HttpServletRequest req, HttpServletResponse res) {
		mdao.delete(m, req, res);
		mdao.loginCheck(req, res);
		WeatherDAO.getWeather(req, res);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	@RequestMapping(value = "/member.json", method = RequestMethod.GET, produces="application/json; charset=utf-8")
	public @ResponseBody Members memberJSON(Member m,HttpServletRequest req, HttpServletResponse res) {
		return mdao.getAllJSON(m, req, res);
	}
	
	
}
