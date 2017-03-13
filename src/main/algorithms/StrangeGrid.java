package algorithms;

import java.util.Scanner;

public class StrangeGrid {
    /*
     * It is a strange grid for which we need to find the integer at a
     * particular row and column. The bottom row is considered the first row.
     * The grid is not given as input but rather we need to find the pattern
     * present. It appears to be that the transition form 1 to 2 is add 1 but
     * from 2 to 3 is add 9. There are only 5 columns which initialse as all
     * even integers below 10
     */

    public static long strangeGrid(int row, int column) {
        /*
         * // Initialise the return value int value = 2 * (column - 1); // Want
         * to work with row of zero index row--;
         * 
         * // Add 1 every second line value += (row / 2) * 1; // Add 9 every
         * second line value += (row / 2) * 9; // Need to account for integer
         * division of odds if (row % 2 != 0) { value += 1; } return value;
         */
        long value;
        if (row % 2 == 0) {
            long temprow = (((row / 2) - 1) * 10);
            long tempcol = ((column * 2) - 1);
            value = temprow + tempcol;
        } else {
            long temprow = ((row / 2) * 10);
            long tempcol = ((column - 1) * 2);
            value = tempcol + temprow;
        }
        return value;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println(strangeGrid(in.nextInt(), in.nextInt()));

        in.close();

    }

}
