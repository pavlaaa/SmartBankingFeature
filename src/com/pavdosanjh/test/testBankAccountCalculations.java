/**
 * 
 */
package com.pavdosanjh.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.pavdosanjh.main.BankAccountCalculations;
import com.pavdosanjh.main.CurrentAccount;
import com.pavdosanjh.main.SavingsAccount;
import com.pavdosanjh.main.TransactionData;

/**
 * @author Pav.Dosanjh
 *
 */
class testBankAccountCalculations {

	/**
	 * Test method for
	 * {@link com.pavdosanjh.main.BankAccountCalculations#transferToCurrent()}.
	 */
	@Test
	final void testTransferToCurrent() {

		CurrentAccount currAcc = new CurrentAccount(456, "CURRENT", -100.00);
		SavingsAccount savAcc = new SavingsAccount(999, "SAVINGS", 200.00);

		TransactionData transaction = new TransactionData();
		transaction.setCurrentAccountId(456);
		transaction.setCurrentAccountType("CURRENT");
		transaction.setCurrentTransactionBalance(-100.00);

		transaction.setSavingsAccountId(999);
		transaction.setSavingsAccountType("SAVINGS");
		transaction.setSavingsTransactionBalance(200.00);

		BankAccountCalculations bac = new BankAccountCalculations(savAcc, currAcc, transaction);

		bac.calcCurrentAccountBalance();
		bac.calcSavingsAccountBalance();

		Assert.assertEquals(bac.calculateSavingsTransferValue(), -100.00, 0.1);
		Assert.assertEquals(bac.calculateCurrentTransferValue(), 100.00, 0.1);

	}

}
