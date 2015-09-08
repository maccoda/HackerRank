package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class IceCreamPalor {

    private static Scanner in;

    /**
     * @param M
     *            amount of money have
     * @param N
     *            number of flavours at the parlor
     * @return two flavours that add up to M, need to return their indexes
     */
    public static int[] iceCreamPalor(int M, List<Integer> flavours) {
        // Put into a map and if the difference exists we have our solution!
        HashMap<Integer, Integer> flav = new HashMap<Integer, Integer>();
        int currentCost;
        for (int i = 0; i < flavours.size(); i++) {
            currentCost = flavours.get(i);
            // System.out.println("iteration:" + i + " key:" + key);

            // We will get the map to store the number of occurrences
            // Use boxed class so can catch if null
            Integer numOccurences = flav.get(currentCost);
            flav.put(currentCost,
                    numOccurences == null ? 1 : numOccurences + 1);

            // Now we check the remainder
            int remainder = M - currentCost;

            // Grab corner case of M/2
            Integer numNeeded = remainder == currentCost ? 2 : 1;

            // See if it is in the map
            if (flav.get(remainder) == numNeeded) {
                return new int[] { findLinear(remainder, flavours) + 1, i + 1 };
            }
        }
        // Good to add at end rather than throw null
        throw new IllegalArgumentException("Cannot find a solution");
    }

    private static int findLinear(int target, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == target) {
                return i;
            }
        }
        return -1;
    }

    /*
     * Returns the index of the key
     */
    /*
     * private static int binarySearch(ArrayList<Integer> list, int key) { int
     * low, mid, high; low = 0; high = list.size(); Collections.sort(list);
     * while (low <= high) { mid = (high - low) / 2; if (list.get(mid) == key) {
     * return mid; // a match is found } else if (list.get(mid) < key) { // if
     * middle element is less than // the key low = mid + 1; // key will be
     * right part if it exists } else { high = mid - 1; // otherwise key will be
     * in left part if it // exists } } return -1; // No such element exists }
     */
    public static void main(String[] args) {
        in = new Scanner(System.in);

        int tests = in.nextInt();

        for (int i = 0; i < tests; i++) {
            int M = in.nextInt();
            int N = in.nextInt();
            List<Integer> flavours = new ArrayList<Integer>();
            for (int j = 0; j < N; j++) {
                // Make the list
                flavours.add(in.nextInt());
            }

            int[] result = iceCreamPalor(M, flavours);
            System.out.println(result[0] + " " + result[1]);
        }
        in.close();
    }
}
