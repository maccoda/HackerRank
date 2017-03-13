package algorithms.implementations;

import java.util.Scanner;

public class ServiceLane {

    public static int serviceLane(byte[] width, int start, int stop) {
        int minValue = 3;
        for (int seg = start; seg <= stop; seg++) {
            if (width[seg] < minValue) {
                minValue = width[seg];
            }
        }
        return minValue;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        // Can make an array as don't need dynamic memory
        byte[] width = new byte[N];
        // Get number of test cases
        int t = in.nextInt();
        // Next is time to populate the array
        for (int i = 0; i < N; i++) {
            width[i] = in.nextByte();
        }
        for (int i = 0; i < t; i++) {
            System.out.println(serviceLane(width, in.nextInt(), in.nextInt()));
        }
        in.close();

    }

}
