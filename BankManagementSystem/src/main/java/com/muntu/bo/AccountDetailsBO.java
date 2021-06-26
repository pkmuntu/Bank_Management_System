package com.muntu.bo;


import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountDetailsBO {
	private int accountNo;
	private String fName;
	private String middleName;
	private String lName;
	private Date dob;
	private String gender;
	private String email;
	private String marital;
	private String addr;
	private String city;
	private Integer pinCode;
	private String state;
}
