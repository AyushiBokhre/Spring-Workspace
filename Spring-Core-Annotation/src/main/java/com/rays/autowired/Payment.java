package com.rays.autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("payment")
public class Payment {
	
	@Value("2000")
	private int balance;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int pay(int amount) {

		balance = balance - amount;

		return balance;
	}
}
