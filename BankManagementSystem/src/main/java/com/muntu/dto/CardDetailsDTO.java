package com.muntu.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CardDetailsDTO {
	private Long CardNo;
	private int accountNo;
	private String accountType;
	private Integer pin;
}
