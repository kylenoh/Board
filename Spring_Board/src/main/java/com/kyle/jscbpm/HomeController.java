package com.kyle.jscbpm;

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
public class HomeController {

	@Autowired MemberDAO mdao;
	@Autowired MemoDAO wdao;
	@Autowired ManDAO adao;
	
	private boolean firstReq;
	
	
	public HomeController() {
		// TODO Auto-generated constructor stub
		firstReq = true;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(HttpServletRequest req, HttpServletResponse res) {
		if (firstReq) {
			adao.gettAllMemoCount(req, res);
			wdao.getReviewCount(req, res);
			firstReq = false;
		}
		mdao.loginCheck(req, res);
		WeatherDAO.getWeather(req, res);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/go.index", method = RequestMethod.GET)
	public String index2(HttpServletRequest req, HttpServletResponse res) {

		if (mdao.loginCheck(req, res)) {
		}
		WeatherDAO.getWeather(req, res);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

}
