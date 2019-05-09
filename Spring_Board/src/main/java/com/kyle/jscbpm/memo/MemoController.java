package com.kyle.jscbpm.memo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kyle.jscbpm.man.ManDAO;
import com.kyle.jscbpm.member.MemberDAO;
import com.kyle.jscbpm.weather.WeatherDAO;

@Controller
public class MemoController {
	
	@Autowired MemberDAO mdao;
	@Autowired MemoDAO wdao;
	@Autowired ManDAO adao;
	
	@RequestMapping(value = "/go.memo", method = RequestMethod.GET)
	public String memo(HttpServletRequest req, HttpServletResponse res) {
		if (mdao.loginCheck(req, res)) {
		}
		wdao.clearSearch(req, res);
		wdao.paging(1, req, res);
		WeatherDAO.getWeather(req, res);
		req.setAttribute("contentPage", "memo.jsp");
		return "index";
	}
	@RequestMapping(value = "/go.write", method = RequestMethod.POST)
	public String Join(HttpServletRequest req, HttpServletResponse res) {
		if (mdao.loginCheck(req, res)) {
			wdao.writeMemo(req, res);
		}
		wdao.paging(1, req, res);
		WeatherDAO.getWeather(req, res);
		req.setAttribute("contentPage", "memo.jsp");
		return "index";
	}
	@RequestMapping(value = "/Memopage.change", method = RequestMethod.GET)
	public String pageChange(HttpServletRequest req, HttpServletResponse res) {
		mdao.loginCheck(req, res);
		wdao.paging(Integer.parseInt(req.getParameter("p")), req, res);
		WeatherDAO.getWeather(req, res);
		req.setAttribute("contentPage", "memo.jsp");
		return "index";
	}
	@RequestMapping(value = "/memo.search", method = RequestMethod.GET)
	public String search(Memo m,HttpServletRequest req, HttpServletResponse res) {
		mdao.loginCheck(req, res);
		wdao.search(m, req, res);
		wdao.paging(1, req, res);
		WeatherDAO.getWeather(req, res);
		req.setAttribute("contentPage", "memo.jsp");
		return "index";
	}
	@RequestMapping(value = "/go.delMemo", method = RequestMethod.GET)
	public String delMemo(Memo m,HttpServletRequest req, HttpServletResponse res) {
		mdao.loginCheck(req, res);
		wdao.delMemo(m, req, res);
		wdao.paging(1, req, res);
		WeatherDAO.getWeather(req, res);
		req.setAttribute("contentPage", "memo.jsp");
		return "index";
	}
	@RequestMapping(value = "/update.Memo", method = RequestMethod.GET)
	public String updateMemo(Memo m,HttpServletRequest req, HttpServletResponse res) {
		mdao.loginCheck(req, res);
		wdao.update(m, req, res);
		wdao.paging(1, req, res);
		WeatherDAO.getWeather(req, res);
		req.setAttribute("contentPage", "memo.jsp");
		return "index";
	}
	@RequestMapping(value = "/write.Reply", method = RequestMethod.GET)
	public String writeReply(Memo m,MemoReply mp,HttpServletRequest req, HttpServletResponse res) {
		mdao.loginCheck(req, res);
		wdao.writeReply(mp, req, res);
		wdao.paging(1, req, res);
		WeatherDAO.getWeather(req, res);
		req.setAttribute("contentPage", "memo.jsp");
		return "index";
	}
	@RequestMapping(value = "/delete.Reply", method = RequestMethod.GET)
	public String deleteReply(Memo m,MemoReply mp,HttpServletRequest req, HttpServletResponse res) {
		mdao.loginCheck(req, res);
		wdao.deleteReply(mp, req, res);
		wdao.paging(1, req, res);
		WeatherDAO.getWeather(req, res);
		req.setAttribute("contentPage", "memo.jsp");
		return "index";
	}
	
}
