package com.bwf.entity;

import java.util.List;

public class User {
	
	private int userId;
	private String username;
	private String password;
	private String nickname;
	private String avater;
	private List<Menu> menus;	
	private List<Operate> operates;
	
	
	public List<Operate> getOperates() {
		return operates;
	}
	public void setOperates(List<Operate> operates) {
		this.operates = operates;
	}
	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAvater() {
		return avater;
	}
	public void setAvater(String avater) {
		this.avater = avater;
	}

	
	
		

}
