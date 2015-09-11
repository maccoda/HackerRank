package algorithms.implementations;

import java.util.Scanner;

public class GridSearch {

    public static String checkGrid(String[] grid, String[] pattern, int C,
            int c) {
        // No need to search the entire grid as cannot flow over
        for (int row = 0; row <= (grid.length - pattern.length); row++) {
            // Again want to shift across the columns
            for (int col = 0; col <= (C - c); col++) {
                // Check the first line matches
                if (grid[row].substring(col, col + c).equals(pattern[0])) {
                    int currentRow = row;
                    while (((currentRow - row) < pattern.length)
                            && grid[currentRow].substring(col, col + c)
                                    .equals(pattern[currentRow - row])) {
                        currentRow++;
                        System.out.println(currentRow + ":" + row);
                    }
                    // If current row reached the end it is good
                    if ((currentRow - row) == pattern.length) {
                        return "YES";
                    }
                }
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Get number of test cases
        int tests = in.nextInt();

        for (int i = 0; i < tests; i++) {
            // Next is big grid size
            int bigRows = in.nextInt();
            int bigCols = in.nextInt();

            // Will store the grid as strings as will mean can check chunks
            // easier
            // Each row of the grid is stored as a single string
            String[] grid = new String[bigRows];
            for (int j = 0; j < grid.length; j++) {
                grid[j] = in.next();
            }
            // Now grab the checking grid
            int smallRows = in.nextInt();
            int smallCols = in.nextInt();
            String[] pattern = new String[smallRows];
            for (int j = 0; j < pattern.length; j++) {
                pattern[j] = in.next();
            }
            // Now can search
            System.out.println(checkGrid(grid, pattern, bigCols, smallCols));
        }
        in.close();

    }

}
