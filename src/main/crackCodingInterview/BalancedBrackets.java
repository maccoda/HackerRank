package crackCodingInterview;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    final static List<Character> OPEN_BRACKETS = Arrays.asList('(', '{', '[');

    final static List<Character> CLOSE_BRACKETS = Arrays.asList(']', '}', ')');

    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (isOpeningBracket(ch)) {
                stack.push(ch);
            } else if (isClosingBracket(ch)) {
                if(stack.isEmpty()){
                    return false;
                }
                char opening = stack.pop();
                if (!isMatching(opening, ch)) {
                    return false;
                }
            } else {
                // Do nothing, not a bracket
            }
        }
        return stack.isEmpty();
    }

    private static boolean isMatching(char open, char close) {
        if (open == '(') {
            return close == ')';
        } else if (open == '{') {
            return close == '}';
        } else if (open == '[') {
            return close == ']';
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isOpeningBracket(char ch) {
        return OPEN_BRACKETS.contains(ch);
    }

    private static boolean isClosingBracket(char ch) {
        return CLOSE_BRACKETS.contains(ch);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println((isBalanced(expression)) ? "YES" : "NO");
        }
    }
}
