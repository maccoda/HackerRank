package crackCodingInterview;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestBalancedBrackets {

    @Test
    public void test() {
        assertTrue(BalancedBrackets.isBalanced("{[()]}"));
        assertFalse(BalancedBrackets.isBalanced("{[(])}"));
        assertTrue(BalancedBrackets.isBalanced("{{[[(())]]}}"));

        assertTrue(BalancedBrackets.isBalanced("{{[y[((asd))]]}}"));
        assertFalse(BalancedBrackets.isBalanced("}][}}(}][))]"));
        assertTrue(BalancedBrackets.isBalanced("[](){()}"));
        assertTrue(BalancedBrackets.isBalanced("()"));
        assertTrue(BalancedBrackets.isBalanced("({}([][]))[]()"));
        assertFalse(BalancedBrackets.isBalanced("{)[](}]}]}))}(())("));
    }

    @Test
    public void testWithInputs() throws Exception{
        String path = TestBalancedBrackets.class.getClassLoader().getResource("balanced_bracket_in.txt").getPath();
        List<String> inLines = Files.readAllLines(Paths.get(path)).stream().skip(1).collect(Collectors.toList());
        path = TestBalancedBrackets.class.getClassLoader().getResource("balanced_bracket_out.txt").getPath();
        List<String> outLines = Files.readAllLines(Paths.get(path));
        assertEquals(inLines.size(), outLines.size());

        for(int i = 0; i < inLines.size(); i++) {
            boolean expected = outLines.get(i).equals("YES");
            boolean actual = BalancedBrackets.isBalanced(inLines.get(i));
            if(expected != actual) {
                System.out.println("FAIL: " + inLines.get(i));
            }
            assertEquals(expected, actual);
        }
    }
}
