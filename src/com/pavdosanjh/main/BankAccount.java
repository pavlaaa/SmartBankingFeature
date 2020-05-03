/**
 * 
 */
package com.pavdosanjh.main;

/**
 * @author Pav.Dosanjh
 *
 */
public class BankAccount {

	private final String CURRENT_ACCOUNT_TYPE = "CURRENT";
	private final String SAVINGS_ACCOUNT_TYPE = "SAVINGS";
//	private double accountBalance = 0.0;
	
	private int accountId = 0;
	private String accountType;
	private double transactionValue = 0.0;
	
	public BankAccount (int accountId, String accountType,
			double transactionValue) {
		this.accountId = accountId;
		this.accountType = accountType;
		this.transactionValue = transactionValue;
		
	}
	

	public void printAccountBalances() {
		CurrentAccount currAcc = new CurrentAccount(accountId, CURRENT_ACCOUNT_TYPE, transactionValue);
		System.out.println(" Hello Pav" + currAcc.getCurrentBalance());
		System.out
				.println("Current Account balance: " + " " + String.format("%.2f", currAcc.getCurrentBalance()));
		
		SavingsAccount savAcc = new SavingsAccount(accountId, CURRENT_ACCOUNT_TYPE, transactionValue);
		System.out
				.println("Savings Account balance: " + " " + String.format("%.2f", savAcc.getSavingsBalance()));
	}

	public void calcAccountBalances() {
		
		System.out.println("BankAccount - calcAccountBalances");
		CurrentAccount currAcc = new CurrentAccount(accountId, CURRENT_ACCOUNT_TYPE, transactionValue);
		currAcc.calcAccountBalance();
		
		SavingsAccount savAcc = new SavingsAccount(accountId, CURRENT_ACCOUNT_TYPE, transactionValue);
		savAcc.calcAccountBalance();	
	}

	public void saveAccountId() {
 
		
		Transaction transaction = new Transaction();
				
		CurrentAccount currAcc = new CurrentAccount(accountId, CURRENT_ACCOUNT_TYPE, transactionValue);
		if (CURRENT_ACCOUNT_TYPE.equals(transaction.getAccountType())) {
			currAcc.setCurrentAccountId(transaction.getAccountId());
		}

		SavingsAccount savAcc = new SavingsAccount(accountId, CURRENT_ACCOUNT_TYPE, transactionValue);
		if (SAVINGS_ACCOUNT_TYPE.equals(transaction.getAccountType())) {
			savAcc.setSavingsAccountId(transaction.getAccountId());
		}
		
	}
	
	
	

}
