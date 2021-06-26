package com.muntu.bo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CardDetailsBO {
	private Long CardNo;
	private int accountNo;
	private String accountType;
	private Integer pin;
}
