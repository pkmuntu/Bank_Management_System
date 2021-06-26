package com.muntu.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.muntu.dto.Amount;
import com.muntu.dto.BankTransactionDTO;
import com.muntu.dto.TransferDTO;
import com.muntu.service.IBankTransactionService;

@Controller
public class BankTransactionController {

	@Autowired
	@Qualifier("txService")
	private IBankTransactionService service;

	@GetMapping("/main_menu")
	public String showMainPage() {
		// return lvn
		return "mainMenuBaseDef";
	}

	@GetMapping("/deposit")
	public String showdepositPage(@ModelAttribute Amount amount) {
		// return lvn
		return "depositPageDef";
	}
	
	@PostMapping("/deposit_process")
	public String showdepositedPage(HttpServletRequest req, Map<String, Object> map,
			@ModelAttribute Amount amount) {
		try {
			HttpSession session = req.getSession();
			Long cardNo = Long.parseLong( (String) session.getAttribute("cardNo"));
			// return lvn
			String msg = service.depositAmountByCardNo(cardNo, amount.getAmount());
			map.put("msg", msg);
			return "depositProcessPageDef";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}

	@GetMapping("/cash_withdrawal")
	public String showwithdrawalPage(@ModelAttribute Amount amount) {
		// return lvn
		return "withdrawalPageDef";
	}

	@PostMapping("/cash_withdrawal_process")
	public String showwithdrawaledPage(HttpServletRequest req, Map<String, Object> map,
			@ModelAttribute Amount amount) {
		try {
			HttpSession session = req.getSession();
			Long cardNo = Long.parseLong( (String) session.getAttribute("cardNo"));
		
			String msg = service.withdrawalAmountByCardNo(cardNo, amount.getAmount());
			map.put("msg", msg);
			// return lvn
			return "withdrawalProcessPageDef";
		} catch(SQLException s) {
			map.put("msg",s.getMessage());
			return "withdrawalProcessPageDef";
		}
		catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@GetMapping("/balance_enquiry")
	public String showwithdrawaledPage(HttpServletRequest req, Map<String, Object> map) {
		try {
			HttpSession session = req.getSession();
			Long cardNo = Long.parseLong( (String) session.getAttribute("cardNo"));
		
			float amount = service.checkAmountByCardNo(cardNo);
			map.put("amount",amount);
			// return lvn
			return "balanceEnquiryProcessPageDef";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@GetMapping("/transfer_money")
	public String showTransferMoneyPage(@ModelAttribute TransferDTO dto) {
		// return lvn
		return "transferMoneyPageDef";
	}
	
	@PostMapping("/transfer_money_process")
	public String showTransferedMoneyPage(HttpServletRequest req, Map<String, Object> map,@ModelAttribute TransferDTO dto) {
		try {
			HttpSession session = req.getSession();
			Long sourceCardNo = Long.parseLong( (String) session.getAttribute("cardNo"));
		    String msg=service.AmountTransafer(sourceCardNo, dto.getTargetAccountNo(), dto.getAmount());
		    map.put("msg", msg);
			// return lvn
			return "transferMoneyProcessPageDef";
		}catch(SQLException s) {
			map.put("msg", s.getMessage());
			return "transferMoneyProcessPageDef";
		}
		catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@GetMapping("/pin_change")
	public String showPinChangePage() {
		// return lvn
		return "pinChangePageDef";
	}
	
	@GetMapping("/pin_change_process")
	public String showPinChangeProcessPage(HttpServletRequest req, Map<String, Object> map,@RequestParam int pin) {
		try {
			HttpSession session = req.getSession();
			Long cardNo = Long.parseLong( (String) session.getAttribute("cardNo"));
		    String msg=service.changePinByCardNo(cardNo, pin);
		    map.put("msg", msg);
			// return lvn
			return "pinChangeProcessPageDef";
		}
		catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@GetMapping("/mini_statement")
	public String showMiniStatementPage() {
		// return lvn
		return "miniStatementPageDef";
	}
	
	@GetMapping("/getTransaction")
	public String showMiniStatementResultPage(HttpServletRequest req, Map<String, Object> map) {
		try {
			HttpSession session = req.getSession();
			Long cardNo = Long.parseLong( (String) session.getAttribute("cardNo"));
	     	List<BankTransactionDTO> listDTO=null;
	    	listDTO=service.getTransactionDetailsByCardNo(cardNo);
	    	map.put("listDTO", listDTO);
	    	// return lvn
	    	return "miniStatementProcessPageDef";
		}
		catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
}
