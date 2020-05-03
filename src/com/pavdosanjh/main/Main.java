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
		// TODO Auto-generated method stub

		Path writeFile = Paths.get(System.getProperty("user.dir")).resolve("testData")
				.resolve("customer-1234567-ledger-write.csv");

//		Path readFile = Paths.get(System.getProperty("user.dir")).resolve("testData")
//				.resolve("customer-1234567-ledger.csv");

		Path readFile = Paths.get(System.getProperty("user.dir")).resolve("testData").resolve("customer2.csv");

		// Read CSV file
		try {
			FileIO.readFile(readFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// If current account is overdrawn transfer money from Savings
		if (CurrentAccount.isOverdrawn()) {
			SavingsAccount.transferToCurrent();
			// Write CSV file
			try {
				FileIO.writeFile(writeFile);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
