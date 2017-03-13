package algorithms.implementations;

import java.util.Scanner;

/*
 * Given the hours and minutes want to be able to print out the time in words
 */
public class TheTimeInWords {

	// Believe the easiest way to work with this is to simply have a lookup
	// table for how to convert each value to words

	static String[] units = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten" };
	static String[] teens = { "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
			"nineteen", "twenty" };

	public static String timeToWords(int hour, int minute) {
		StringBuilder builder = new StringBuilder();
		// First we add the hour
		String hourWord;
		if (hour <= 10) {
			hourWord = units[hour - 1];
		} else {
			hourWord = teens[hour - 11];
		}

		// Now the big decision tree
		if (minute == 0) {
			// o'clock
			builder.append(hourWord);
			builder.append(" o' clock");
		} else if (minute == 30) {
			// half past
			builder.append("half past ");
			builder.append(hourWord);
		} else if (minute < 30) {
			// minutes past hour
			// Corner case, quarter past
			if (minute == 15) {
				builder.append("quarter past ");
				builder.append(hourWord);
			} else {
				// Find which group of ten
				if (minute <= 10) {
					builder.append(units[minute - 1]);
				} else if (minute <= 20) {
					builder.append(teens[minute - 11]);
				} else {
					builder.append("twenty ");
					builder.append(units[minute % 20 - 1]);
				}

				if (minute == 1) {
					builder.append(" minute past ");
				} else {
					builder.append(" minutes past ");
				}
				builder.append(hourWord);
			}

		} else if (minute > 30) {
			// minutes to hour + 1
			// corner case is quarter to
			if (minute == 45) {
				builder.append("quarter to ");
				builder.append(units[hour]);
			} else {
				int lessMinutes = 60 - minute;

				if (lessMinutes <= 10) {
					builder.append(units[lessMinutes - 1]);
				} else if (lessMinutes <= 20) {
					builder.append(teens[lessMinutes - 11]);
				} else {
					builder.append("twenty ");
					builder.append(units[lessMinutes % 20 - 1]);
				}

				if (minute == 1) {
					builder.append(" minute to ");
				} else {
					builder.append(" minutes to ");
				}
				if (hour < 10) {
					builder.append(units[hour]);
				} else {
					builder.append(teens[hour - 10]);
				}
			}

		}
		// System.out.println(builder.toString());
		return builder.toString();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// First input is hour
		int hour = in.nextInt();
		// Second is minute
		int minute = in.nextInt();

		System.out.println(timeToWords(hour, minute));
		in.close();
	}

}
