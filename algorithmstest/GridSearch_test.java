package algorithmstest;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

import algorithms.implementations.GridSearch;

public class GridSearch_test {
    @Test
    public void testSearch() {
        // Need to read in from file
        File homeDir = new File(System.getProperty("user.home"));

        File inputFile = new File(homeDir,
                "/workspace/Hacker Rank Problems/GridSearchInput.txt");
        File outputFile = new File(homeDir,
                "/workspace/Hacker Rank Problems/GridSearchOutput.txt");

        // System.out.println(inputFile.getAbsolutePath());
        Scanner input = null;
        Scanner output = null;
        try {
            input = new Scanner(inputFile);
            output = new Scanner(outputFile);
        } catch (FileNotFoundException e) {
            System.out.println("File not found! Cannot perform test.");
        }
        // Now essentially just perform the same task as the main method
        // Check number of tests
        int tests = input.nextInt();
        for (int i = 0; i < tests; i++) {
            // Next is big grid size
            int bigRows = input.nextInt();
            int bigCols = input.nextInt();
            System.out.println("Grid size: " + bigRows + "x" + bigCols);

            // Will store the grid as strings as will mean can check chunks
            // easier
            // Each row of the grid is stored as a single string
            String[] grid = new String[bigRows];
            for (int j = 0; j < grid.length; j++) {
                grid[j] = input.next();
            }
            // Now grab the checking grid
            int smallRows = input.nextInt();
            int smallCols = input.nextInt();
            System.out.println("Pattern size: " + smallRows + "x" + smallCols);
            String[] pattern = new String[smallRows];
            for (int j = 0; j < pattern.length; j++) {
                pattern[j] = input.next();
            }
            // Now can search
            System.out.println("Iteration: " + i);
            assertTrue(GridSearch.checkGrid(grid, pattern, bigCols, smallCols)
                    .equals(output.next()));
        }
    }

}
