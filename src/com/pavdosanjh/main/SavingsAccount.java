package com.pavdosanjh.main;

import java.util.Date;

/**
 * @author Pav.Dosanjh
 *
 */

public class SavingsAccount {

	private  final String CURRENT_ACCOUNT_TYPE = "CURRENT";
	private  final String SAVINGS_ACCOUNT_TYPE = "SAVINGS";
	private  final String SYSTEM_INITIATOR_TYPE = "SYSTEM";

	private  double savingsTransfer;
	private  double currentTransfer;

	private  int savingsAccountId;
	private  double savingsBalance = 0.0;
	
	private int accountId = 0;
	private String accountType;
	private double transactionValue = 0.0;
	
	
	public SavingsAccount (int accountId, String accountType,
			double transactionValue) {
		this.accountId = accountId;
		this.accountType = accountType;
		this.transactionValue = transactionValue;
		
	}

	
	public void transferToCurrent() {
		
		CurrentAccount currAcc = new CurrentAccount(accountId, CURRENT_ACCOUNT_TYPE, currentTransfer);
		
		
		System.out.println("Transfer transaction will be made from your savings account.");
		System.out.println();

		calculateTransferValue();

		int accountId = currAcc.getCurrentAccountId();
		String accountType = CURRENT_ACCOUNT_TYPE;
		String initiatorType = SYSTEM_INITIATOR_TYPE;
		Date date = new Date();
		String currentDateTime = Formatting.formatDateTime(date);
		String dateTime = currentDateTime;
		double transactionValue = currentTransfer;

		setTransactionParameters(accountId, accountType, initiatorType, dateTime, transactionValue);

		String stringCurrent = accountId + "," + accountType + "," + initiatorType + "," + dateTime + ","
				+ transactionValue;
		FileIO fio = new FileIO();
		
		fio.getLedger().add(stringCurrent);

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

		fio.getLedger().add(stringSavings);

		System.out.println("** TRANSFER ** From SAVINGS to CURRENT");
		System.out.println(accountId + " " + accountType + " " + initiatorType + " " + dateTime + " "
				+ Formatting.formatTransactionValue(transactionValue) + " ");
		System.out.println();

		// Transaction t = new Transaction(accountId, stringSavings, stringSavings,
		// stringSavings, transactionValue);

	}

	private void setTransactionParameters(int accountId, String accountType, String initiatorType,
			String dateTime, double transactionValue) {
		Transaction transaction = new Transaction(accountId, dateTime, dateTime, dateTime, transactionValue);
		
		transaction.setAccountId(accountId);
		transaction.setAccountType(accountType);
		transaction.setInitiatorType(initiatorType);
		transaction.setDateTime(dateTime);
		transaction.setTransactionValue(transactionValue);
	}

	private void calculateTransferValue() {
		CurrentAccount curAcc = new CurrentAccount(accountId, CURRENT_ACCOUNT_TYPE, currentTransfer);
		
		if (getSavingsBalance() < -curAcc.getCurrentBalance()) {
			savingsTransfer = +getSavingsBalance();
			currentTransfer = -getSavingsBalance();
		} else {
			savingsTransfer = +curAcc.getCurrentBalance();
			currentTransfer = -curAcc.getCurrentBalance();
		}
	}

	public void calcAccountBalance() {
		Transaction transaction = new Transaction();
		
		System.out.println(transaction.getAccountType());

		System.out.println("Pav you are here 1");
		if (SAVINGS_ACCOUNT_TYPE.equals(transaction.getAccountType())) {
			savingsBalance = getSavingsBalance() + transaction.getTransactionValue();
			System.out.println("Pav you are here");
			
			if (savingsBalance < 0)
				throw new IllegalArgumentException("Savings Account cannot be negative / overdrawn");

			System.out.println();
			System.out.println(transaction.getAccountType() + " "
					+ Formatting.formatTransactionValue(transaction.getTransactionValue()));
		}

	}

	public  double getSavingsTransfer() {
		return savingsTransfer;
	}

	public  void setSavingsTransfer(double savingsTransfer) {
		SavingsAccount savAcc = new SavingsAccount(accountId, CURRENT_ACCOUNT_TYPE, savingsTransfer);
		
		savAcc.savingsTransfer = savingsTransfer;
	}

	public  int getSavingsAccountId() {
		return savingsAccountId;
	}

	public void setSavingsAccountId(int savingsAccountId) {
		Transaction transaction = new Transaction();
		
		if (SAVINGS_ACCOUNT_TYPE.equals(transaction.getAccountType())) {
			savingsAccountId = transaction.getAccountId();
		}

		this.savingsAccountId = savingsAccountId;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}

	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}

}
