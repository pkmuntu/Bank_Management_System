package com.muntu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.muntu.bo.BankTransactionBO;

@Repository("txDAO")
public class BankTransactionImplDAO implements IBankTransactionDAO {

	private static final String DEPOSIT_AMOUNTBYCARDNO_QUERY = "UPDATE ACCOUNT_DETAILS SET AMOUNT=AMOUNT+:amount WHERE CARDNO=:cardNo";
	private static final String WITHDRAWAL_AMOUNTBYCARDNO_QUERY = "UPDATE ACCOUNT_DETAILS SET AMOUNT=AMOUNT-:amount WHERE CARDNO=:cardNo";
	private static final String CHECK_AMOUNTBYCARDNO_QUERY = "SELECT AMOUNT FROM ACCOUNT_DETAILS WHERE CARDNO=:cardNo";
	private static final String INSER_TXDETAILS_QUERY = "INSERT INTO BANK_TRANSACTION(TRANSACTIONID,ACCOUNTNO,TDATE,TMODE,AMOUNT) VALUES(BANK_TX_SEQ.NEXTVAL,:accountNo,SYSDATE,:tMode,:amount)";
	private static final String SELECT_ACCOUNTNO_QUERY = "SELECT ACCOUNTNO FROM ACCOUNT_DETAILS WHERE CARDNO=:cardNo";
	private static final String DEPOSIT_AMOUNTBYACCOUNTNO_QUERY = "UPDATE ACCOUNT_DETAILS SET AMOUNT=AMOUNT+:amount WHERE ACCOUNTNO=:accountNo";
	private static final String UPDATE_PINBYCARDNO_QUERY = "UPDATE ACCOUNT_DETAILS SET PIN=:pin WHERE CARDNO=:cardNo";
	private static final String SELECT_TRANSACTION_DETAILSBYCARDNO_QUERY = "SELECT TRANSACTIONID,TDATE,TMODE,AMOUNT FROM BANK_TRANSACTION WHERE ACCOUNTNO=:accountNo AND ROWNUM<=5 ORDER BY TDATE DESC";

	@Autowired
	private NamedParameterJdbcTemplate npjt;

	@Override
	public int amountDeposit(Long cardNo, float amount) throws Exception {
		try {

			MapSqlParameterSource msps = new MapSqlParameterSource();
			msps.addValue("cardNo", cardNo); // named param, value
			msps.addValue("amount", amount);
			int accountNo = npjt.queryForObject(SELECT_ACCOUNTNO_QUERY, msps, Integer.class);
			msps.addValue("accountNo", accountNo);
			msps.addValue("tMode", 'D');
			int count = npjt.update(DEPOSIT_AMOUNTBYCARDNO_QUERY, msps);
			npjt.update(INSER_TXDETAILS_QUERY, msps);
			return count;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public int amountWithdrawal(Long cardNo, float amount) throws Exception {
		try {
			MapSqlParameterSource msps = new MapSqlParameterSource();
			msps.addValue("cardNo", cardNo); // named param, value
			Float sourceAmount = npjt.queryForObject(CHECK_AMOUNTBYCARDNO_QUERY, msps, Float.class);
			if (sourceAmount - amount <= 0)
				throw new SQLException("Your account have low balance::" + sourceAmount);
			msps.addValue("amount", amount);
			int accountNo = npjt.queryForObject(SELECT_ACCOUNTNO_QUERY, msps, Integer.class);
			msps.addValue("accountNo", accountNo);
			msps.addValue("tMode", 'W');
			int count = npjt.update(WITHDRAWAL_AMOUNTBYCARDNO_QUERY, msps);
			npjt.update(INSER_TXDETAILS_QUERY, msps);
			return count;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Float amountCheck(Long cardNo) throws Exception {
		try {
			MapSqlParameterSource msps = new MapSqlParameterSource();
			msps.addValue("cardNo", cardNo); // named param, value
			Float amount = npjt.queryForObject(CHECK_AMOUNTBYCARDNO_QUERY, msps, Float.class);
			return amount;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public int amountDepositByAccountNo(int accountNo, float amount) {
		try {

			MapSqlParameterSource msps = new MapSqlParameterSource();
			msps.addValue("accountNo", accountNo); // named param, value
			msps.addValue("amount", amount);
			msps.addValue("tMode", 'D');
			int count = npjt.update(DEPOSIT_AMOUNTBYACCOUNTNO_QUERY, msps);
			npjt.update(INSER_TXDETAILS_QUERY, msps);
			return count;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public int pinChange(Long cardNo, int pin) throws Exception {
		try {

			MapSqlParameterSource msps = new MapSqlParameterSource();
			msps.addValue("cardNo", cardNo); // named param, value
			msps.addValue("pin", pin);
			int count = npjt.update(UPDATE_PINBYCARDNO_QUERY, msps);
			return count;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<BankTransactionBO> MiniStatement(Long cardNo) throws Exception {
		try {
			MapSqlParameterSource msps = new MapSqlParameterSource();
			// named param, value
			msps.addValue("cardNo", cardNo);
			int accountNo = npjt.queryForObject(SELECT_ACCOUNTNO_QUERY, msps, Integer.class);
			msps.addValue("accountNo", accountNo);

			List<BankTransactionBO> listBO1 = null;
			listBO1 = npjt.query(SELECT_TRANSACTION_DETAILSBYCARDNO_QUERY, msps, rs -> {
				                                                                                                                                                                  List<BankTransactionBO> listBO = null;
				                                                                                                                                                                  BankTransactionBO bo = null;
				                                                                                                                                                                  // copy rs object to List of BankTransactionBo
				                                                                                                                                                                  listBO = new ArrayList<BankTransactionBO>();
				                                                                                                                                                                  while (rs.next()) {
				                                                                                                                                                                	  // get each record into BAnkTarnsactionBO
				                                                                                                                                                                	  bo = new BankTransactionBO();
				                                                                                                                                                                	  bo.setTransactionId(rs.getLong(1));
				                                                                                                                                                                	  bo.setDate(rs.getDate(2));
				                                                                                                                                                                	  bo.setMode(rs.getString(3));
				                                                                                                                                                                	  bo.setAmount(rs.getFloat(4));
				                                                                                                                                                                	  listBO.add(bo);
				                                                                                                                                                                  } // while
				                                                                                                                                                                  return listBO;
																																									});
			return listBO1;
		} catch (Exception e) {
			throw e;
		}
	}

}
