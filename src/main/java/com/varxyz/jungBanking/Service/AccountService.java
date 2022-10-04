package com.varxyz.jungBanking.Service;


import java.util.List;

import com.varxyz.jungBanking.Domain.Account;
import com.varxyz.jungBanking.Domain.Customer;

public interface AccountService {
	
	int addAcount(Account account);
	Account getAccount(Customer customer);
	List<Account> getAccountByCustomerId(long customerId);
	Account getAccountByAccountNum(String accountNum);
	int deposit(String accountNum, int depositMoney);
	void transferSending(String sendingAccount, long transferMoney);
	int transferReceiving(String receivingAccount, long transferMoney);
	
}
