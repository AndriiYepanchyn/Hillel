package main.java.lesson_07;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyTimeStamp {
	private static String regex = "[0,1-3][0-9]\\.[0,1]\\d\\.\\d{4}\\s[0,1,2]\\d:[1-5,0][0-9]:[1-5,0]\\d";
	private static HashMap<Byte, Integer> monthInfo = new HashMap<Byte, Integer>();
	private static HashMap<Byte, String> monthOnDisplay = new HashMap<Byte, String>();

	{
		monthInfo.put((byte) 1, 31);
		monthInfo.put((byte) 2, 29);
		monthInfo.put((byte) 3, 31);
		monthInfo.put((byte) 4, 30);
		monthInfo.put((byte) 5, 31);
		monthInfo.put((byte) 6, 30);
		monthInfo.put((byte) 7, 31);
		monthInfo.put((byte) 8, 31);
		monthInfo.put((byte) 9, 30);
		monthInfo.put((byte) 10, 31);
		monthInfo.put((byte) 11, 30);
		monthInfo.put((byte) 12, 31);

		monthOnDisplay.put((byte) 1, "Jan");
		monthOnDisplay.put((byte) 2, "Feb");
		monthOnDisplay.put((byte) 3, "Mar");
		monthOnDisplay.put((byte) 4, "Apr");
		monthOnDisplay.put((byte) 5, "May");
		monthOnDisplay.put((byte) 6, "Jun");
		monthOnDisplay.put((byte) 7, "Jul");
		monthOnDisplay.put((byte) 8, "Aug");
		monthOnDisplay.put((byte) 9, "Sep");
		monthOnDisplay.put((byte) 10, "Oct");
		monthOnDisplay.put((byte) 11, "Nov");
		monthOnDisplay.put((byte) 12, "Dec");
	}
	private static byte minValueDayMonth = 1;
	private static byte minValueHourMinutesSeconds = 0;
	private static int yearMin = 1970;
	private static int yearMax = 9999;
	private static byte monthMax = 12;
	private static byte hourMax = 23;
	private static byte maxMinutesSeconds = 59;

	private int year;
	private byte month;
	private byte day;
	private byte hours;
	private byte minutes;
	private byte seconds;

	MyTimeStamp(String date) {
		String strippedDate = date.strip().trim();
		if (isDateValid(strippedDate)) {
			this.year = Integer.valueOf(strippedDate.substring(6, 10));
			this.month = Byte.valueOf(strippedDate.substring(3, 5));
			this.day = Byte.valueOf(strippedDate.substring(0, 2));
			this.hours = Byte.valueOf(strippedDate.substring(11, 13));
			this.minutes = Byte.valueOf(strippedDate.substring(14, 16));
			this.seconds = Byte.valueOf(strippedDate.substring(17, 19));
		}
		else
			throw new IllegalArgumentException(
					"Input string is not a valid date: " + date +"\n        Please check input date and it's format DD.MM.YYYY HH:MM:SS");
	}

	/**
	 * Method check can the String be converted to the MyTimeStamp object and represent correct date.
	 * @param date - String to be converted.
	 * @return true if input string "date" is correct and may be converted into MyTimeStamp format.
	 */
	public static boolean isDateValid(String date) {
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(date);
		if (!matcher.matches()) {
			return false;
		}

		String ddStr = date.substring(0, 2);
		String mmStr = date.substring(3, 5);
		String yyyyStr = date.substring(6, 10);
		String hourStr = date.substring(11, 13);
		String minStr = date.substring(14, 16);
		String secStr = date.substring(17, 19);
		int year = -1;
		byte month = -1, day = -1, hour = -1, minute = -1, second = -1;

		year = ifInRange(yyyyStr, yearMin, yearMax);
		month = (byte) ifInRange(mmStr, minValueDayMonth, monthMax);
		if(month == -1) {return false;}
		day = (byte) ifInRange(ddStr, minValueDayMonth, monthInfo.get(month));

		if (month == 2) {
			if (!validateLeapYear(year, day)) {
				return false;
			}
		}
		hour = (byte) ifInRange(hourStr, minValueHourMinutesSeconds, hourMax);
		minute = (byte) ifInRange(minStr, minValueHourMinutesSeconds, maxMinutesSeconds);
		second = (byte) ifInRange(secStr, minValueHourMinutesSeconds, maxMinutesSeconds);

		return !(year == -1 || month == -1 || day == -1 || hour == -1 || minute == -1 || second == -1);
	}

	private static boolean validateLeapYear(int year, int day) {
		if (year % 4 != 0 && day > 28) {
			return false;
		} else
			return true;
	}

	private static int ifInRange(String value, int minValue, int maxValue) {
		int tmp = Integer.valueOf(value);
		return (tmp >= minValue && tmp <= maxValue) ? tmp : -1;
	}
	
	
	/**
	 * Convert date from format "22.01.2019 19:15:00" into format "22 Jan, 7:15 PM"
	 * @return Formatted string of the MyTimeStamp object.
	 */
	public String convertToMMM() {
		String suffix = hours>12? " PM": " AM";
		int showHoursAs = hours>12? hours-12: hours;
		return day + " " + monthOnDisplay.get(month) + ", " + showHoursAs+ ":" +minutes + suffix;
	}
}
