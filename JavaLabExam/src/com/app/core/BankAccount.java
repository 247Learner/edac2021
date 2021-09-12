package com.app.core;

import java.text.SimpleDateFormat;
import java.util.Date;

import custom_exception.AccountHandlingException;

import static utils.ValidationUtils.validateBalance;

public class BankAccount {
	private int acctNo;//PK
	private String customerName;
	private double balance;
	private AccountType type;
	private Date openingDate;
	public static SimpleDateFormat sdf;
	static {
		sdf=new SimpleDateFormat("dd-MM-yyyy");
	}
	public BankAccount(int acctNo, String customerName, double balance, AccountType type, Date openingDate) {
		super();
		this.acctNo = acctNo;
		this.customerName = customerName;
		this.balance = balance;
		this.type = type;
		this.openingDate = openingDate;
		
	}
	//add overloaded constructor wrapping PK
	public BankAccount(int acctNo) {
		super();
		this.acctNo = acctNo;
	}
	
	@Override
	public String toString() {
		return "BankAccount [acctNo=" + acctNo + ", customerName=" + customerName + ", balance=" + balance + ", type="
				+ type + ", openingDate=" + sdf.format(openingDate) + "]";
	}
	
	
	public void deposit(double amount)
	{
		balance += amount;
	}
	
	public void withdraw(double amount) throws AccountHandlingException
	{
		validateBalance(balance-amount);
		balance -= amount;
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof BankAccount)
			return acctNo == ((BankAccount)o).acctNo;
		return false;
		
	}
	
	public AccountType getType() {
		return type;
	}
	public Date getOpeningDate() {
		return openingDate;
	}
	public int getAcctNo() {
		return acctNo;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public double getBalance() {
		return balance;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	

}