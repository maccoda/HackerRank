package javaintroduction;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandling2 {

    public static int division(int a, int b) {
        return a / b;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Get the two integers
        // Want to catch the unchecked error if they aren't integers
        try {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(division(a, b));
        } catch (InputMismatchException e) {
            String s1 = e.getClass().toString();
            s1 = s1.split(" ")[1];
            System.out.println(s1);
        } catch (ArithmeticException e) {
            String s1 = e.getClass().toString();
            s1 = s1.split(" ")[1];
            System.out.println(s1);
        }

        in.close();

    }

}
