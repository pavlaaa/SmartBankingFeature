package com.pavdosanjh.main;

/**
 * @author Pav.Dosanjh
 *
 */

public class SavingsAccount {

	private double savingsBalance;

	private int accountId;
	private String accountType;
	private double transactionBalance;

	public SavingsAccount(int accountId, String accountType, double transactionBalance) {
		this.accountId = accountId;
		this.accountType = accountType;
		this.transactionBalance = transactionBalance;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}

	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getTransactionValue() {
		return transactionBalance;
	}

	public void setTransactionValue(double transactionBalance) {
		this.transactionBalance = transactionBalance;
	}

}
