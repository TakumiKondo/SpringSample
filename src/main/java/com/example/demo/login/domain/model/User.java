package com.example.demo.login.domain.model;

import java.util.Date;

public class User {
	private String id;
	private String password;
	private String name;
	private Date birthday;
	private int age;
	private boolean marrige;
	private String role;

	public User(String id, String password, String name, Date birthday, int age, boolean marrige, String role){
		this.id = id;
		this.password = password;
		this.name = name;
		this.birthday = birthday;
		this.age = age;
		this.marrige = marrige;
		this.role = role;
	}

	public String id() {
		return id;
	}

	public String password() {
		return password;
	}

	public String name() {
		return name;
	}

	public Date birthday() {
		return birthday;
	}

	public int age() {
		return age;
	}

	public boolean marrige() {
		return marrige;
	}

	public String role() {
		return role;
	}


}
