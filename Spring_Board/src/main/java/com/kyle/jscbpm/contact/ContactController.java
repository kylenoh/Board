package com.kyle.jscbpm.contact;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kyle.jscbpm.member.MemberDAO;
import com.kyle.jscbpm.weather.WeatherDAO;

@Controller
public class ContactController {

	@Autowired MemberDAO mdao;
	
	@RequestMapping(value = "/go.contact", method = RequestMethod.GET)
	public String index(HttpServletRequest req, HttpServletResponse res) {
		mdao.loginCheck(req, res);
		WeatherDAO.getWeather(req, res);
		req.setAttribute("contentPage", "contact/contact.jsp");
		return "index";
	}
}
