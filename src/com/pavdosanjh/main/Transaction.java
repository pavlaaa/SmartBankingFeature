package com.pavdosanjh.main;

/**
 * @author Pav.Dosanjh
 *
 */

public class Transaction {

	private static int accountId = 0;
	private static String accountType;
	private static String initiatorType;
	private static String dateTime;
	private static double transactionValue = 0.0;

	private static int noOfTransactions;

	public Transaction(int accountId, String accountType, String initiatorType, String dateTime,
			double transactionValue) {
		// Constructor reading in all data from CSV
		System.out.println();
		System.out.println("----------------------------------------------------------------------");
		System.out.println("Creating Transaction.....");
		noOfTransactions++;
		System.out.println("Transactino no: " + noOfTransactions);
		System.out.println();

		Transaction.accountId = accountId;
		Transaction.accountType = accountType;
		Transaction.dateTime = dateTime;
		Transaction.initiatorType = initiatorType;
		Transaction.transactionValue = transactionValue;

		System.out.println(accountId + " " + accountType + " " + initiatorType + " " + dateTime + " "
				+ Formatting.formatTransactionValue(transactionValue) + " ");

		BankAccount.calcAccountBalances();

		BankAccount.printAccountBalances();
		BankAccount.saveAccountId();

		System.out.println("----------------------------------------------------------------------");
		System.out.println();
	}

	public static void setAccountId(int accountId) {
		// Transaction.accountId = accountId;

		if (accountType.equals("CURRENT")) {
			CurrentAccount.setCurrentAccountId(accountId);
		} else {
			SavingsAccount.setSavingsAccountId(accountId);
		}

		Transaction.accountId = accountId;
	}

	public static String getAccountType() {
		return accountType;
	}

	public static int getAccountId() {
		return accountId;
	}

	public static void setAccountType(String accountType) {
		Transaction.accountType = accountType;
	}

	public static String getInitiatorType() {
		return initiatorType;
	}

	public static void setInitiatorType(String initiatorType) {
		Transaction.initiatorType = initiatorType;
	}

	public static String getDateTime() {
		return dateTime;
	}

	public static void setDateTime(String dateTime) {
		Transaction.dateTime = dateTime;
	}

	public static double getTransactionValue() {
		return transactionValue;
	}

	public static void setTransactionValue(double transactionValue) {
		Transaction.transactionValue = transactionValue;
	}

	public static int getNoOfTransactions() {
		return noOfTransactions;
	}

	public static void setNoOfTransactions(int noOfTransactions) {
		Transaction.noOfTransactions = noOfTransactions;
	}

}
