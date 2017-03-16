
/**
 * FindMinimumNumber
 */
import java.util.Scanner;

public class FindMinimumNumber {

    static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        createFunctionCall(n);
        System.out.println(builder.toString());
    }

    private static void createFunctionCall(int numInput) {
        // Best way to do this is by recursion
        if (numInput == 2) {
            builder.append("min(int, int)");
        } else {
            builder.append("min(int, ");
            createFunctionCall(numInput - 1);
            builder.append(")");
        }

    }

}