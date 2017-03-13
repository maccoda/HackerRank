package algorithmstest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithms.Handshake;

public class Handshake_Test {

    @Test
    public void testHandshake() {
        assertEquals(0, Handshake.handshake(1));
        assertEquals(1, Handshake.handshake(2));
        assertEquals(3, Handshake.handshake(3));
        assertEquals(6, Handshake.handshake(4));
        assertEquals(10, Handshake.handshake(5));
    }
}
