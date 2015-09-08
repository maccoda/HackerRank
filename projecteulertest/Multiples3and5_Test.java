package projecteulertest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import projecteuler.Multiples3and5;

public class Multiples3and5_Test {

    @Test
    public void testMultiples() {
        assertEquals(23, Multiples3and5.multiples(10));
        assertEquals(2318, Multiples3and5.multiples(100));
        assertEquals(233168, Multiples3and5.multiples(1000));
    }
}
