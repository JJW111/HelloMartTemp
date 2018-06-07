package com.hellomart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BirthDate {
	private String year;
	private String month;
	private String day;
}
