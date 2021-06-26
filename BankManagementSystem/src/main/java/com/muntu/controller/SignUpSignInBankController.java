package com.muntu.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.muntu.dto.AccountDetailsDTO;
import com.muntu.dto.AccountDetailsDTO2;
import com.muntu.dto.CardDetailsDTO;
import com.muntu.dto.LoginUserDTO;
import com.muntu.service.IAccountSignupSignInService;

@Controller
public class SignUpSignInBankController {

	@Autowired
	@Qualifier("signupService")
	private IAccountSignupSignInService service;

	@GetMapping("/welcome")
	public String showHomePage() {
		// return lvn
		return "homePageDef";
	}

	@GetMapping("/signup")
	public String signupPage(@ModelAttribute AccountDetailsDTO dto) {
		// return lvn
		return "signupPageDef";
	}

	@PostMapping("/signup")
	public String signupPage2(Map<String, Object> map, @ModelAttribute AccountDetailsDTO dto,
			@ModelAttribute AccountDetailsDTO2 dto2) {
		try {
			// call b.mehod
			int accNo = service.saveAccountDetailsService(dto);
			map.put("accNo", accNo);
			dto2.setAccountNo(accNo);
			// return lvn
			return "signupPageDef2";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	@RequestMapping("/signup2")
	public String signupPage3(Map<String, Object> map, @ModelAttribute("accountDetailsDTO2") AccountDetailsDTO2 dto) {
		try {
			// call b.mehod
			CardDetailsDTO cdto = service.saveAccountDetails2Service(dto);
			map.put("cdto", cdto);
			
			// return lvn
			return "signupPageDef3";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	@GetMapping("/signin")
	public String signin(Map<String, Object> map, @ModelAttribute("loginUserDTO") LoginUserDTO dto) {
		map.put("errMsg", "");
		return "signinPageDef";

	}

	@PostMapping("/signinProcess")
	public String signinProcess(HttpServletRequest req,Map<String, Object> map, @ModelAttribute("loginUserDTO") LoginUserDTO dto) {
		try {
			int count = service.LoginService(dto);
			if (count != 0) {
				// return lvn
				HttpSession session = req.getSession();
		        session.setAttribute("cardNo",dto.getCardNo());
				return "mainMenuBaseDef";
			} else {
				map.put("errMsg", "Invalid CardNo or Pin-->Try Again");
				return "signinPageDef";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
