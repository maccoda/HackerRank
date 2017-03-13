package algorithms.search;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Pairs {
    static int pairs(int[] a, int k) {
        /* Complete this function */
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        int result = 0;
        // Populate the map, this is faster as insert in map is O(1)
        for (int i = 0; i < a.length; i++) {
            // If it is part of the set the value will be one
            m.put(a[i], 1);
        }
        // Now need to search
        for (int i = 0; i < a.length; i++) {
            // Will be null if haven't added an entry
            if (m.get(a[i] - k) != null) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        String n = in.nextLine();
        String[] n_split = n.split(" ");

        int _a_size = Integer.parseInt(n_split[0]);
        int _k = Integer.parseInt(n_split[1]);

        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");

        for (int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }

        res = pairs(_a, _k);
        System.out.println(res);
        in.close();
    }
}
