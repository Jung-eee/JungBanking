package com.varxyz.jungBanking.Domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
	private long aid;
	private long customerId;
	private String accountNum;
	private long balance;
	private double interestRate;
	private Date regDate;
}
