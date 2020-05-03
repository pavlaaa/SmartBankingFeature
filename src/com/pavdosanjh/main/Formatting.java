package com.pavdosanjh.main;

/**
 * @author Pav.Dosanjh
 *
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Formatting {

	public static String formatDateTime(String string1) {
		// Format and parse Date Time.
		DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'", Locale.ENGLISH);
		Date formattedDate = null;
		try {
			formattedDate = df1.parse(string1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String dateTime = df1.format(formattedDate);
		return dateTime;
	}

	public static String formatDateTime(Date date) {
		// Format and parse Date Time.
		DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'", Locale.ENGLISH);
		String dateTime = df1.format(date);
		return dateTime;
	}

	public static String formatTransactionValue(double transactionValue) {
		String strTransactionValue = String.format("%.2f", transactionValue);
		return strTransactionValue;
	}

}
