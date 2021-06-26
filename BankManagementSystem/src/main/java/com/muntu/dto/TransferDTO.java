package com.muntu.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TransferDTO {

	private Float amount;
	private int TargetAccountNo;
	private String vflag="NO";
}
