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
	private Address address;
	private String phone;
	private String name;
	private BirthDate birthDate;
	private char gender;
	private int reliability;
	private Timestamp joinDate;
}
