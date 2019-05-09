package com.kyle.jscbpm.dataRoom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kyle.jscbpm.member.MemberDAO;
import com.kyle.jscbpm.weather.WeatherDAO;

@Controller
public class DataController {

	@Autowired MemberDAO mdao;
	@Autowired DataDAO ddao;
	
	@RequestMapping(value = "/go.data", method = RequestMethod.GET)
	public String goData(HttpServletRequest req, HttpServletResponse res) {
		mdao.loginCheck(req, res);
		ddao.getAllFile(req, res);
		WeatherDAO.getWeather(req, res);
		req.setAttribute("contentPage", "dataRoom/data.jsp");
		return "index";
	}
	@RequestMapping(value = "/go.upload", method = RequestMethod.POST)
	public String goUpload(HttpServletRequest req, HttpServletResponse res) {
		mdao.loginCheck(req, res);
		ddao.upload(req, res);
		ddao.getAllFile(req, res);
		WeatherDAO.getWeather(req, res);
		req.setAttribute("contentPage", "dataRoom/data.jsp");
		return "index";
	}
	@RequestMapping(value = "/delete.data", method = RequestMethod.GET)
	public String deleteData(Data d,HttpServletRequest req, HttpServletResponse res) {
		mdao.loginCheck(req, res);
		ddao.deleteData(d, req, res);
		ddao.getAllFile(req, res);
		WeatherDAO.getWeather(req, res);
		req.setAttribute("contentPage", "dataRoom/data.jsp");
		return "index";
	}
}
