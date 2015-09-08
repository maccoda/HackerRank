package algorithms;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Problem Statement

 You are given an integer N. Find the digits in this number that exactly divide N (division that leaves 0 as
 remainder) and display their count. For N=24, there are 2 digits (2 & 4). Both of these digits exactly divide 24.
 So our answer is 2.
 */
public class FindDigits {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();

        for (int i = 0; i < test; i++) {
            System.out.println(findDigits(in.nextInt()));
        }
        in.close();

    }

    public static int findDigits(int N) {
        int result = 0;

        // Let's try by splitting the thing into an array
        ArrayList<Integer> theArray = intToArray(N);

        for (int i = 0; i < theArray.size(); i++) {
            if (theArray.get(i) != 0 && N % theArray.get(i) == 0) {
                result++;
            }
        }
        return result;
    }

    private static ArrayList<Integer> intToArray(int N) {
        // Turn N into an array
        ArrayList<Integer> array = new ArrayList<Integer>();

        do {
            array.add(N % 10);
            // Now shrink n
            N = N / 10;
        } while (N > 0);
        return array;
    }

}
