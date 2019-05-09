package com.kyle.jscbpm.weather;

public class Weather {
	private String description;
	private String icon;
	private double temp;
	private double humidity;

	public Weather() {
		// TODO Auto-generated constructor stub
	}

	public Weather(String description, String icon, double temp, double humidity) {
		super();
		this.description = description;
		this.icon = icon;
		this.temp = temp;
		this.humidity = humidity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

}
