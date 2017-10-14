package crackCodingInterview;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestContacts {

    @Test
    public void test1() {
        Contacts.ContactsTrie trie = new Contacts.ContactsTrie();
        trie.add("hack");
        trie.add("hackerrank");
        assertEquals(2,trie.find("hac"));
        assertEquals(0, trie.find("hak"));
    }
}
