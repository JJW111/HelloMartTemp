package com.hellomart.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Account {
	private String id;
	private String password;
	private String role;
	private int points;
	private int grade;
	private String eMail;
	private String postCode;
	private String roadAddress;
	private String jibunAddress;
	private String detailAddress;
	private String phone;
	private String name;
	private String birthYear;
	private String birthMonth;
	private String birthDay;
	private char gender;
	private int reliability;
	private Timestamp joinDate;
}
