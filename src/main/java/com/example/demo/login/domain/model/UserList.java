package com.example.demo.login.domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class UserList {
	private List<User> userList;

	public UserList(List<Map<String, Object>> users){
		userList = new ArrayList<>();

		for (Map<String, Object> eachUser: users) {
			User user = new User(
					(String)eachUser.get("id")
					,(String)eachUser.get("password")
					,(String)eachUser.get("name")
					,(Date)eachUser.get("birthday")
					,((Integer)eachUser.get("age")).intValue()
					,(Boolean)eachUser.get("marrige")
					,(String)eachUser.get("role")
			);
			userList.add(user);
		}
	}

	public List<User> list(){
		return Collections.unmodifiableList(userList);
	}
}
