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
import com.varxyz.jungBanking.Service.AccountServiceImp;
import com.varxyz.jungBanking.Service.CustomerServiceImp;

@Controller
public class transfercontroller {

	@Autowired
	AccountServiceImp accountService;
	
	@Autowired
    CustomerServiceImp customerService;
	
	@GetMapping("/account/transfer")
	public String transferForm(HttpServletRequest request, HttpSession session) {
		Customer customer = (Customer)session.getAttribute("customer");
		if (customer == null) {
			request.setAttribute("msg", "로그인이 필요합니다.");
			request.setAttribute("url", "/jungBanking/login/login");
			return "alert";
		}
		List<Account> accountList = accountService.getAccountByCustomerId(customer.getCid());
		request.setAttribute("accountList", accountList);
		return "account/transfer";
	}
	
	@PostMapping("/account/transfer")
	public String transfer(HttpServletRequest request, HttpSession session) {
		
		String sendingAccount = request.getParameter("sendingAccount");
		String transferMoney = request.getParameter("transferMoney");
		String receivingAccount = request.getParameter("receivingAccount");
			
			Customer customer =  customerService.getCustomerByAccountNum(receivingAccount);
			request.setAttribute("reCustomer", customer);
			request.setAttribute("sendingAccount", sendingAccount);
			request.setAttribute("transferMoney", transferMoney);
			request.setAttribute("receivingAccount", receivingAccount);		
			
			return "account/transfer_pro";
			
	}
	@PostMapping("/account/transfer_pro")
	public String transferPro(HttpServletRequest request, HttpSession session) {
		String sendingAccount = request.getParameter("sendingAccount");
		String transferMoneyStr = request.getParameter("transferMoney");
		long transferMoney = Long.parseLong(transferMoneyStr.replace(",", ""));
		String receivingAccount = request.getParameter("receivingAccount");
		String passwd = request.getParameter("passwd");
		Customer customer1 = (Customer) session.getAttribute("customer");
		String email = customer1.getEmail();
		
		Account sendingAcc = accountService.getAccountByAccountNum(sendingAccount);
		
	    Customer customer = customerService.isCustomer(email, passwd);
		if (customer == null) {
			request.setAttribute("msg", "로그인이 필요합니다.");
			request.setAttribute("url", "transfer");
		    return "alert";
		}
		if (sendingAcc.getBalance() - transferMoney < 0) {
			request.setAttribute("msg", "잔액부족");
			request.setAttribute("url", "transfer");
		    return "alert";
		}
		accountService.transferSending(sendingAccount, transferMoney);
		int result = accountService.transferReceiving(receivingAccount, transferMoney);
			if (result == 0) {
				request.setAttribute("msg", "송금오류");
				request.setAttribute("url", "transfer");
				return "alert";
			}
		Account account = accountService.getAccountByAccountNum(sendingAccount);
		
		request.setAttribute("account", account);
		
		return "account/transfer_re";
	}
//	@GetMapping("/account/transfer_re")
//	public String transferResult(HttpServletRequest request, HttpSession session) {
//		
//	}

}

