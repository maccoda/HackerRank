package algorithms;

import java.util.Scanner;

/*
 * You are given an integer, N. Write a program to determine if N is an element of the Fibonacci sequence.

 The first few elements of the Fibonacci sequence are 0,1,1,2,3,5,8,13,⋯. A Fibonacci sequence is one where
 every element is a sum of the previous two elements in the sequence. The first two elements are 0 and 1.
 */
public class IsFibo {

    public static String isFibo(long x) {

        // By some research we can tell is a number x is a Fibonacci number iff
        // 5x^2 + 4 and/or 5x^2 - 4 is a perfect square

        // First perform the maths
        long result1 = 5 * x * x + 4;
        long result2 = 5 * x * x - 4;

        if ((Math.sqrt(result1) == Math.floor(Math.sqrt(result1)))
                || (Math.sqrt(result2)) == Math.floor(Math.sqrt(result2))) {
            // It is an integer hence is a square number
            return "IsFibo";
        } else {
            return "IsNotFibo";
        }
    }

    public static void main(String[] args) {

        // Get test cases
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        for (int tests = 0; tests < N; tests++) {
            System.out.println(isFibo(in.nextInt()));
        }
        in.close();

    }

}
