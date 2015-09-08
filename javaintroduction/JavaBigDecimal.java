package javaintroduction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * Problem Statement
 * Java BigDecimal class can handle arbitrary-precision signed decimal numbers. Lets test your knowledge on them!
 * You are given   real numbers, sort them in descending order! Read data from System.in.
 */
public class JavaBigDecimal {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numbers = in.nextInt();
        ArrayList<BigDecimal> allNums = new ArrayList<BigDecimal>(numbers);
        BigDecimal test;

        // Add them all to the array
        for (int i = 0; i < numbers; i++) {
            test = new BigDecimal(in.next());
            allNums.add(test);
        }
        // Use this command on any Collection to sort them! So simple!
        Collections.sort(allNums);
        for (int i = allNums.size() - 1; i >= 0; i--) {
            // Remove leading zero
            if (allNums.get(i).toString().length() > 2
                    && allNums.get(i).toString().substring(0, 2).equals("0.")) {
                System.out.println(allNums.get(i).toString().substring(1));
            } else {
                System.out.println(allNums.get(i));
            }
        }
        in.close();

    }
}
