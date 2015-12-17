package algorithmstest;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import algorithms.sorting.SherlockAndWatson;

public class SherlockAndWatson_Test {

    @Test
    public void testSearch() {
        // Need to read in from file
        File homeDir = new File(System.getProperty("user.home"));

        File inputFile = new File(homeDir,
                "/workspace/Hacker Rank Problems/SWInput.txt");
        File outputFile = new File(homeDir,
                "/workspace/Hacker Rank Problems/SWOutput.txt");

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
        // Size of array
        int N = input.nextInt();
        // Number of circular shifts
        int K = input.nextInt();
        // Number of queries on array
        int Q = input.nextInt();

        // Construct the array
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            list.add(input.nextInt());
        }

        for (int i = 0; i < Q; i++) {
            int query = input.nextInt();
            System.out.println("Query: " + query + ", Array size: "
                    + list.size() + " K: " + K);
            assertEquals(output.nextInt(),
                    SherlockAndWatson.sherlockSolves(list, query, K));
        }

        input.close();
        output.close();

    }

}
