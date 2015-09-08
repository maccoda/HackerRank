package projecteuler;

import java.util.Scanner;

public class Multiples3and5 {

    public static long multiples(int n) {
        long sum = 0;
        int three, five;
        three = 3;
        five = 5;
        while (three < n) {
            if (five < n && five % 3 != 0) {
                sum += five;
            }
            sum += three;
            // Increment
            three += 3;
            five += 5;

        }

        return sum;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            System.out.println(multiples(in.nextInt()));
        }

        in.close();
    }

}
