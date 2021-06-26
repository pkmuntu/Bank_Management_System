package com.muntu.dao;

import java.util.List;

import com.muntu.bo.BankTransactionBO;

public interface IBankTransactionDAO {
	public int amountDeposit(Long cardNo,float amount) throws Exception;

	public int amountWithdrawal(Long cardNo,float amount) throws Exception;

	public Float amountCheck(Long cardNo) throws Exception;
	
	public int amountDepositByAccountNo(int accountNo,float amount);

	public int pinChange(Long cardNo,int pin) throws Exception;

	public List<BankTransactionBO> MiniStatement(Long CardNo) throws Exception;
}
