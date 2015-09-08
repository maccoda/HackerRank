package algorithms;

import java.util.Scanner;

public class Handshake {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int test = in.nextInt();

        for (int i = 0; i < test; i++) {
            System.out.println(handshake(in.nextInt()));
        }
        in.close();

    }

    public static long handshake(int people) {
        // This problem looks like factorial so will have fun with recursion

        // Look at base case. If there is only one person there can be no
        // handshakes
        if (people == 1) {
            return 0;
        } else {
            // It is just an n choose k problem, where k is 2
            // This is a very specific case for which there is a simple solution
            // which I proved in one of my maths assignments

            // Need to perform sum from 1 to n-1
            return longSum(people - 1);
        }

    }

    private static long longSum(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + longSum(n - 1);
        }
    }

}
