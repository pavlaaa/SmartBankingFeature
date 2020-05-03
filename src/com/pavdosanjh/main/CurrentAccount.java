/**
 * 
 */
package com.pavdosanjh.main;

/**
 * @author Pav.Dosanjh
 *
 */
public class CurrentAccount {

	private final String CURRENT_ACCOUNT_TYPE = "CURRENT";

	private   int currentAccountId;
	private  double currentBalance = 0.0;
	
	private int accountId = 0;
	private String accountType;
	private double transactionValue = 0.0;
	
	
	public CurrentAccount (int accountId, String accountType,
			double transactionValue) {
		this.currentAccountId = accountId;
		this.accountType = accountType;
		this.transactionValue = transactionValue;
		
	}

	public void calcAccountBalance() {
		Transaction transaction = new Transaction();
		String type  = transaction.getAccountType();
		System.out.println(type);
		
		if (CURRENT_ACCOUNT_TYPE.equals(transaction.getAccountType())) {
			currentBalance = getCurrentBalance() + transaction.getTransactionValue();
			setCurrentBalance(currentBalance);
			System.out.println();
			System.out.println(transaction.getAccountType() + " "
					+ Formatting.formatTransactionValue(transaction.getTransactionValue()));
			System.out.println("----------------------------------------------------------------------");
		}
	}
	
//	if (CURRENT_ACCOUNT_TYPE.equals(transaction.getAccountType())) {
//		currAcc.setCurrentAccountId(transaction.getAccountId());
//	}

	public  Boolean isOverdrawn() {

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

	public  int getCurrentAccountId() {
		return currentAccountId;
	}

	public  void setCurrentAccountId(int currentAccountId) {
		Transaction transaction = new Transaction();
		
		if (CURRENT_ACCOUNT_TYPE.equals(transaction.getAccountType())) {
			currentAccountId = transaction.getAccountId();
		}

		this.currentAccountId = currentAccountId;
	}
}
