/**
 * 
 */
package com.pavdosanjh.main;

import java.util.Date;

/**
 * @author Pav.Dosanjh
 *
 */
public class BankAccountCalculations {

	private final String SYSTEM_INITIATOR_TYPE = "SYSTEM";

	private SavingsAccount savAcc;
	private CurrentAccount curAcc;
	private TransactionData transaction;

	public BankAccountCalculations(SavingsAccount savAcc, CurrentAccount curAcc, TransactionData transaction) {
		this.savAcc = savAcc;
		this.curAcc = curAcc;
		this.transaction = transaction;
	}

	public double calcCurrentAccountBalance() {
		double currentBalance = curAcc.getCurrentBalance() + transaction.getCurrentTransactionBalance();
		curAcc.setCurrentBalance(currentBalance);
		System.out.println();
		System.out.println(transaction.getCurrentAccountType() + " "
				+ Formatting.formatTransactionValue(transaction.getCurrentTransactionBalance()));
		return currentBalance;
	}

	public double calcSavingsAccountBalance() {
		double savingsBalance = savAcc.getSavingsBalance() + transaction.getSavingsTransactionBalance();
		savAcc.setSavingsBalance(savingsBalance);
		if (savingsBalance < 0)
			throw new IllegalArgumentException("Savings Account cannot be negative / overdrawn");
		System.out.println(transaction.getSavingsAccountType() + " "
				+ Formatting.formatTransactionValue(transaction.getSavingsTransactionBalance()));
		System.out.println();
		return savingsBalance;
	}

	public void transferToCurrent() {
		System.out.println("Transfer transaction will be made from your savings account.");
		System.out.println();
		Date date = new Date();
		String dateTime = Formatting.formatDateTime(date);
		FileIO fio = new FileIO();

		transferCurrent(fio, dateTime);
		transferSavings(fio, dateTime);
	}

	private void transferCurrent(FileIO fio, String dateTime) {
		int accountId = curAcc.getAccountId();
		String accountType = curAcc.getAccountType();
		String initiatorType = SYSTEM_INITIATOR_TYPE;

		double transactionValue = calculateCurrentTransferValue();

		String stringCurrent = accountId + "," + accountType + "," + initiatorType + "," + dateTime + ","
				+ transactionValue;

		fio.getLedger().add(stringCurrent);

		System.out.println("** TRANSFER RECEIVED ** From SAVINGS to CURRENT");
		System.out.println(accountId + " " + accountType + " " + initiatorType + " " + dateTime + " "
				+ Formatting.formatTransactionValue(transactionValue) + " ");
		System.out.println();
	}

	private void transferSavings(FileIO fio, String dateTime) {

		// Update Savings Account
		int accountId = savAcc.getAccountId();
		String accountType = savAcc.getAccountType();
		String initiatorType = SYSTEM_INITIATOR_TYPE;
		double transactionValue = calculateSavingsTransferValue();

		String stringSavings = accountId + "," + accountType + "," + initiatorType + "," + dateTime + ","
				+ transactionValue;

		fio.getLedger().add(stringSavings);

		System.out.println("** TRANSFER ** From SAVINGS to CURRENT");
		System.out.println(accountId + " " + accountType + " " + initiatorType + " " + dateTime + " "
				+ Formatting.formatTransactionValue(transactionValue) + " ");
		System.out.println();
	}

	public double calculateCurrentTransferValue() {
		double currentTransfer = 0.0;
		if (savAcc.getSavingsBalance() < -curAcc.getCurrentBalance()) {
			currentTransfer = -savAcc.getSavingsBalance();
		} else {
			currentTransfer = -curAcc.getCurrentBalance();
		}
		return currentTransfer;
	}

	public double calculateSavingsTransferValue() {
		double savingsTransfer = 0.0;

		if (savAcc.getSavingsBalance() < -curAcc.getCurrentBalance()) {
			savingsTransfer = +savAcc.getSavingsBalance();
		} else {
			savingsTransfer = +curAcc.getCurrentBalance();
		}
		return savingsTransfer;
	}

}
