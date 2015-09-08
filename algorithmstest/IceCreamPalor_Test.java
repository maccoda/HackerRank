package algorithmstest;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import algorithms.IceCreamPalor;

public class IceCreamPalor_Test {

    @Test
    public void testIceCream() {
        // Get the files
        File homeDir = new File(System.getProperty("user.home"));
        File inputFile = new File(homeDir, "iceCreamTest.txt");
        File outputFile = new File(homeDir, "iceCreamOutput.txt");
        // Add them to the scanners
        Scanner input = null;
        Scanner output = null;
        try {
            output = new Scanner(outputFile);
            input = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        int M, N;
        int T = input.nextInt();
        System.out.println("T:" + T);
        for (int i = 0; i < T; i++) {
            M = input.nextInt();
            N = input.nextInt();
            System.out.println("Performing test case #" + i);
            System.out.println("M:" + M + " N:" + N);
            // Make list
            List<Integer> lists = new ArrayList<Integer>();
            for (int j = 0; j < N; j++) {
                lists.add(input.nextInt());
            }
            // Make array output
            int[] result = { output.nextInt(), output.nextInt() };
            // Run the function
            int[] funcOut = IceCreamPalor.iceCreamPalor(M, lists);
            assertEquals(result[0], funcOut[0]);
            assertEquals(result[1], funcOut[1]);
        }

    }

}
