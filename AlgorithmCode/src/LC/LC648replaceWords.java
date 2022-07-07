package LC;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import LC.LC208MyTrie.Trie;

/*
648. 单词替换
在英语中，我们有一个叫做 词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
你需要输出替换之后的句子。



示例 1：

输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
输出："the cat was rat by the bat"
示例 2：

输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
输出："a a b c"


提示：

1 <= dictionary.length <= 1000
1 <= dictionary[i].length <= 100
dictionary[i] 仅由小写字母组成。
1 <= sentence.length <= 10^6
sentence 仅由小写字母和空格组成。
sentence 中单词的总量在范围 [1, 1000] 内。
sentence 中每个单词的长度在范围 [1, 1000] 内。
sentence 中单词之间由一个空格隔开。
sentence 没有前导或尾随空格。

 */
public class LC648replaceWords {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("hotWind");
        list.add("asdd");
        list.add("aa");
        list.add("bb");
        list.add("a");
        list.add("b");
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length()==o2.length()){
                    return o2.charAt(0)-o1.charAt(0);
                }
                return o2.length()-o1.length();
            }
        });
        System.out.println(list);
    }
    /*
dictionary = ["a","b","c","aa"], sentence = "aadsfasf absbs bbab cadsfafs"
"a a b c" PASS
"aa aa b c" WRONG
     */

    /*
    我自己的Trie类,LC的Trie也就比我快了一丢丢(也可能是正常波动)
    执行结果：
通过
显示详情
添加备注

执行用时：
105 ms
, 在所有 Java 提交中击败了
22.87%
的用户
内存消耗：
49.2 MB
, 在所有 Java 提交中击败了
66.80%
的用户
通过测试用例：
126 / 126
     */
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] sentences = sentence.split(" ");
        String res="";
        for (int i = 0; i < sentences.length; i++) {
            Trie trie = new Trie();
            trie.insert(sentences[i]);
            /*
             dictionary.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (o1.length()==o2.length()){
                        return o1.charAt(0)-o2.charAt(0);
                    }
                    return o1.length()-o2.length();
                }
            });
             */
            dictionary.sort((o1, o2) -> {
                if (o1.length()==o2.length()){
                    return o2.charAt(0)-o1.charAt(0);
                }
                return o2.length()-o1.length();
            });
            for (String dic :
                    dictionary) {
                if (trie.startsWith(dic)){
                    sentences[i]=dic;
                }
            }
            if (i==sentences.length-1) {
                res = res + sentences[i] ;
            }else {
                res = res + sentences[i] +" ";
            }
        }
        return res;
    }

    /*
    LC Tire

    执行用时：13 ms,
    在所有 Java 提交中击败了59.93%的用户
    内存消耗：54.3 MB,
    在所有 Java 提交中击败了11.74%的用户

    class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String word : dictionary) {
            Trie cur = trie;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                cur.children.putIfAbsent(c, new Trie());
                cur = cur.children.get(c);
            }
            cur.children.put('#', new Trie());
        }
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = findRoot(words[i], trie);
        }
        return String.join(" ", words);
    }

    public String findRoot(String word, Trie trie) {
        StringBuffer root = new StringBuffer();
        Trie cur = trie;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children.containsKey('#')) {
                return root.toString();
            }
            if (!cur.children.containsKey(c)) {
                return word;
            }
            root.append(c);
            cur = cur.children.get(c);
        }
        return root.toString();
    }
}

class Trie {
    Map<Character, Trie> children;

    public Trie() {
        children = new HashMap<Character, Trie>();
    }
}

     */
}
