package com.example.demo.trySample;

public class Age {
	private Integer age;

	Age(Integer age){
		if(age.intValue() < 0 || age.intValue() > 200)
			throw new  IllegalArgumentException("年齢が0歳未満または200歳を超えています。");

		this.age = age;
	}

	int howOld() {
		return age.intValue();
	}

}
