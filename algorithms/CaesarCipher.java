package algorithms;

import java.util.Scanner;

public class CaesarCipher {

    public static String encrypt(char[] message, int cipher) {
        // Shift it by cipher
        char[] result = new char[message.length];
        for (int i = 0; i < message.length; i++) {
            // Need to check that it is a letter
            if (Character.isAlphabetic(message[i])) {
                // Need to check if it is uppercase or lower case
                char start = Character.isLowerCase(message[i]) ? 'a' : 'A';
                result[i] = (char) (start + (message[i] - start + cipher) % 26);
            } else {
                // Not an alphabet character
                result[i] = message[i];
            }
        }
        System.out.println(result.toString());
        return new String(result);

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] message = new char[in.nextInt()];
        String input = in.next();
        message = input.toCharArray();
        System.out.println(encrypt(message, in.nextInt()));
        in.close();
    }

}
