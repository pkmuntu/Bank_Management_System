package com.muntu.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.muntu.bo.AccountDetailsBO;
import com.muntu.bo.AccountDetailsBO2;
import com.muntu.bo.CardDetailsBO;
import com.muntu.bo.LoginUserBO;
import com.muntu.dao.IBankSignupSignInDAO;
import com.muntu.dto.AccountDetailsDTO;
import com.muntu.dto.AccountDetailsDTO2;
import com.muntu.dto.CardDetailsDTO;
import com.muntu.dto.LoginUserDTO;

@Service("signupService")
public class AccountSignupSignInServiceImpl implements IAccountSignupSignInService {

	@Autowired
	@Qualifier("signupDAO")
	private IBankSignupSignInDAO dao;

	@Override
	public int saveAccountDetailsService(AccountDetailsDTO dto) throws Exception {
		// prepare AccountDetailsBO class Obj
		try {
			AccountDetailsBO bo = new AccountDetailsBO();
			bo.setAccountNo((int) (Math.random() * 9000) + 1000);
			bo.setFName(dto.getFName());
			bo.setMiddleName(dto.getMiddleName());
			bo.setLName(dto.getLName());
			bo.setDob(dto.getDob());
			bo.setGender(dto.getGender());
			bo.setEmail(dto.getEmail());
			bo.setMarital(dto.getMarital());
			bo.setAddr(dto.getAddr());
			bo.setCity(dto.getCity());
			bo.setPinCode(dto.getPinCode());
			bo.setState(dto.getState());
			int account = dao.saveAccountDetails(bo);
			return account;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public CardDetailsDTO saveAccountDetails2Service(AccountDetailsDTO2 dto) throws Exception {
		// prepare AccountDetailsDTO2 class Obj
		try {
			AccountDetailsBO2 bo = new AccountDetailsBO2();
			bo.setAccountNo(dto.getAccountNo());
			bo.setReligion(dto.getReligion());
			bo.setCategory(dto.getCategory());
			bo.setIncome(dto.getIncome());
			bo.setEducation(dto.getEducation());
			bo.setOccupation(dto.getOccupation());
			bo.setPan(dto.getPan());
			bo.setAadhar(dto.getAadhar());
			bo.setScitizen(dto.getScitizen());
			bo.setEaccount(dto.getEaccount());
			int account = dao.saveAccountDetails2(bo);
			CardDetailsBO cbo = dao.saveCardDetails(dto.getAccountNo(), dto.getAccountType());
			CardDetailsDTO cdto = new CardDetailsDTO();
			BeanUtils.copyProperties(cbo, cdto);
			return cdto;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public int LoginService(LoginUserDTO dto) throws Exception {
		try {
			LoginUserBO bo = new LoginUserBO();
			BeanUtils.copyProperties(dto, bo);
			return dao.singnInByUserAndPassword(bo);

		} catch (Exception e) {
			throw e;
		}
	}

}
