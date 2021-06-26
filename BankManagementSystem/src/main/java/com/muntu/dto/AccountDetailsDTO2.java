package com.muntu.dto;

import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountDetailsDTO2 {
	private int accountNo;
	private String religion;
	private String category;
	private Float income;
	private String education;
	private String occupation;
	private String pan;
	private Integer aadhar;
	private String scitizen;
	private String eaccount;
	private String accountType;
    private String vflag="no";
}
