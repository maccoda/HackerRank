package algorithms;

import java.util.Scanner;

public class ChocolateFeast {
    /*
     * Little Bob loves chocolate, and he goes to a store with $N in his pocket.
     * The price of each chocolate is $C. The store offers a discount: for every
     * M wrappers he gives to the store, he gets one chocolate for free. How
     * many chocolates does Bob get to eat?
     */

    /**
     *
     * @param N
     *            How much money takes to store
     * @param C
     *            Cost of each chocolate
     * @param M
     *            Number of wrappers needed to receive a free chocolate
     * @return Number of chocolates can eat
     */
    public static long chocolateFeast(int N, int C, int M) {
        long numChoc, numWrapper, freeChoc;
        // First calculate how many can take from what he brought
        numChoc = N / C;
        numWrapper = numChoc;
        // Check if have bought enough for discount
        while (numWrapper >= M) {
            // Find number of free chocolates
            freeChoc = numWrapper / M;
            // Take away wrappers that are used for discount
            numWrapper = numWrapper - freeChoc * M;
            // Add chocolate from discount
            numChoc += freeChoc;
            numWrapper += freeChoc;
        }
        return numChoc;
    }

    public static void main(String[] args) {
        // Get test cases
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();

        for (int i = 0; i < tests; i++) {
            System.out.println(chocolateFeast(in.nextInt(), in.nextInt(),
                    in.nextInt()));
        }
        in.close();

    }
}
