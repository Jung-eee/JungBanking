package com.varxyz.jungBanking.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.varxyz.jungBanking.Dao.AccountDao;
import com.varxyz.jungBanking.Domain.Account;
import com.varxyz.jungBanking.Domain.Customer;

public class AccountServiceImp implements AccountService {
	@Autowired
	AccountDao accountDao;
	
	@Override
	@Transactional
	public int addAcount(Account account) {
		return accountDao.addAccount(account);
	}

	@Override
	public Account getAccount(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getAccountByCustomerId(long customerId) {
		return accountDao.getAccountByCustomerId(customerId);
	}
	@Override
	public int deposit(String accountNum, int depositMoney) {
		// TODO Auto-generated method stub
		return accountDao.deposit(accountNum,depositMoney);
	}

	@Override
	public Account getAccountByAccountNum(String accountNum) {
		// TODO Auto-generated method stub
		return accountDao.getAccountByAccountNum(accountNum);
	}

	@Override
	@Transactional
	public void transferSending(String sendingAccount, long transferMoney) {
		accountDao.transferSending(sendingAccount,transferMoney);
		
	}

	@Override
	@Transactional
	public int transferReceiving(String receivingAccount, long transferMoney) {
		return accountDao.transferReceiving(receivingAccount,transferMoney);
	}

	


}
