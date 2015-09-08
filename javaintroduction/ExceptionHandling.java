package javaintroduction;

import java.util.Scanner;

public class ExceptionHandling {

    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int n = in.nextInt();
            int p = in.nextInt();
            myCalculator M = new myCalculator();
            try {
                System.out.println(M.power(n, p));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        in.close();

    }
}

class myCalculator {

    /**
     *
     * @param n
     *            base number
     * @param p
     *            exponent
     * @return n^p
     */
    public long power(int n, int p) throws Exception {
        long result = 1;

        if (n < 0 || p < 0) {
            throw new Exception("n and p should be non-negative");
        } else {
            for (int i = 0; i < p; i++) {
                result = result * n;
            }
        }
        return result;
    }
}
