package algorithmstest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import algorithms.implementations.ManasaAndStones;

public class ManasaAndStones_Test {

	@Test
	public void testStones() {
		assertTrue(ManasaAndStones.findPossible(3, 1, 2).equals("2 3 4"));
		assertTrue(ManasaAndStones.findPossible(4, 10, 100).equals("30 120 210 300"));
	}

}
