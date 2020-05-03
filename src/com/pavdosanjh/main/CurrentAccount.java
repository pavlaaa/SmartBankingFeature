/**
 * 
 */
package com.pavdosanjh.main;

/**
 * @author Pav.Dosanjh
 *
 */
public class CurrentAccount {

	private static final String CURRENT_ACCOUNT_TYPE = "CURRENT";

	private static int currentAccountId;
	private static double currentBalance = 0.0;

	public static void calcAccountBalance() {

		if (CURRENT_ACCOUNT_TYPE.equals(Transaction.getAccountType())) {
			currentBalance = getCurrentBalance() + Transaction.getTransactionValue();
			System.out.println();
			System.out.println(Transaction.getAccountType() + " "
					+ Formatting.formatTransactionValue(Transaction.getTransactionValue()));
			System.out.println("----------------------------------------------------------------------");
		}
	}

	public static Boolean isOverdrawn() {

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

	public static double getCurrentBalance() {
		return currentBalance;
	}

	public static void setCurrentBalance(double currentBalance) {

		CurrentAccount.currentBalance = currentBalance;
	}

	public static int getCurrentAccountId() {
		return currentAccountId;
	}

	public static void setCurrentAccountId(int currentAccountId) {
		if (CURRENT_ACCOUNT_TYPE.equals(Transaction.getAccountType())) {
			currentAccountId = Transaction.getAccountId();
		}

		CurrentAccount.currentAccountId = currentAccountId;
	}
}
