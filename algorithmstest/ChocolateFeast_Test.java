package algorithmstest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ChocolateFeast_Test {

    @Test
    public void testChocolateFeast() {
        assertEquals(6, algorithms.implementations.ChocolateFeast
                .chocolateFeast(10, 2, 5));
        assertEquals(3, algorithms.implementations.ChocolateFeast
                .chocolateFeast(12, 4, 4));
        assertEquals(5, algorithms.implementations.ChocolateFeast
                .chocolateFeast(6, 2, 2));
    }

}
