package algorithmstest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithms.implementations.FindDigits;

public class FindDigits_Test {

    @Test
    public void testFindDigits() {
        assertEquals(2, FindDigits.findDigits(24));
        assertEquals(3, FindDigits.findDigits(122));
        assertEquals(2, FindDigits.findDigits(12));
        assertEquals(3, FindDigits.findDigits(1012));
    }
}
