package javaintroduction;

import java.util.Scanner;

/*
 * Regular expressions (regex) are used to search text/document to match a certain pattern
 * \d represents any number(digit), \D is a non-digit
 * \s is a whitespace character, \S non whitespace
 * \w is a word character, \W is a non-word character
 * \b matches a space that is before a word
 * \w+ is one or more word characters
 * Another example is if what to specify number of characters, e.g. \d{1,5} means we are looking for 1 to 5 digits
 * To search for any character use a period (.)
 *
 * ? is 0 or 1 repetitions
 * * 0 or more repetitions
 * {n} expect to find n characters in a row
 * [a-d] or [abc] set a selection for the current character to match
 *
 * If want to search for a $ or . need to be escaped, \\. and \\$, there are several others
 *
 * There is an OR code in regular expressions which is |
 *
 * !!!!!!!!
 * In Java need to use double backslash as single backslash is reserved
 */
public class JavaRegex {

    class myRegex {
        // Pattern containing regex
        public String pattern;

        myRegex() {
            // Cannot use the string below because the can only look at a single
            // character at one time!
            // pattern = "[1-255]\\.[1-255]\\.[1-255]\\.[1-255]";
            // Want to look for 0 - 255 for each of the strings
            // Use the $1 as this makes it easy to repeat already used regex
            // which is contained within parenthesis and the number corresponds
            // to the occurrence of it. This is used if it is an exact
            // repetition!!!
            // Can use ? to simplify as padded zeros can occur zero or one or
            // more times
            pattern = "(00\\d|0\\d|0\\d\\d|\\d|\\d{2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(00\\d|0\\d|0\\d\\d|\\d|\\d{2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(00\\d|0\\d|0\\d\\d|\\d|\\d{2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(00\\d|0\\d|0\\d\\d|\\d|\\d{2}|1\\d\\d|2[0-4]\\d|25[0-5])\b";
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        JavaRegex outer = new JavaRegex();
        while (in.hasNext()) {
            String IP = in.next();
            System.out.println(IP.matches(outer.new myRegex().pattern));
        }
        in.close();
    }

}
