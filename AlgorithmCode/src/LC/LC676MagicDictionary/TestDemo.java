package LC.LC676MagicDictionary;

public class TestDemo {
    public static void main(String[] args) {
        MagicDictionary m = new MagicDictionary();
        m.buildDict(new String[]{"hello", "world", "hi", "nihao"});
        System.out.println(m.dic);
        System.out.println(m.search("hhllo"));
        System.out.println(m.search("hhloo"));
    }
}
