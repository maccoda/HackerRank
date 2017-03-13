package algorithms.implementations;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ManasaAndStones {

	/*
	 * We are looking at all the possible sums if we add a and b to 0. We are
	 * able to perform num summations. Hence we want to store this as a set as
	 * we only need a single occurrence of each
	 */
	public static String findPossible(int num, int a, int b) {
		// Use a tree set as it asks for ordered output
		Set<Integer> results = new TreeSet<Integer>();

		int counter = num - 1;
		for (int i = 0; i <= counter; i++) {
			int nextEntry = (counter - i) * a + i * b;
			results.add(nextEntry);
		}
		// System.out.println(results);
		// Now need to format output to expected one
		StringBuilder builder = new StringBuilder();
		Integer[] output = new Integer[results.size()];
		results.toArray(output);
		for (int i = 0; i < results.size(); i++) {
			builder.append(output[i]);
			if (i != results.size() - 1) {
				builder.append(" ");
			}
		}
		// System.out.println(builder.toString());
		return builder.toString();
	}

	public static void main(String[] args) {
		// Just get all the information
		Scanner in = new Scanner(System.in);

		int tests = in.nextInt();

		for (int i = 0; i < tests; i++) {
			System.out.println(findPossible(in.nextInt(), in.nextInt(), in.nextInt()));
		}
		in.close();

	}

}
