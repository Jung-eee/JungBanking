package com.varxyz.jungBanking.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.varxyz.jungBanking.Dao.CustomerDao;
import com.varxyz.jungBanking.Domain.Customer;

public class CustomerServiceImp implements CustomerService {
	@Autowired
	CustomerDao customerDao;
	
	@Override
	@Transactional
	public int addCustomer(Customer customer) {
		return customerDao.addCustomer(customer);
	}

	@Override
	public Customer isCustomer(String email, String passwd) {
		return customerDao.isCustomer(email,passwd);
	}

	@Override
	public Customer getCustomerByAccountNum(String accountNum) {
		return customerDao.getCustomerByAccountNum(accountNum);
	}

	
}
