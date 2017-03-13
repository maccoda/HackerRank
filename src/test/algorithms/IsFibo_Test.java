package algorithmstest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import algorithms.IsFibo;

public class IsFibo_Test {

    @Test
    public void testIsFibo() {
        assertTrue(IsFibo.isFibo(5).equals("IsFibo"));
        assertTrue(IsFibo.isFibo(7).equals("IsNotFibo"));
        assertTrue(IsFibo.isFibo(8).equals("IsFibo"));
        assertTrue(IsFibo.isFibo(63245986).equals("IsFibo"));
    }
}
