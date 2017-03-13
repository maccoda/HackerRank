package algorithmstest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import algorithms.sorting.InsertionSort1;

public class InsertionSort1_Test {

    @Test
    public void testInsertionSort1() {
        int[] n = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 1 };
        assertTrue(InsertionSort1.insertionSort1(n)
                .equals("1 2 3 4 5 6 7 8 9 10 "));

    }
}
