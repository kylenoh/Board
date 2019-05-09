package com.kyle.jscbpm.weather;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class WeatherDAO {
	
	public static void getWeather(HttpServletRequest req, HttpServletResponse res){
		try {
		
		URL u = new URL("http://api.openweathermap.org/data/2.5/weather?q=Seoul&units=metric&appid=baff8f3c6cbc28a4024e336599de28c4&lang=kr");
		HttpURLConnection huc =(HttpURLConnection) u.openConnection();
		InputStream is = huc.getInputStream();
		InputStreamReader isr = new InputStreamReader(is,"UTF-8");

		JSONParser jp = new JSONParser();
		JSONObject jo = (JSONObject) jp.parse(isr);
		Weather w = new Weather();
		
		JSONArray weather = (JSONArray) jo.get("weather");
		JSONObject weather2 = (JSONObject) weather.get(0);
		JSONObject main = (JSONObject) jo.get("main");
		w.setDescription((String) weather2.get("description"));
		w.setIcon((String) weather2.get("icon"));
		w.setTemp(Double.parseDouble(main.get("temp").toString()));
		w.setHumidity(Double.parseDouble(main.get("humidity").toString()));
		req.setAttribute("w", w);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
