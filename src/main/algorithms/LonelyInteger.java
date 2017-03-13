package algorithms;

import java.util.Scanner;

/*
 Problem Statement

 There are N integers in an array A. All but one integer occur in pairs. Your task is to find the number that
 occurs only once.

 Input Format

 The first line of the input contains an integer N, indicating the number of integers. The next line contains N
 space-separated integers that form the array A.

 Constraints

 1≤N<100
 N % 2=1 (N is an odd number)
 0≤A[i]≤100,∀i∈[1,N]

 Output Format

 Output S, the number that occurs only once.
 */

public class LonelyInteger {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();

        // The array is given as a space separated line
        String arr = in.nextLine();

        System.out.println(lonleyInteger(length, arr));

        in.close();

    }

    public static int lonleyInteger(int len, String array) {
        /*
         * First attempt. Have found out that this can simply be done by XOR
         */

        // Split the array
        String[] split_arr = array.split(" ");
        /*
         * // Now put this into an integer array ArrayList<Integer> intArray =
         * new ArrayList<Integer>(len);
         * 
         * for (int i = 0; i < len; i++) {
         * intArray.add(Integer.parseInt(split_arr[i])); } for (int i = 0; i <
         * len; i++) { System.out.println(i + ":" +
         * intArray.lastIndexOf(intArray.get(i))); if
         * ((intArray.lastIndexOf(intArray.get(i)) == i) &&
         * (intArray.indexOf(intArray.get(i)) == i)) { return intArray.get(i); }
         * } return 0;
         */
        int[] intArray = new int[len];
        for (int i = 0; i < len; i++) {
            intArray[i] = Integer.parseInt(split_arr[i]);
        }

        int result = 0;
        for (int i = 0; i < len; i++) {
            result = result ^ intArray[i];
        }
        return result;
    }
}
