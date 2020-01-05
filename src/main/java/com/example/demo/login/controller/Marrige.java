package com.example.demo.login.controller;

import java.util.LinkedHashMap;
import java.util.Map;

public class Marrige {
	private Map<String, String> marrige;

	Marrige(){
		marrige = new LinkedHashMap<>();
		marrige.put("未婚", "false");
		marrige.put("既婚", "true");
	}

}
