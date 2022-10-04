package com.varxyz.jungBanking.Controller.account;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.jungBanking.Domain.Account;
import com.varxyz.jungBanking.Domain.Customer;
import com.varxyz.jungBanking.Service.AccountService;
import com.varxyz.jungBanking.Service.AccountServiceImp;

@Controller
public class DepositController {
	
	@Autowired
	AccountServiceImp accountService;
	
	@GetMapping("/account/deposit")
	public String depositForm(HttpServletRequest request, HttpSession session) {
		Customer customer = (Customer)session.getAttribute("customer");
		if (customer == null) {
			request.setAttribute("msg", "로그인이 필요합니다.");
			request.setAttribute("url", "/jungBanking/login/login");
			return "alert";
		}
		List<Account> accountList = accountService.getAccountByCustomerId(customer.getCid());
		request.setAttribute("accountList", accountList);
		return "account/deposit";
	}
	@PostMapping("account/deposit")
	public String deposit(HttpServletRequest request) {
		String accountNum = request.getParameter("accountNum");
		int depositMoney = Integer.parseInt(request.getParameter("depositMoney"));
		
		if (depositMoney <= 0) {
			request.setAttribute("msg", "0원이하 금액은 입금할 수 없습니다.");
			request.setAttribute("url", "deposit");
			return "alert";
		}
		
		int result = accountService.deposit(accountNum, depositMoney);
		if (result == 0) {
			request.setAttribute("msg", "입금오류입니다.");
			request.setAttribute("url", "deposit");
			return "alert";
		}
		request.setAttribute("accountNum", accountNum);
		request.setAttribute("depositMoney", depositMoney);
		return "account/sus_deposit";
	}
}
