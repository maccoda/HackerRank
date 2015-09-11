package algorithmstest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithms.strings.TheLoveLetterMystery;

public class LoveLetterMystery_Test {

    @Test
    public void testLoveLetter() {
        assertEquals(0, TheLoveLetterMystery.loveLetterMystery("abcba"));
        assertEquals(1, TheLoveLetterMystery.loveLetterMystery("abcca"));
        assertEquals(2, TheLoveLetterMystery.loveLetterMystery("abc"));
        assertEquals(4, TheLoveLetterMystery.loveLetterMystery("abcd"));
        assertEquals(2, TheLoveLetterMystery.loveLetterMystery("cba"));
    }

}
