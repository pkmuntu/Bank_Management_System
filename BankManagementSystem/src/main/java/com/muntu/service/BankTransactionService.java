package com.muntu.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.muntu.bo.BankTransactionBO;
import com.muntu.dao.IBankTransactionDAO;
import com.muntu.dto.BankTransactionDTO;

@Service("txService")
public class BankTransactionService implements IBankTransactionService {
	
	@Autowired
	@Qualifier("txDAO")
	private IBankTransactionDAO dao;

	@Override
	public String depositAmountByCardNo(Long cardNo, float amount) throws Exception {
		try {
			int count =dao.amountDeposit(cardNo, amount);
			return (count==1)?"Amount deposit successfully":"Amount deposit failed";
		}catch(Exception e) {
			throw e;
		}
		
	}

	@Override
	public String withdrawalAmountByCardNo(Long cardNo, float amount) throws Exception {
		try {
			int count =dao.amountWithdrawal(cardNo, amount);
			return (count==1)?"Amount withdrawal successfully":"Amount withdrawal failed";
		}catch(SQLException s) {
			throw s;
		}
		catch(Exception e) {
			throw e;
		}
	}

	@Override
	public Float checkAmountByCardNo(Long cardNo) throws Exception {
		try {
			return dao.amountCheck(cardNo);
		}catch(Exception e) {
			throw e;
		}
	}



	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false,timeout = 10,rollbackFor = java.sql.SQLException.class)
	public String AmountTransafer(Long sourceCardNo, int TargetAccountNo, Float amount) throws Exception {
		int count1=dao.amountWithdrawal(sourceCardNo, amount);
		int count2=dao.amountDepositByAccountNo(TargetAccountNo, amount);
		if(count1==0||count2==0)
			throw new SQLException("Problem in money transfer!");
		else
			return "Amount transfer successfully";
	}

	@Override
	public String changePinByCardNo(Long cardNo, int pin) throws Exception {
		int count=dao.pinChange(cardNo, pin);
		return (count==1)?"Pin Change successfully":"Pin Change failed";
	}

	@Override
	public List<BankTransactionDTO> getTransactionDetailsByCardNo(Long cardNo) throws Exception {
		List<BankTransactionBO> listBO=null;
		List<BankTransactionDTO> listDTO=new ArrayList<BankTransactionDTO>();
		//use dao
		listBO=dao.MiniStatement(cardNo);
		//convert listBO to listDTO
		listBO.forEach(bo->{
			BankTransactionDTO dto=new BankTransactionDTO();
			BeanUtils.copyProperties(bo, dto);
			listDTO.add(dto);
		});
		return listDTO;
	}

}
