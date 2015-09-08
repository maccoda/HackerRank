package algorithms;

import java.util.Scanner;

/*
 Problem Statement

 Jim is off to a party and is searching for a matching pair of socks. His drawer is filled with socks,
 each pair of a different color. In its worst case scenario, how many socks (x) should Jim remove from
 his drawer after which he finds a matching pair?

 Input Format
 The first line contains the number of test cases T.
 Next T lines contains an integer N which indicates the total pairs of socks present in the drawer.

 Output Format
 Print the number of Draws (x) Jim makes in the worst case scenario.

 Constraints
 1 <= T <= 1000
 0 < N < 106
 */

public class MinimumDraws {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();

        for (int i = 0; i < tests; i++) {
            System.out.println(minDraws(in.nextInt()));
        }
        in.close();

    }

    // Want to work out worst case scenario for a given number of pairs to draw
    // any one pair of socks
    public static int minDraws(int totalPairs) {
        int result = 0;
        // Worst possible case is to draw out all individual socks then once
        // this is done the next sock drawn must be a part of a pair
        result = totalPairs + 1;

        return result;
    }

}
