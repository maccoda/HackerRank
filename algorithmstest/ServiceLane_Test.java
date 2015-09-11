package algorithmstest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithms.implementations.ServiceLane;

public class ServiceLane_Test {

    @Test
    public void testServiceLane() {
        byte[] myArray = { 2, 3, 1, 2, 3, 2, 3, 3 };
        assertEquals(1, ServiceLane.serviceLane(myArray, 0, 3));
        assertEquals(2, ServiceLane.serviceLane(myArray, 4, 6));
        assertEquals(3, ServiceLane.serviceLane(myArray, 6, 7));
        assertEquals(2, ServiceLane.serviceLane(myArray, 3, 5));
        assertEquals(1, ServiceLane.serviceLane(myArray, 0, 3));
    }

}
