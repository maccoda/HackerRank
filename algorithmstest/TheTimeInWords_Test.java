package algorithmstest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import algorithms.implementations.TheTimeInWords;

public class TheTimeInWords_Test {

	@Test
	public void testTimeWords() {
		assertTrue(TheTimeInWords.timeToWords(5, 00).equals("five o' clock"));
		assertTrue(TheTimeInWords.timeToWords(5, 01).equals("one minute past five"));
		assertTrue(TheTimeInWords.timeToWords(5, 10).equals("ten minutes past five"));
		assertTrue(TheTimeInWords.timeToWords(5, 30).equals("half past five"));
		assertTrue(TheTimeInWords.timeToWords(5, 40).equals("twenty minutes to six"));
		assertTrue(TheTimeInWords.timeToWords(5, 45).equals("quarter to six"));
		assertTrue(TheTimeInWords.timeToWords(5, 47).equals("thirteen minutes to six"));
		assertTrue(TheTimeInWords.timeToWords(5, 28).equals("twenty eight minutes past five"));
		assertTrue(TheTimeInWords.timeToWords(10, 57).equals("three minutes to eleven"));
	}

}
