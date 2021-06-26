package com.muntu.dto;


import java.sql.Date;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BankTransactionDTO {
	private Long transactionId;
	private Long accountNo;
	private Date date;
	private String mode;
	private Float amount;
}
