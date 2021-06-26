package com.muntu.dao;

import com.muntu.bo.AccountDetailsBO;
import com.muntu.bo.AccountDetailsBO2;
import com.muntu.bo.CardDetailsBO;
import com.muntu.bo.LoginUserBO;

public interface IBankSignupSignInDAO {
	public int  saveAccountDetails(AccountDetailsBO bo) throws Exception;

	public int  saveAccountDetails2(AccountDetailsBO2 bo) throws Exception;

	public CardDetailsBO  saveCardDetails(int accountNo,String accountType) throws Exception;
	
	public int singnInByUserAndPassword(LoginUserBO bo) throws Exception;
}
