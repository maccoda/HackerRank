package algorithmstest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithms.ChocolateFeast;

public class ChocolateFeast_Test {

    @Test
    public void testChocolateFeast() {
        assertEquals(6, ChocolateFeast.chocolateFeast(10, 2, 5));
        assertEquals(3, ChocolateFeast.chocolateFeast(12, 4, 4));
        assertEquals(5, ChocolateFeast.chocolateFeast(6, 2, 2));
    }

}
