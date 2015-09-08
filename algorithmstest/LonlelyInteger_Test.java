package algorithmstest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithms.LonelyInteger;

public class LonlelyInteger_Test {

    @Test
    public void testLoneyInteger() {
        assertEquals(1, LonelyInteger.lonleyInteger(1, "1"));
        assertEquals(2, LonelyInteger.lonleyInteger(3, "1 1 2"));
        assertEquals(2, LonelyInteger.lonleyInteger(5, "0 0 1 2 1"));
    }
}
