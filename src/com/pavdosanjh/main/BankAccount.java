/**
 * 
 */
package com.pavdosanjh.main;

/**
 * @author Pav.Dosanjh
 *
 */
public class BankAccount {

	private static final String CURRENT_ACCOUNT_TYPE = "CURRENT";
	private static final String SAVINGS_ACCOUNT_TYPE = "SAVINGS";
//	private double accountBalance = 0.0;

	public static void printAccountBalances() {
		System.out
				.println("Current Account balance: " + " " + String.format("%.2f", CurrentAccount.getCurrentBalance()));
		System.out
				.println("Savings Account balance: " + " " + String.format("%.2f", SavingsAccount.getSavingsBalance()));
	}

	public static void calcAccountBalances() {
		CurrentAccount.calcAccountBalance();
		SavingsAccount.calcAccountBalance();
	}

	public static void saveAccountId() {
		if (Transaction.getAccountType().equals(CURRENT_ACCOUNT_TYPE)) {
			CurrentAccount.setCurrentAccountId(Transaction.getAccountId());
		}

		if (Transaction.getAccountType().equals(SAVINGS_ACCOUNT_TYPE)) {
			SavingsAccount.setSavingsAccountId(Transaction.getAccountId());
		}
	}

}
