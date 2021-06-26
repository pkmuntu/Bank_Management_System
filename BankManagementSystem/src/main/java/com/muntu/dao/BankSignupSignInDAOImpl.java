package com.muntu.dao;

import java.sql.Date;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.muntu.bo.AccountDetailsBO;
import com.muntu.bo.AccountDetailsBO2;
import com.muntu.bo.CardDetailsBO;
import com.muntu.bo.LoginUserBO;

@Repository("signupDAO")
public class BankSignupSignInDAOImpl implements IBankSignupSignInDAO {
	
	private static final String LOGIN_USER_QUERY="SELECT COUNT(*) FROM ACCOUNT_DETAILS WHERE CARDNO=:cardNo AND PIN=:pin";
    
	@Autowired
	private JdbcTemplate template;
	
	@Autowired
	private NamedParameterJdbcTemplate njt;
	
	

	@Override
	public int saveAccountDetails(AccountDetailsBO bo) throws Exception {
		try {
			// prepare Map object col names and value
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("ACCOUNTNO", bo.getAccountNo());
			map.put("FNAME", bo.getFName());
			map.put("MNAME", bo.getMiddleName());
			map.put("LNAME", bo.getLName());
			Date sqlDate=new Date(bo.getDob().getTime());
			map.put("DOB", sqlDate);
			map.put("GENDER", bo.getGender());
			map.put("EMAIL", bo.getEmail());
			map.put("MARITAL", bo.getMarital());
			map.put("ADDRESS", bo.getAddr());
			map.put("CITY", bo.getCity());
			map.put("PIN", bo.getPinCode());
			map.put("STATE", bo.getState());
			//create simpleJdbcInsert object
			SimpleJdbcInsert sji=new SimpleJdbcInsert(template);
			// SET table name
			sji.withTableName("BANK_DETAILS");
			// execute query
			int count = sji.execute(map);
			if (count == 1)
				return  (int) map.get("ACCOUNTNO");
			else
				throw new IllegalArgumentException("Internal problem --try again");
		
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public int saveAccountDetails2(AccountDetailsBO2 bo) throws Exception {

		try {
			// prepare map object having accountDetails
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("ACCOUNTNO", bo.getAccountNo());
			map.put("RELIGION", bo.getReligion());
			map.put("CATEGORY", bo.getCategory());
			map.put("INCOME", bo.getIncome());
			map.put("EDUCATION", bo.getEducation());
			map.put("OCCUPATION", bo.getOccupation());
			map.put("PAN", bo.getPan());
			map.put("AADHAR", bo.getAadhar());
			map.put("SCITIZEN", bo.getScitizen());
			map.put("EACCOUNT", bo.getEaccount());
			//create simpleJdbcInsert object
			SimpleJdbcInsert sji=new SimpleJdbcInsert(template);
			// SET TABLE NAME
			sji.withTableName("BANK_ADDITIONAL_DETAILS");
			// execute query
			int count = sji.execute(map);
		  
			if (count == 1)
				return bo.getAccountNo();
			else
				throw new IllegalAccessException("Internal problem--try again");
		
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public CardDetailsBO saveCardDetails(int accountNo, String accountType) throws Exception {
		CardDetailsBO bo = new CardDetailsBO();
		bo.setPin((int) (Math.random() * 9000) + 1000);
		bo.setAccountType(accountType);
		bo.setAccountNo( accountNo);
		bo.setCardNo(ThreadLocalRandom.current().nextLong(1000_0000_0000_0000L, 9999_9999_9999_9999L+1));

		try {
			// prepare map object
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("CARDNO", bo.getCardNo());
			map.put("ACCOUNTNO", accountNo);
			map.put("ACCOUNTTYPE", accountType);
			map.put("PIN", bo.getPin());
			map.put("AMOUNT",0.0f);
			//create simpleJdbcInsert object
			SimpleJdbcInsert sji=new SimpleJdbcInsert(template);
			// SET Table name
			sji.withTableName("ACCOUNT_DETAILS");
			// execute query
			int count = sji.execute(map);
			if (count == 1)
				return bo;
			else
				throw new IllegalAccessException("Internal problem--try again");
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public int singnInByUserAndPassword(LoginUserBO bo) throws Exception{
		try {
		MapSqlParameterSource  msps=new MapSqlParameterSource();
		msps.addValue("cardNo",bo.getCardNo()); //namedparam, value
		msps.addValue("pin",bo.getPin());
		int count=njt.queryForObject(LOGIN_USER_QUERY,msps,Integer.class);
		return count;
		} catch (Exception e) {
			throw e;
		}
	}

}
