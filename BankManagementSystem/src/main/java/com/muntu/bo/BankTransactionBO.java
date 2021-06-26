package com.muntu.bo;


import java.sql.Date;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BankTransactionBO {
	private Long transactionId;
	private Long accountNo;
	private Date date;
	private String mode;
	private Float amount;
}
