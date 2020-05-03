/**
 * 
 */
package com.pavdosanjh.main;

/**
 * @author Pav.Dosanjh
 *
 */
public class CurrentAccount {

	private double currentBalance;

	private int accountId;
	private String accountType;
	private double transactionBalance;

	public CurrentAccount(int accountId, String accountType, double transactionBalance) {
		this.accountId = accountId;
		this.accountType = accountType;
		this.transactionBalance = transactionBalance;
	}

	public Boolean isOverdrawn() {
		if (getCurrentBalance() < 0.0) {
			System.out.println("** YOUR CURRENT ACCOUNT IS OVERDRAWN **");
			System.out.println();
			return true;
		} else {
			System.out.println("Your current account is not Overdrawn ");
			System.out.println();
			return false;
		}
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {

		this.currentBalance = currentBalance;
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

	public double getTransactionBalance() {
		return transactionBalance;
	}

	public void setTransactionBalance(double transactionBalance) {
		this.transactionBalance = transactionBalance;
	}
}
