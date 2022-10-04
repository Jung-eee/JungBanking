package com.varxyz.jungBanking.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.jungBanking.Domain.Customer;
import com.varxyz.jungBanking.Service.CustomerServiceImp;

@Controller
public class AddCustomerController {
	
	@Autowired
	CustomerServiceImp customerService;
	
	@GetMapping("/login/add_customer")
	public String addCustomerForm() {
		return "login/add_customer";
	}
	@PostMapping("login/add_customer")
	public String addCumstomer(HttpServletRequest request) {
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String ssn = request.getParameter("ssn");
		String phone = request.getParameter("phone");

		
		Customer customer = new Customer();
		customer.setEmail(email1 + "@" + email2);
		customer.setPasswd(passwd);
		customer.setName(name);
		customer.setSsn(ssn);
		customer.setPhone(phone);
		
		int result = customerService.addCustomer(customer);
		
		if (result != 1) {
			request.setAttribute("msg", "회원가입에 실패하였습니다.");
			request.setAttribute("url", "main");
			return "alert";
		}
		return "main";
		
	}
}
