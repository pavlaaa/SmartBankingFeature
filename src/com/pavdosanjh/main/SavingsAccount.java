package com.pavdosanjh.main;

import java.util.Date;

/**
 * @author Pav.Dosanjh
 *
 */

public class SavingsAccount {

	private static final String CURRENT_ACCOUNT_TYPE = "CURRENT";
	private static final String SAVINGS_ACCOUNT_TYPE = "SAVINGS";
	private static final String SYSTEM_INITIATOR_TYPE = "SYSTEM";

	private static double savingsTransfer;
	private static double currentTransfer;

	private static int savingsAccountId;
	private static double savingsBalance = 0.0;

	public static void transferToCurrent() {
		System.out.println("Transfer transaction will be made from your savings account.");
		System.out.println();

		calculateTransferValue();

		int accountId = CurrentAccount.getCurrentAccountId();
		String accountType = CURRENT_ACCOUNT_TYPE;
		String initiatorType = SYSTEM_INITIATOR_TYPE;
		Date date = new Date();
		String currentDateTime = Formatting.formatDateTime(date);
		String dateTime = currentDateTime;
		double transactionValue = currentTransfer;

		setTransactionParameters(accountId, accountType, initiatorType, dateTime, transactionValue);

		String stringCurrent = accountId + "," + accountType + "," + initiatorType + "," + dateTime + ","
				+ transactionValue;
		FileIO.getLedger().add(stringCurrent);

		System.out.println("** TRANSFER RECEIVED ** From SAVINGS to CURRENT");
		System.out.println(accountId + " " + accountType + " " + initiatorType + " " + dateTime + " "
				+ Formatting.formatTransactionValue(transactionValue) + " ");
		System.out.println();

		// Update Savings Account
		accountId = getSavingsAccountId();
		accountType = SAVINGS_ACCOUNT_TYPE;
		transactionValue = savingsTransfer;

		setTransactionParameters(accountId, accountType, initiatorType, dateTime, transactionValue);

		String stringSavings = accountId + "," + accountType + "," + initiatorType + "," + dateTime + ","
				+ transactionValue;

		FileIO.getLedger().add(stringSavings);

		System.out.println("** TRANSFER ** From SAVINGS to CURRENT");
		System.out.println(accountId + " " + accountType + " " + initiatorType + " " + dateTime + " "
				+ Formatting.formatTransactionValue(transactionValue) + " ");
		System.out.println();

		// Transaction t = new Transaction(accountId, stringSavings, stringSavings,
		// stringSavings, transactionValue);

	}

	private static void setTransactionParameters(int accountId, String accountType, String initiatorType,
			String dateTime, double transactionValue) {
		Transaction.setAccountId(accountId);
		Transaction.setAccountType(accountType);
		Transaction.setInitiatorType(initiatorType);
		Transaction.setDateTime(dateTime);
		Transaction.setTransactionValue(transactionValue);
	}

	private static void calculateTransferValue() {
		if (getSavingsBalance() < -CurrentAccount.getCurrentBalance()) {
			savingsTransfer = +getSavingsBalance();
			currentTransfer = -getSavingsBalance();
		} else {
			savingsTransfer = +CurrentAccount.getCurrentBalance();
			currentTransfer = -CurrentAccount.getCurrentBalance();
		}
	}

	public static void calcAccountBalance() {

		if (SAVINGS_ACCOUNT_TYPE.equals(Transaction.getAccountType())) {
			savingsBalance = getSavingsBalance() + Transaction.getTransactionValue();

			if (savingsBalance < 0)
				throw new IllegalArgumentException("Savings Account cannot be negative / overdrawn");

			System.out.println();
			System.out.println(Transaction.getAccountType() + " "
					+ Formatting.formatTransactionValue(Transaction.getTransactionValue()));
		}

	}

	public static double getSavingsTransfer() {
		return savingsTransfer;
	}

	public static void setSavingsTransfer(double savingsTransfer) {
		SavingsAccount.savingsTransfer = savingsTransfer;
	}

	public static int getSavingsAccountId() {
		return savingsAccountId;
	}

	public static void setSavingsAccountId(int savingsAccountId) {

		if (SAVINGS_ACCOUNT_TYPE.equals(Transaction.getAccountType())) {
			savingsAccountId = Transaction.getAccountId();
		}

		SavingsAccount.savingsAccountId = savingsAccountId;
	}

	public static double getSavingsBalance() {
		return savingsBalance;
	}

	public static void setSavingsBalance(double savingsBalance) {
		SavingsAccount.savingsBalance = savingsBalance;
	}

}
