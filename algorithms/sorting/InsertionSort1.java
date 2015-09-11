package algorithms.sorting;

import java.util.Scanner;

public class InsertionSort1 {

    // Given an array with right most out of order place it in the correct
    // position
    public static String insertionSort1(int[] ar) {
        // We know the right most value is out of order
        int temp = ar[ar.length - 1];
        int i = ar.length - 2;
        // While value at current position greater than sorting one continue
        while (i >= 0 && ar[i] > temp) {
            ar[i + 1] = ar[i];
            printArray(ar);
            i--;
        }
        // Now at right position so place it back

        ar[i + 1] = temp;
        System.out.println("Sorted");
        printArray(ar);
        System.out.println(arrayToString(ar));
        return arrayToString(ar);

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        // Fill the array
        for (int i = 0; i < s; i++) {
            ar[i] = in.nextInt();
        }
        // Send to function
        insertionSort1(ar);
        in.close();

    }

    private static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }

    private static String arrayToString(int[] ar) {
        String value = "";
        // This for loop is called enhanced for loop and is best used with
        // arrays
        // The variable on the left must be compatible with the array being used
        // which is on the right. The variable will have value of the current
        // array element
        for (int n : ar) {
            value = value + n + " ";
        }
        return value;
    }

}
