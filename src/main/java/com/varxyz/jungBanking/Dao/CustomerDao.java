package com.varxyz.jungBanking.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.varxyz.jungBanking.Domain.Customer;

public class CustomerDao {
	private JdbcTemplate jdbcTemplate;
	
	public CustomerDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public int addCustomer(Customer customer) {
		try {
			String  sql = "INSERT INTO Customer(email,passwd,name,ssn,phone)"
					+ "VALUE(?,?,?,?,?)";
			jdbcTemplate.update(sql, customer.getEmail(), customer.getPasswd(),customer.getName(),
					customer.getSsn(),customer.getPhone());
			return 1;
			//정상일 때 1로 받는다.
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
				
		
	}
	public Customer isCustomer(String email, String passwd) {
		try {
			String sql = "SELECT * FROM Customer WHERE email = ? AND passwd = ? ";
			return jdbcTemplate.queryForObject(sql, new RowMapper<Customer>() {

				@Override
				public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					Customer customer = new Customer();
					customer.setCid(rs.getLong("cid"));
					customer.setEmail(rs.getString("email"));
					customer.setName(rs.getString("name"));
					customer.setPhone(rs.getString("phone"));
					customer.setSsn(rs.getString("ssn"));
					customer.setRegDate(rs.getTimestamp("regDate"));
					return customer;
				}
				
			}, email, passwd);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public Customer getCustomerByAccountNum(String accountNum) {
		try {
			String sql = "SELECT * FROM Customer c INNER JOIN Account a ON c.cid = a.customerId WHERE a.accountNum = ?";
			return jdbcTemplate.queryForObject(sql,new RowMapper<Customer>() {

				@Override
				public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
					Customer customer = new Customer();
					customer.setCid(rs.getLong("cid"));
					customer.setName(rs.getString("name"));
					customer.setEmail(rs.getString("email"));
					customer.setPhone(rs.getString("phone"));
					customer.setSsn(rs.getString("ssn"));
					return customer;
				}
				
			},accountNum);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
