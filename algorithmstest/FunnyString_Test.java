package algorithmstest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import algorithms.FunnyString;

public class FunnyString_Test {

    // This is an annotation,it is a piece of meta data about the code. Stronger
    // than a comment but weaker than code

    // This is used juint testing to determine during its reflection where it
    // will run its test
    @Test
    public void testFunnyString() {
        assertTrue(FunnyString.funnyString("acxz").equals("Funny"));
        assertTrue(FunnyString.funnyString("bcxz").equals("Not Funny"));
        // Use assertEquals if the result is a primitive type

    }

}
