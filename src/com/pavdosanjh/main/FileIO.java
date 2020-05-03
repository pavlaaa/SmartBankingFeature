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

	public void readFile(Path readFile) throws FileNotFoundException {

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

			// Store all transactions in List.
			setLedger(Files.readAllLines(file, StandardCharsets.UTF_8));

			// Read
			setHeader(reader.readLine());

			String line;
			while ((line = reader.readLine()) != null) {
				String[] currentLine = line.split(",");
				try {
					int accountId = Integer.parseInt(currentLine[0]);
					String accountType = currentLine[1];
					String initiatorType = currentLine[2];
					String dateTime = Formatting.formatDateTime(currentLine[3]);
					double transactionValue = Double.parseDouble(currentLine[4]);

					
					Transaction t = new Transaction(accountId, accountType, initiatorType, dateTime, transactionValue);
//					t.setAccountId(accountId);
//					t.setAccountType(accountType);
//					t.setDateTime(dateTime);
//					t.setInitiatorType(initiatorType);
//					t.setTransactionValue(transactionValue);
					
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
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

	public  String getHeader() {
		return header;
	}

	public  void setHeader(String header) {
		FileIO.header = header;
	}

	public List<String> getLedger() {
		return ledger;
	}

	public void setLedger(List<String> ledger) {
		FileIO.ledger = ledger;
	}

}
