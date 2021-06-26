package com.muntu.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Amount {
	private float amount;
    private String vflag="NO";
}
