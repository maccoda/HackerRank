import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Iterator;

interface NewIterator {
    public Optional<Character> next();

    public void restart();
}

public class MelodiousPassword {

    static class VowelIter implements NewIterator {
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
        Iterator<Character> iter;

        public VowelIter() {
            iter = vowels.iterator();
        }

        public Optional<Character> next() {
            if (iter.hasNext()) {
                return Optional.of(iter.next());
            } else {
                return Optional.empty();
            }
        }

        public void restart() {
            iter = vowels.iterator();
        }
    }

    static class ConsonantIter implements NewIterator {
        List<Character> consonants = Arrays.asList('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r',
                's', 't', 'v', 'w', 'x', 'z');

        Iterator<Character> iter;

        public ConsonantIter() {
            iter = consonants.iterator();
        }

        public Optional<Character> next() {
            if (iter.hasNext()) {
                return Optional.of(iter.next());
            } else {
                return Optional.empty();
            }
        }

        public void restart() {
            iter = consonants.iterator();
        }
    }

    static interface PasswordGenerator {
        public Optional<String> next();
    }

    static class VowelPasswordGenerator implements PasswordGenerator {
        private List<NewIterator> chars;
        // Should really have a current word
        private char[] word;

        public VowelPasswordGenerator(int length) {
            chars = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                if (i % 2 == 0) {
                    chars.add(new VowelIter());
                } else {
                    chars.add(new ConsonantIter());
                }

            }
        }

        public Optional<String> next() {
            if (word == null) {
                word = new char[chars.size()];
                for (int i = 0; i < chars.size(); i++) {
                    NewIterator iter = chars.get(i);
                    word[i] = iter.next().get();
                }
                return Optional.of(new String(word));
            } else {
                // Will be the same as counting, go the most right and if that has been entirely consumed
                // restart that one and increment the next left one, and so on until the most left one has 
                // been consumed then should be done
                int index = chars.size() - 1;
                while (index >= 0) {
                    Optional<Character> result = chars.get(index).next();
                    if (!result.isPresent()) {
                        chars.get(index).restart();
                        index--;
                    } else {
                        // Make the new word
                        word[index] = result.get();
                        return Optional.of(new String(word));
                    }
                }
                // If we reach here have gone all the way back to the front
                return Optional.empty();
            }
        }
    }

    static class ConsonantPasswordGenerator implements PasswordGenerator {
        private List<NewIterator> chars;
        private char[] word;

        public ConsonantPasswordGenerator(int length) {
            chars = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                if (i % 2 == 0) {
                    chars.add(new ConsonantIter());
                } else {
                    chars.add(new VowelIter());
                }
            }
        }

        // TODO Tidy this up as there is a lot of duplication
        public Optional<String> next() {
            if (word == null) {
                word = new char[chars.size()];
                for (int i = 0; i < chars.size(); i++) {
                    NewIterator iter = chars.get(i);
                    word[i] = iter.next().get();
                }
                return Optional.of(new String(word));
            } else {
                // Will be the same as counting, go the most right and if that has been entirely consumed
                // restart that one and increment the next left one, and so on until the most left one has 
                // been consumed then should be done
                int index = chars.size() - 1;
                while (index >= 0) {
                    Optional<Character> result = chars.get(index).next();
                    if (!result.isPresent()) {
                        chars.get(index).restart();
                        index--;
                    } else {
                        // Make the new word
                        word[index] = result.get();
                        return Optional.of(new String(word));
                    }
                }
                // If we reach here have gone all the way back to the front
                return Optional.empty();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        melodiousPassword(n);
    }

    private static void melodiousPassword(int length) {
        // Look at all possibilities starting with consonant
        ConsonantPasswordGenerator cGen = new ConsonantPasswordGenerator(length);
        Optional<String> nextWord;
        while ((nextWord = cGen.next()).isPresent()) {
            System.out.println(nextWord.get());
        }
        // Look at all possibilities starting with vowels
        VowelPasswordGenerator vGen = new VowelPasswordGenerator(length);
        while ((nextWord = vGen.next()).isPresent()) {
            System.out.println(nextWord.get());
        }
    }
}