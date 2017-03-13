package algorithms.strings;

import java.util.Scanner;

public class FunnyString {

    public static String funnyString(String input) {
        // Store as character array
        char[] forward;
        int length;

        length = input.length();
        char[] reverse = new char[length];
        // Put as char array to make it easier to work with
        forward = input.toCharArray();
        // Reverse string
        for (int j = 0; j < length; j++) {
            reverse[j] = forward[length - 1 - j];
        }
        // Now perform the funny check
        for (int j = 1; j < length; j++) {
            if (Math.abs(forward[j] - forward[j - 1]) == Math.abs(reverse[j]
                    - reverse[j - 1])) {
                // First check is funny, if still in loop previous
                // characters have been funny
                if (j == (length - 1)) {
                    return "Funny";
                }
            } else {
                // Only one not funny means whole string is not funny
                return "Not Funny";
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Set up to take in all test cases
        Scanner in = new Scanner(System.in);

        int cases = in.nextInt();
        for (int i = 0; i < cases; i++) {
            // Get string from input
            System.out.println(funnyString(in.next()));
        }
        in.close();
    }

}
