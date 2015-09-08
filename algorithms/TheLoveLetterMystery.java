package algorithms;

import java.util.Scanner;

/*
 * James found a love letter his friend Harry has written for his girlfriend. James is a prankster,
 * so he decides to meddle with the letter. He changes all the words in the letter into palindromes.

 To do this, he follows two rules:

 (1)He can reduce the value of a letter, e.g. he can change d to c, but he cannot change c to d.
 (2)In order to form a palindrome, if he has to repeatedly reduce the value of a letter, he can do it
 until the letter becomes a. Once a letter has been changed to a, it can no longer be changed.

 Each reduction in the value of any letter is counted as a single operation. Find the minimum number
 of operations required to convert a given string into a palindrome.
 */

public class TheLoveLetterMystery {

    public static int loveLetterMystery(String input) {
        /*
         * We need to check how many changes need to be made to the input to
         * make the word a palindrone. We want to give the minimum number back.
         * So we have to check for both ways if we make changes to the front or
         * if we make it to the back
         */

        // First we want to know the length of the input as want to match the
        // front with the back
        int lengthString = input.length();

        // Look at different between mirrored characters
        char[] inputChars = input.toCharArray();

        int changes = 0;

        for (int j = 0; j < (lengthString / 2); j++) {
            if (inputChars[j] != inputChars[lengthString - 1 - j]) {
                // The mirrored characters aren't the same
                changes += Math.abs(inputChars[j]
                        - inputChars[lengthString - 1 - j]);
            }
        }

        return changes;

    }

    public static void main(String[] args) {
        // Set up for all test cases
        Scanner in = new Scanner(System.in);

        // Get number of test cases
        int N = in.nextInt();

        for (int i = 0; i < N; i++) {
            System.out.println(loveLetterMystery(in.next()));
        }
        in.close();
    }

}
