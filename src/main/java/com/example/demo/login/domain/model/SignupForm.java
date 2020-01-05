package com.example.demo.login.domain.model;

import java.util.Date;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SignupForm {

	@NotBlank
	@Email
	private String userId;

	@NotBlank
	@Length(min=4, max=100)
	@Pattern(regexp="[a-zA-Z0-9]+$")
	private String password;

	@NotBlank
	private String userName;

	@NotNull
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date birthday;

	@Range(min=20, max=200)
	private int age;

	@AssertFalse
	private boolean marrige;

}
