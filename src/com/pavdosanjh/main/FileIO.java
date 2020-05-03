package com.pavdosanjh.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * @author Pav.Dosanjh
 *
 */

public class FileIO {

	private static String header;
	private static List<String> ledger;
	private TransactionData transaction;

	private final String CURRENT_ACCOUNT_TYPE = "CURRENT";

	public FileIO(TransactionData transaction) {
		this.transaction = transaction;
	}

	public FileIO() {

	}

	public void readFileThenPopulateTransactionData(Path readFile) throws FileNotFoundException {

		Path file = readFile;
		Path csvFile = file;
		if (!Files.exists(file)) {
			throw new FileNotFoundException(file.toAbsolutePath().toString());
		}

		System.out.println("Reading file: " + file);
		System.out.println(
				"********************************************************************************************");

		System.out.println();

		try (BufferedReader reader = Files.newBufferedReader(csvFile)) {

			setLedger(Files.readAllLines(file, StandardCharsets.UTF_8));
			setHeader(reader.readLine());

			String line;
			double currentTransactionValue = 0.0;
			double savingsTransactionValue = 0.0;
			while ((line = reader.readLine()) != null) {
				String[] currentLine = line.split(",");
				populateTransactionData(currentLine, currentTransactionValue, savingsTransactionValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void populateTransactionData(String[] currentLine, double currentTransactionBalance,
			double savingsTransactionBalance) {
		try {
			int accountId = Integer.parseInt(currentLine[0]);
			String accountType = currentLine[1];
			String initiatorType = currentLine[2];
			String dateTime = Formatting.formatDateTime(currentLine[3]);
			double transactionValue = Double.parseDouble(currentLine[4]);

			if (CURRENT_ACCOUNT_TYPE.equals(accountType)) {
				transaction.setCurrentAccountId(accountId);
				transaction.setCurrentAccountType(accountType);
				currentTransactionBalance = currentTransactionBalance + transactionValue;
				transaction.setCurrentTransactionBalance(currentTransactionBalance);
			} else {
				transaction.setSavingsAccountId(accountId);
				transaction.setSavingsAccountType(accountType);
				savingsTransactionBalance = savingsTransactionBalance + transactionValue;
				transaction.setSavingsTransactionBalance(savingsTransactionBalance);
			}
			transaction.setInitiatorType(initiatorType);
			transaction.setDateTime(dateTime);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public void writeFile(Path writeFile) {
		// Write out CSV File.
		Path file = writeFile;

		try (BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8)) {

			int size = getLedger().size();
			for (int i = 0; i < size; i++) {
				String str = getLedger().get(i).toString();
				writer.write(str);

				// Fixed Bug:Prevent creating blank line at the end of the file
				if (i < size - 1)
					writer.newLine();
			}
			System.out.println();
			System.out.println("File written successfully to :" + file);
		} catch (

		NullPointerException e) {
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		FileIO.header = header;
	}

	public List<String> getLedger() {
		return ledger;
	}

	public void setLedger(List<String> ledger) {
		FileIO.ledger = ledger;
	}

}
