import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * CandayReplenishingRobot
 */
public class CandyReplenishingRobot {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        int[] c = new int[t];
        for (int c_i = 0; c_i < t; c_i++) {
            c[c_i] = in.nextInt();
        }
        System.out.println(replenish(t, n, c));
    }

    public static int replenish(int time, int initial, int[] candyTaken) {
        int current = initial;
        int added = 0;
        for (int i = 0; i < candyTaken.length; i++) {
            current -= candyTaken[i];
            if (i == candyTaken.length - 1) {
                continue;
            } else if (current < 5) {
                // Possibly a nice shortcut
                added += (initial - current);
                current = initial;
            }

        }
        return added;
    }
}