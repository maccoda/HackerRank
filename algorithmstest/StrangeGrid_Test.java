package algorithmstest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithms.StrangeGrid;

public class StrangeGrid_Test {

    @Test
    public void testStrangeGrid() {
        assertEquals(0, StrangeGrid.strangeGrid(1, 1));
        assertEquals(3, StrangeGrid.strangeGrid(2, 2));
        assertEquals(19, StrangeGrid.strangeGrid(4, 5));
        assertEquals(25, StrangeGrid.strangeGrid(6, 3));
    }

}
