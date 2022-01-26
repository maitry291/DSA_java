package DSA_Tries;

public class Test {
    public static void main(String[] args) {
        Trie trie=new Trie();
        trie.addWord("maitry");
        trie.addWord("jeel");
        trie.addWord("jeelMaitry");
        trie.addWord("kavya");
        trie.addWord("kavyaroshan");

        trie.display();
        System.out.println(trie.searchWord("maitry"));
        trie.removeWord("kavya");
        trie.display();
    }
}
