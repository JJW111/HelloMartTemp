package com.hellomart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
	private String postCode;
	private String roadAddress;
	private String jibunAddress;
	private String detailAddress;
}
