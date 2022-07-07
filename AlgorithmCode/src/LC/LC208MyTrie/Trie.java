package LC.LC208MyTrie;


import java.util.HashMap;
import java.util.Map;

/*
Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。

请你实现 Trie 类：

Trie() 初始化前缀树对象。
void insert(String word) 向前缀树中插入字符串 word 。
boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。

示例：

输入
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
输出
[null, null, true, false, true, null, true]

解释
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // 返回 True
trie.search("app");     // 返回 False
trie.startsWith("app"); // 返回 True
trie.insert("app");
trie.search("app");     // 返回 True
 

提示：

1 <= word.length, prefix.length <= 2000
word 和 prefix 仅由小写英文字母组成
insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次

 */

/*
执行用时：
56 ms
, 在所有 Java 提交中击败了
10.09%
的用户
内存消耗：
53.2 MB
, 在所有 Java 提交中击败了
7.63%
的用户
通过测试用例：
16 / 16
 */
//speed little slow,maybe not a little,a lot
//LC uses 26 arrays Trie[26];
class Trie {
    boolean isEnd;
    Map<Object, Trie> map;

    Trie(boolean isEnd) {
        this.isEnd = isEnd;
        this.map = new HashMap<>();
    }

    public Trie() {
        this.isEnd = false;
        this.map = new HashMap<>();
    }

    public void insert(String word) {
        Trie currentTrie = this;
        for (int i = 0; i < word.length(); i++) {
            if (currentTrie.map.get(word.charAt(i)) == null) {
                currentTrie.map.put(word.charAt(i), new Trie());
            }
            currentTrie = currentTrie.map.get(word.charAt(i));
            if (i == word.length() - 1) {
                currentTrie.isEnd = true;
            }
        }
    }

    public boolean search(String word) {
        Trie currentTrie = this;
        for (int i = 0; i < word.length(); i++) {
            if (currentTrie.map.get(word.charAt(i)) == null) {
                return false;
            }
            currentTrie = currentTrie.map.get(word.charAt(i));
            if (i == word.length() - 1&& currentTrie.isEnd) {
                    return true;
            }
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        Trie currentTrie = this;
        for (int i = 0; i < prefix.length(); i++) {
            if (currentTrie.map.get(prefix.charAt(i)) == null) {
                return false;
            }
            currentTrie = currentTrie.map.get(prefix.charAt(i));
            if (i == prefix.length() - 1) {
                if (currentTrie.map.size()>0|| currentTrie.isEnd){
                    return true;
                }else {
                    return false;
                }
            }
        }
        return false;
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
