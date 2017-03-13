package javaintroduction;

import java.util.Scanner;

interface AdvancedArithmetic {
    public abstract int divisorSum(int n);
}

public class JavaInterface {

    public static void main(String[] argh) {
        MyCalculator my_calculator = new MyCalculator();
        System.out.print("I implemented: ");
        ImplementedInterfaceNames(my_calculator);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(my_calculator.divisorSum(n) + "\n");
        sc.close();

    }

    /*
     * ImplementedInterfaceNames method takes an object and prints the name of
     * the interfaces it implemented
     */
    static void ImplementedInterfaceNames(Object o) {

        Class[] theInterfaces = o.getClass().getInterfaces();
        for (int i = 0; i < theInterfaces.length; i++) {
            String interfaceName = theInterfaces[i].getName();
            System.out.println(interfaceName);
        }
    }
}

class MyCalculator implements AdvancedArithmetic {

    @Override
    public int divisorSum(int n) {
        int result = 0;
        // Want to get sum of all divisors of n
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                result += i;
            }
        }
        return result;
    }

}
