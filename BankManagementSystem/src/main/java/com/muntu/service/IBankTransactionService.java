package com.muntu.service;

import java.util.List;

import com.muntu.dto.BankTransactionDTO;

public interface IBankTransactionService {

	public String depositAmountByCardNo(Long cardNo, float amount) throws Exception;

	public String withdrawalAmountByCardNo(Long cardNo, float amount) throws Exception;

	public Float checkAmountByCardNo(Long cardNo) throws Exception;
	
	public String AmountTransafer(Long sourceCardNo,int accountNo,Float amount) throws Exception;
	
	public String changePinByCardNo(Long cardNo,int pin) throws Exception;
	
	public List<BankTransactionDTO> getTransactionDetailsByCardNo(Long cardNo) throws Exception;
}
