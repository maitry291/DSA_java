package DSA_Tries;

public class Test {
    public static void main(String[] args) {
        Trie trie=new Trie();
        trie.addWord("maitry");
        trie.addWord("jeel");
        trie.addWord("jeelMaitry");

        trie.display();
    }
}
