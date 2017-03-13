package algorithms.implementations;

import java.util.Scanner;

public class SherlockAndTheBeast {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int tests = in.nextInt();

        for (int i = 0; i < tests; i++) {
            System.out.println(sherlockSolvesIt(in.nextInt()));
        }
        in.close();

    }

    /*
     * Find largest decent number with N digits A Decent Number has the
     * following properties: 3, 5, or both as its digits. No other digit is
     * allowed. Number of times 3 appears is divisible by 5. Number of times 5
     * appears is divisible by 3.
     */
    public static String sherlockSolvesIt(int N) {
        /*
         * This can be entirely done by number theory as we need to solve the
         * diophantine equation 3x+5y=N. Solving this we find that all solutions
         * x=2N-5k, y=-N+3k and the base solution is when k=0. We get that
         * k=(N-1)/3+1
         */

        // Find base solutions of number of 5's (x) and 3's (y)
        int numOfFives = 2 * N;
        int numOfThrees = -1 * N;

        int k = (N - 1) / 3 + 1;

        int x = numOfFives - 5 * k;
        int y = numOfThrees + 3 * k;

        // If x is negative there are no solutions
        if (x < 0) {
            return "-1";
        }
        // System.out.println("x: " + x + " y: " + y);

        /*
         * numOfThrees = 5 * y; numOfFives = 3 * x;
         */
        // System.out.println("3's " + numOfThrees + "..... 5's " + numOfFives);

        // Now know the number of each number

        // Don't use concatenation use string builder!!!
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < x; i++) {
            builder.append("555");
        }
        for (int i = 0; i < y; i++) {
            builder.append("33333");
        }
        String result = builder.toString();
        // Null check
        if (result == "") {
            result = "-1";
        }
        return result;

    }
}
