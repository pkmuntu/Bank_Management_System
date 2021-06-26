package com.muntu.service;

import com.muntu.dto.AccountDetailsDTO;
import com.muntu.dto.AccountDetailsDTO2;
import com.muntu.dto.CardDetailsDTO;
import com.muntu.dto.LoginUserDTO;

public interface IAccountSignupSignInService {
	public int saveAccountDetailsService(AccountDetailsDTO dto) throws Exception;

	public CardDetailsDTO saveAccountDetails2Service(AccountDetailsDTO2 dto) throws Exception;
  
	public int LoginService(LoginUserDTO dto) throws Exception;
}
