package com.kyle.jscbpm.naver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

@Service
public class NaverDAO {

	public void callNaver(HttpServletRequest req, HttpServletResponse res) {
		try {
			
			String query = req.getParameter("query");
			query = URLEncoder.encode(query, "UTF-8");

			int display = 10;
			int start = 1;

			URL u = new URL("https://openapi.naver.com/v1/search/shop.json?query=" + query + "&display=" + display
					+ "&start=" + start);
			HttpURLConnection huc = (HttpURLConnection) u.openConnection();
			huc.addRequestProperty("X-Naver-Client-Id", "cQMPDRMmTt2Eum7oJ0RV");
			huc.addRequestProperty("X-Naver-Client-Secret", "JfMmRrQ_S9");

			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			JSONParser jp = new JSONParser();
			JSONObject jo = (JSONObject) jp.parse(br);
			JSONArray ja = (JSONArray) jo.get("items");
			ArrayList<Items>it = new ArrayList<Items>();
			Items i = null;
			JSONObject obc = null;
			for (int j = 0; j < ja.size(); j++) {
				obc = (JSONObject) ja.get(j);
				i = new Items();
				i.setTitle((String)obc.get("title"));
				i.setLink((String)obc.get("link"));
				i.setImage((String)obc.get("image"));
				i.setLprice((String)obc.get("lprice"));
				i.setHprice((String)obc.get("hprice"));
				it.add(i);
			}
			req.setAttribute("items", it);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
