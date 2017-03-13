package algorithms.dynamicprog;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Goal is to find the maximum sum of a contiguous and non-contiguous subarray of 
 * the given array
 */
public class MaximumSubarray {

	public static String findMax(List<Integer> list) {
		// Very simply we can solve the non-contiguous sum by only adding all
		// positive numbers
		// The video shows that it is possible to have an O(n) solution

		int bestSum = 0;
		int currentSum = 0;
		int nonContigSum = 0;
		for (Integer value : list) {
			// Test next value
			int testSum = currentSum + value;
			if (testSum > 0) {
				currentSum = testSum;
			} else {
				currentSum = 0;
			}

			// Then check if current sum is better than best sum
			if (currentSum > bestSum) {
				bestSum = currentSum;
			}
			// This section is for the non-contiguous sum
			if (value > 0) {
				nonContigSum += value;
			}

		}
		// Until I better understand the algorithm will implement the all
		// negative case separately

		// If we get out of the loop and our best sums were 0 that means we
		// have an entirely negative array so can perform a corner case test
		// still O(n)
		if (bestSum == 0) {
			// Have a starting element
			bestSum = list.get(0);
			for (Integer value : list) {
				if (value > bestSum) {
					bestSum = value;
				}
			}
			nonContigSum = bestSum;
		}
		// System.out.println(bestSum + " " + nonContigSum);
		return bestSum + " " + nonContigSum;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tests = in.nextInt();

		for (int i = 0; i < tests; i++) {
			// Create the array
			List<Integer> list = new ArrayList<Integer>();
			int numElements = in.nextInt();

			for (int j = 0; j < numElements; j++) {
				list.add(in.nextInt());
			}
			System.out.println(findMax(list));
		}
		in.close();

	}

}
