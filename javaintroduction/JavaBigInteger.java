package javaintroduction;

import java.math.BigInteger;
import java.util.Scanner;

/*
 * Problem Statement

 In this problem you have to add and multiply huge numbers! These numbers are so big that you can't contain
 them in any ordinary data types like long integer.

 Use the power of Java's BigInteger class and solve this problem.
 */
public class JavaBigInteger {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        BigInteger sum, product, a, b;
        sum = new BigInteger("0");

        a = in.nextBigInteger();
        b = in.nextBigInteger();
        in.close();

        sum = sum.add(a);
        sum = sum.add(b);

        product = a;
        product = product.multiply(b);

        System.out.println(sum);
        System.out.println(product);

    }

}
