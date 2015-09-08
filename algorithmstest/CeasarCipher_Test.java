package algorithmstest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import algorithms.CaesarCipher;

public class CeasarCipher_Test {

    @Test
    public void testCipher() {
        String s1 = "Hello_World!";
        String s2 = "Lipps_Asvph!";
        assertTrue(CaesarCipher.encrypt(s1.toCharArray(), 4).equals(s2));
    }

}
