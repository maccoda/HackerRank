package javaintroductiontest;

import static org.junit.Assert.assertTrue;
import javaintroduction.JavaStrings;

import org.junit.Test;

public class JavaStrings_Test {

    @Test
    public void testStrings() {
        assertTrue(JavaStrings.javaStrings("welcometojava", 3).equals(
                "ava\nwel"));
    }

}
