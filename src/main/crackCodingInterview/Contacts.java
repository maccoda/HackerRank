package crackCodingInterview;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Contacts {
    enum Command {
        ADD, FIND
    }

    static class CommandObject {
        Command type;
        String data;

        CommandObject(Command aType, String aData) {
            type = aType;
            data = aData;
        }
    }

    public static CommandObject parseCommand(String op, String contact) {
        return new CommandObject(Command.valueOf(op.toUpperCase()), contact);
    }

    public static class ContactsTrie {

        TrieNode root;

        ContactsTrie() {
            root = new TrieNode();
        }

        public void execute(CommandObject cmd) {
            switch (cmd.type) {
                case ADD:
                    add(cmd.data);
                    break;
                case FIND:
                    System.out.println(find(cmd.data));
                    break;
                default:
                    throw new RuntimeException();
            }
        }

        public void add(String name) {
            root.addWord(name);
        }

        public int find(String partial) {
            return root.numberWords(partial);
        }
    }

    public static class TrieNode {
        private boolean complete;
        private Map<Character, TrieNode> nodes;

        public TrieNode() {
            nodes = new HashMap<>();
            complete = false;
        }

        public void addWord(String word) {
            if (word.isEmpty()) {
                complete = true;
                return;
            }
            char key = word.charAt(0);
            if (nodes.get(key) == null) {
                nodes.put(key, new TrieNode());
            }
            nodes.get(key).addWord(word.substring(1));
        }

        public int numberWords(String partial) {
            if (!partial.isEmpty()) {
                // If there is still content we go forward
                char key = partial.charAt(0);
                if(nodes.get(key) == null) {
                    return 0;
                } else {
                    return nodes.get(key).numberWords(partial.substring(1));
                }
            } else {
                // Else we count over all our entries
                int sum = complete ? 1 : 0;
                for(TrieNode node: nodes.values()){
                    sum += node.numberWords(partial);
                }
                return sum;
            }
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ContactsTrie trie = new ContactsTrie();
        for (int a0 = 0; a0 < n; a0++) {
            String op = in.next();
            String contact = in.next();
            CommandObject cmd = parseCommand(op, contact);
            trie.execute(cmd);
        }


    }
}
