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

import com.example.demo.login.domain.model.valid.Required;
import com.example.demo.login.domain.model.valid.ValidPattern;
import com.example.demo.login.domain.model.valid.Value;

import lombok.Data;

@Data
public class SignupForm {

	@NotBlank(groups=Required.class)
	@Email(groups=Value.class)
	private String userId;

	@NotBlank(groups=Required.class)
	@Length(min=4, max=100, groups=Value.class)
	@Pattern(regexp="[a-zA-Z0-9]+$", groups=ValidPattern.class)
	private String password;

	@NotBlank(groups=Required.class)
	private String userName;

	@NotNull(groups=Required.class)
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date birthday;

	@Range(min=20, max=200, groups=Value.class)
	private int age;

	@AssertFalse(groups=Value.class)
	private boolean marrige;

}
