package com.muntu.dto;



import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountDetailsDTO {
    private int accNo;
	private String fName;
	private String middleName;
	private String lName;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date dob;
	private String gender;
	private String email;
	private String marital;
	private String addr;
	private String city;
	private Integer pinCode;
	private String state;
	private  String vflag="no";
}
