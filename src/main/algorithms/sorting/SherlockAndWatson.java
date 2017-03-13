package algorithms.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SherlockAndWatson {

    /*
     * Sherlock has to determine the integer at the index provided after K
     * circular rotations of the array
     *
     */

    public static int sherlockSolves(List<Integer> list, int queryIndex,
            int K) {
        // If cyclic shift by more than length it is always the same
        K = K % list.size();
        return list.get((queryIndex + list.size() - K) % list.size());
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // Size of array
        int N = in.nextInt();
        // Number of circular shifts
        int K = in.nextInt();
        // Number of queries on array
        int Q = in.nextInt();

        // Construct the array
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            list.add(in.nextInt());
        }

        for (int i = 0; i < Q; i++) {
            System.out.println(sherlockSolves(list, in.nextInt(), K));
        }

        in.close();

    }
}
