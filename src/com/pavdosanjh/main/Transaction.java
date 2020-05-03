package com.pavdosanjh.main;

/**
 * @author Pav.Dosanjh
 *
 */

public class Transaction {

	public int accountId = 0;
	public String accountType;
	public String initiatorType;
	public String dateTime;
	public double transactionValue = 0.0;

	private int noOfTransactions;

	public Transaction(int accountId, String accountType, String initiatorType, String dateTime,
			double transactionValue) {
		// Constructor reading in all data from CSV
		System.out.println();
		System.out.println("----------------------------------------------------------------------");
		System.out.println("Creating Transaction.....");
		noOfTransactions++;
		System.out.println("Transaction no: " + noOfTransactions);
		System.out.println();

		this.accountId = accountId;
		this.accountType = accountType;
		
		System.out.println(this.accountType);
		
		this.dateTime = dateTime;
		this.initiatorType = initiatorType;
		this.transactionValue = transactionValue;
		
//		this.setAccountId(accountId);
//		this.setAccountType(accountType);
//		this.setDateTime(dateTime);
//		this.setInitiatorType(initiatorType);
//		this.setTransactionValue(transactionValue);

		System.out.println(accountId + " " + accountType + " " + initiatorType + " " + dateTime + " "
				+ Formatting.formatTransactionValue(transactionValue) + " ");

		BankAccount bankAcc = new BankAccount(accountId, dateTime, transactionValue);
		bankAcc.calcAccountBalances();
		bankAcc.printAccountBalances();
		bankAcc.saveAccountId();

		System.out.println("----------------------------------------------------------------------");
		System.out.println();
	}

	public Transaction() {
		// TODO Auto-generated constructor stub
		
		System.out.println("THIS IS BEING CALLED");
	}

	public void setAccountId(int accountId) {
		CurrentAccount curAcc = new CurrentAccount(accountId, accountType, transactionValue);
		SavingsAccount savAcc = new SavingsAccount(accountId, accountType, transactionValue);

		if (accountType.equals("CURRENT")) {
			curAcc.setCurrentAccountId(accountId);
		} else {
			savAcc.setSavingsAccountId(accountId);
		}

		this.accountId = accountId;
	}
	
	public int getAccountId() {
		return accountId;
	}
	

	public String getAccountType() {
		return accountType;
	}



	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

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

	public double getTransactionValue() {
		return transactionValue;
	}

	public void setTransactionValue(double transactionValue) {
		this.transactionValue = transactionValue;
	}

	public int getNoOfTransactions() {
		return noOfTransactions;
	}

	public void setNoOfTransactions(int noOfTransactions) {
		this.noOfTransactions = noOfTransactions;
	}

}
