package com.pavdosanjh.main;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Pav.Dosanjh
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CurrentAccount curAcc = new CurrentAccount(0, null, 0);
		SavingsAccount savAcc = new SavingsAccount(0, null, 0);
		TransactionData transaction = new TransactionData();

		Path writeFile = Paths.get(System.getProperty("user.dir")).resolve("testData")
				.resolve("customer-1234567-ledger-write.csv");

		// Path readFile = Paths.get(System.getProperty("user.dir")).resolve("testData")
		// .resolve("customer-1234567-ledger.csv");

//		Path readFile = Paths.get(System.getProperty("user.dir")).resolve("testData").resolve("customer2.csv");

		Path readFile = Paths.get(System.getProperty("user.dir")).resolve("testData").resolve("customer3.csv");

		// Read CSV file

		FileIO fio = new FileIO(transaction);

		try {
			fio.readFileThenPopulateTransactionData(readFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// populate saving and current account

		curAcc.setAccountId(transaction.getCurrentAccountId());
		curAcc.setAccountType(transaction.getCurrentAccountType());
		curAcc.setTransactionBalance(transaction.getCurrentTransactionBalance());

		savAcc.setAccountId(transaction.getSavingsAccountId());
		savAcc.setAccountType(transaction.getSavingsAccountType());
		savAcc.setTransactionValue(transaction.getSavingsTransactionBalance());

		// If current account is overdrawn transfer money from Savings

		BankAccountCalculations bac = new BankAccountCalculations(savAcc, curAcc, transaction);

		bac.calcCurrentAccountBalance();
		bac.calcSavingsAccountBalance();

		if (curAcc.isOverdrawn()) {
			bac.transferToCurrent();
			// Write CSV file
			try {
				fio.writeFile(writeFile);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
