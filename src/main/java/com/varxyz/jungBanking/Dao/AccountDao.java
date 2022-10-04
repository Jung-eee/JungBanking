package com.varxyz.jungBanking.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.varxyz.jungBanking.Domain.Account;

public class AccountDao {
	 private JdbcTemplate jdbcTemplate;
	 
	 public AccountDao(DataSource datasource) {
		 jdbcTemplate = new JdbcTemplate(datasource);
	 }

	public int addAccount(Account account) {
		try {
			String sql = "INSERT INTO Account (customerId, accountNum) VALUES"
					+ "(?,?)";
			jdbcTemplate.update(sql, account.getCustomerId(), account.getAccountNum());
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public List<Account> getAccountByCustomerId(long customerId) {
		try {
			String sql = "SELECT * FROM Account WHERE customerId = ?";
			return jdbcTemplate.query(sql, new RowMapper<Account>(){

				@Override
				public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
					Account account = new Account();
					account.setAccountNum(rs.getString("accountNum"));
					account.setBalance(rs.getLong("balance"));
					account.setAid(rs.getLong("aid"));
					account.setRegDate(rs.getTimestamp("regDate"));
					return account;
				}
				
			}, customerId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int deposit(String accountNum, int depositMoney) {
		try {
			String sql = "UPDATE Account SET balance = balance + ? WHERE accountNum = ?";
			jdbcTemplate.update(sql, depositMoney, accountNum);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public Account getAccountByAccountNum(String accountNum) {
		try {
			String sql = "SELECT * FROM Account WHERE accountNum = ? ";
			return jdbcTemplate.queryForObject(sql, new RowMapper<Account>() {

				@Override
				public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
					Account account = new Account();
					account.setAccountNum(rs.getString("accountNum"));
					account.setAid(rs.getLong("aid"));
					account.setBalance(rs.getLong("balance"));
					account.setRegDate(rs.getTimestamp("regDate"));
					return account;
				}
				
			},accountNum);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void transferSending(String sendingAccount, long transferMoney) {
		try {
			String sql = "UPDATE Account SET balance = balance - ? WHERE accountNum = ?";
			jdbcTemplate.update(sql,transferMoney,sendingAccount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public int transferReceiving(String receivingAccount, long transferMoney) {
		try {
		  String sql = "UPDATE Account SET balance = balance + ? WHERE accountNum = ?";
		  jdbcTemplate.update(sql,transferMoney,receivingAccount);
		  return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	 
}
