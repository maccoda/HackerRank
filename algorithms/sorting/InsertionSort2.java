package algorithms.sorting;

import java.util.Scanner;

public class InsertionSort2 {
    /*
     * Perform insertion sort on an entire array using the previous code for
     * sorting a single element
     */

    public static void insertionSortPart2(int[] ar) {
        // We start at the left and first of all we know that the left most
        // value must be sorted when only looking at an array of length 1, so
        // move onto second value
        for (int i = 1; i < ar.length; i++) {
            int current = ar[i];
            int j = i - 1;
            // While value at current position greater than sorting one continue
            while (j >= 0 && ar[j] > current) {
                // Shift the element along
                ar[j + 1] = ar[j];
                j--;
            }
            // Put current element back
            ar[j + 1] = current;
            printArray(ar);
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for (int i = 0; i < s; i++) {
            ar[i] = in.nextInt();
        }
        insertionSortPart2(ar);
        in.close();
    }

    private static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }

}
