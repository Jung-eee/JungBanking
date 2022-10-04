package com.varxyz.jungBanking.Controller.account;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.jungBanking.Domain.Account;
import com.varxyz.jungBanking.Domain.Customer;
import com.varxyz.jungBanking.Service.AccountServiceImp;

@Controller
public class AddAccountController {
	
	@Autowired
	AccountServiceImp accountService;
	
	@GetMapping("/account/add_account")
	public String addAccountForm(HttpServletRequest request, HttpSession session) {
		Customer customer = (Customer)session.getAttribute("customer");
		if (customer == null) {
			request.setAttribute("msg", "로그인이 필요합니다.");
			request.setAttribute("url", "/jungBanking/login/login");
			return "alert";
		}
		return"account/add_account";
	}
	@PostMapping("/account/add_account")
	public String addAccount(HttpServletRequest request, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customer");
		
		Account account = new Account();
		account.setCustomerId(customer.getCid());
		account.setAccountNum(generateAccount());
		int result = accountService.addAcount(account);
		if (result == 0 ) {
			request.setAttribute("msg", "생성오류");
			request.setAttribute("url", "add_account");
			return "alert";
		}
		request.setAttribute("account", account);
		
		return "account/sus_add_account";
	}
	@GetMapping("/account/sus_add_account")
	public String susAddAccount() {
		return "account/sus_add_account";
	}
	
	//계좌번호 랜덤생성 
	public String generateAccount() {
		String numStr = String.valueOf((int)(Math.random() * 100000000));
	   StringBuilder sb = new StringBuilder();
	   sb.append(numStr.substring(0, 3));
	   sb.append("-");
	   sb.append(numStr.substring(3, 5));
	   sb.append("-");
	   sb.append(numStr.substring(5));
	      
	   return sb.toString();
	}
}
