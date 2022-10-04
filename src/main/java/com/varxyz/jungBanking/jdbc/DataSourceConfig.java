package com.varxyz.jungBanking.jdbc;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.varxyz.jungBanking.Dao.AccountDao;
import com.varxyz.jungBanking.Dao.CustomerDao;
import com.varxyz.jungBanking.Service.AccountServiceImp;
import com.varxyz.jungBanking.Service.CustomerServiceImp;

@Configuration
public class DataSourceConfig {

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/bank?serverTimezone=Asia/Seoul");
		ds.setUsername("bank");
		ds.setPassword("bank");
		ds.setInitialSize(10);
		ds.setMaxActive(10);
		ds.setMaxIdle(10);
		return ds;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}

	@Bean
	public CustomerServiceImp customerService() {
		return new CustomerServiceImp();
	}

	@Bean
	public CustomerDao customerDao() {
		return new CustomerDao(dataSource());
	}
	@Bean
	public AccountServiceImp accountService() {
		return new AccountServiceImp();
	}
	@Bean
	public AccountDao accountDao() {
		return new AccountDao(dataSource());
	}

}
