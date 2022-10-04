package com.varxyz.jungBanking.Controller.account;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.varxyz.jungBanking.Domain.Account;
import com.varxyz.jungBanking.Domain.Customer;
import com.varxyz.jungBanking.Service.AccountServiceImp;

@Controller
public class GetAllAccountController {
	
	@Autowired
	AccountServiceImp accountService;
	
	@GetMapping("/account/balance") 
		public String getAllAccount(HttpSession session, HttpServletRequest request) {
		Customer customer = (Customer)session.getAttribute("customer");
		if (customer == null) {
			request.setAttribute("msg", "로그인이 필요합니다.");
			request.setAttribute("url", "/jungBanking/login/login");
			return "alert";
		}
		List<Account> accountList = accountService.getAccountByCustomerId(customer.getCid());
		request.setAttribute("accountList", accountList);
		
		return "account/balance";
		}
	
}
