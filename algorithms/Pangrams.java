package algorithms;

import java.util.Scanner;

public class Pangrams {

    public static void main(String[] args) {
        // Take input
        Scanner in = new Scanner(System.in);
        // Only a single test with input containing the line to be tested
        String input;
        char[] currentString;
        char[] alphabet = new char[26];
        // Will be 1 if used 0 if not
        byte[] used = new byte[26];
        // Check if panagram

        // Fill the alphabet
        char letter = 'a';
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = letter;
            letter++;
        }

        // Fill the used one
        for (int i = 0; i < used.length; i++) {
            used[i] = 0;
        }

        // Get the next string
        while (in.hasNext()) {
            // Need to remember that can be upper or lower case
            input = in.next().toLowerCase();
            currentString = input.toCharArray();
            // Check every element of the string
            for (int i = 0; i < currentString.length; i++) {
                // Check every letter of alphabet
                for (int j = 0; j < alphabet.length; j++) {
                    // Look for a match
                    if (alphabet[j] == currentString[i]) {
                        used[j] = 1;
                    }
                }
            }
        }
        // Confirm that each letter was used as sum should be 26
        int sum = 0;
        for (int i = 0; i < used.length; i++) {
            sum += used[i];
        }
        if (sum == 26) {
            System.out.println("pangram");
        } else {
            System.out.println("not pangram");
        }

        in.close();
    }

}
