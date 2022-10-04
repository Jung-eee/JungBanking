package com.varxyz.jungBanking.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.jungBanking.Domain.Customer;
import com.varxyz.jungBanking.Service.CustomerService;
import com.varxyz.jungBanking.Service.CustomerServiceImp;

@Controller
public class LoginController {
	
	@Autowired
	CustomerServiceImp customerService;
	
	@GetMapping("/login/login")
	public String loginForm() {
		return "login/login";
	}
	
	@PostMapping("/login/login")
	public String login(HttpServletRequest request, HttpSession session) {
		String email = request.getParameter("email");
		String passwd = request.getParameter("passwd");

		
		Customer customer = customerService.isCustomer(email, passwd);
		
		if (customer == null) {
			request.setAttribute("msg", "로그인에 실패하였습니다.");
			request.setAttribute("url", "login");
			return "alert";
		}
		session.setAttribute("customer", customer);
		
		return "main";
	}
	@GetMapping("/login/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login/login";
	}
}
