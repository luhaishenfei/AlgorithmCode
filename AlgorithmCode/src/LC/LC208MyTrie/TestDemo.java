package LC.LC208MyTrie;

public class TestDemo {
    public static void main(String[] args) {
        Trie myTrie= new Trie();
        myTrie.insert("hello");
        myTrie.insert("helloWorld");
        myTrie.insert("healWorld");
        System.out.println(myTrie.search("helloWorld"));
        System.out.println(myTrie.startsWith("healW"));
        System.out.println(myTrie);
    }
}
