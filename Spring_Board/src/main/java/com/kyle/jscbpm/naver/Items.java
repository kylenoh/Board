package com.kyle.jscbpm.naver;

public class Items {
	private String title;
	private String image;
	private String link;
	private String lprice;
	private String hprice;
	
	public Items() {
		// TODO Auto-generated constructor stub
	}

	public Items(String title, String image, String link, String lprice, String hprice) {
		super();
		this.title = title;
		this.image = image;
		this.link = link;
		this.lprice = lprice;
		this.hprice = hprice;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getLprice() {
		return lprice;
	}

	public void setLprice(String lprice) {
		this.lprice = lprice;
	}

	public String getHprice() {
		return hprice;
	}

	public void setHprice(String hprice) {
		this.hprice = hprice;
	}


}
