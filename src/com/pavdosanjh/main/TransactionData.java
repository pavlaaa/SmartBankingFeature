package com.pavdosanjh.main;

/**
 * @author Pav.Dosanjh
 *
 */

public class TransactionData {

	public String initiatorType;
	public String dateTime;

	private String currentAccountType;
	private String savingsAccountType;
	private int currentAccountId;
	private int savingsAccountId;
	private double currentTransactionBalance;
	private double savingsTransactionBalance;

	public String getInitiatorType() {
		return initiatorType;
	}

	public void setInitiatorType(String initiatorType) {
		this.initiatorType = initiatorType;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getCurrentAccountType() {
		return currentAccountType;
	}

	public void setCurrentAccountType(String currentAccountType) {
		this.currentAccountType = currentAccountType;
	}

	public String getSavingsAccountType() {
		return savingsAccountType;
	}

	public void setSavingsAccountType(String savingsAccountType) {
		this.savingsAccountType = savingsAccountType;
	}

	public int getCurrentAccountId() {
		return currentAccountId;
	}

	public void setCurrentAccountId(int currentAccountId) {
		this.currentAccountId = currentAccountId;
	}

	public int getSavingsAccountId() {
		return savingsAccountId;
	}

	public void setSavingsAccountId(int savingsAccountId) {
		this.savingsAccountId = savingsAccountId;
	}

	public double getCurrentTransactionBalance() {
		return currentTransactionBalance;
	}

	public void setCurrentTransactionBalance(double currentTransactionBalance) {
		this.currentTransactionBalance = currentTransactionBalance;
	}

	public double getSavingsTransactionBalance() {
		return savingsTransactionBalance;
	}

	public void setSavingsTransactionBalance(double savingsTransactionBalance) {
		this.savingsTransactionBalance = savingsTransactionBalance;
	}

}
