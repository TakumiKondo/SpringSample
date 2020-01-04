package com.example.demo.trySample;

import lombok.Data;

@Data
public class Employee {
    private int id;
    private String name;
    private Age age;

    int age() {
    	return age.howOld();
    }
}
