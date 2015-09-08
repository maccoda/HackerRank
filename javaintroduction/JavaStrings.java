package javaintroduction;

import java.util.Scanner;

public class JavaStrings {
    /**
     *
     * @param s
     *            string provided which need to determine largest and smallest
     *            Lexicographic substring
     * @param k
     *            size of the substrings
     */
    public static String javaStrings(String s, int k) {
        int start, end;
        String smallest, largest, current;

        // Initialise
        start = 0;
        end = k;
        current = s.substring(start, end);
        smallest = "z";
        largest = "A";
        for (int i = 0; i < k; i++) {
            smallest = smallest + "z";
            largest = largest + "A";
        }

        // We search through every possibility from the start
        while (end <= s.length()) {
            // Comparable object with -1 means less than
            if (current.compareTo(smallest) < 0) {
                smallest = current;
            }
            if (current.compareTo(largest) > 0) {
                largest = current;
            }

            start++;
            end++;
            if (end <= s.length()) {
                current = s.substring(start, end);
            }
        }
        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print(javaStrings(in.next(), in.nextInt()));

        in.close();

    }

}
