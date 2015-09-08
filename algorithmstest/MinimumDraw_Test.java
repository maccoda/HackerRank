package algorithmstest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithms.MinimumDraws;

public class MinimumDraw_Test {

    @Test
    public void testMinDraw() {
        assertEquals(2, MinimumDraws.minDraws(1));
        assertEquals(3, MinimumDraws.minDraws(2));
    }
}
