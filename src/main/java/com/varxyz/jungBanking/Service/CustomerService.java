package com.varxyz.jungBanking.Service;

import com.varxyz.jungBanking.Domain.Customer;

public interface CustomerService {
	int addCustomer(Customer customer);
	Customer isCustomer(String email, String passwd);
	Customer getCustomerByAccountNum(String AccountNum);
}
