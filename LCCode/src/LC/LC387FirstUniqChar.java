package LC;

import java.util.*;

/*
387. 字符串中的第一个唯一字符
给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。



示例 1：

输入: s = "leetcode"
输出: 0
示例 2:

输入: s = "loveleetcode"
输出: 2
示例 3:

输入: s = "aabb"
输出: -1


提示:

1 <= s.length <= 105
s 只包含小写字母
 */
public class LC387FirstUniqChar {

    public static void main(String[] args) {
        LC387FirstUniqChar l = new LC387FirstUniqChar();
        l.firstUniqChar("zhwzh");
    }



    public int firstUniqChar(String s) {

        return -1;
    }



    //建立26个字母表
    public int firstUniqCharLCA(String s) {
        int[] arr = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i)-'a']++ ;
        }
        for (int i = 0; i < n; i++) {
            if (arr[s.charAt(i)-'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqCharLC1(String s) {
        Map<Character, Integer> position = new HashMap<Character, Integer>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (position.containsKey(ch)) {
                position.put(ch, -1);
            } else {
                position.put(ch, i);
            }
        }
        int first = n;
        for (Map.Entry<Character, Integer> entry : position.entrySet()) {
            int pos = entry.getValue();
            if (pos != -1 && pos < first) {
                first = pos;
            }
        }
        if (first == n) {
            first = -1;
        }
        return first;
    }

    public int firstUniqCharLC2(String s) {
        Map<Character, Integer> position = new HashMap<Character, Integer>();
        Queue<Pair> queue = new LinkedList<Pair>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (!position.containsKey(ch)) {
                position.put(ch, i);
                queue.offer(new Pair(ch, i));
            } else {
                position.put(ch, -1);
                while (!queue.isEmpty() && position.get(queue.peek().ch) == -1) {
                    queue.poll();
                }
            }
        }
        return queue.isEmpty() ? -1 : queue.poll().pos;
    }
    class Pair {
        char ch;
        int pos;

        Pair(char ch, int pos) {
            this.ch = ch;
            this.pos = pos;
        }
    }


    /*
    执行用时：
62 ms
, 在所有 Java 提交中击败了
5.06%
的用户
内存消耗：
41.7 MB
, 在所有 Java 提交中击败了
55.50%
的用户
通过测试用例：
105 / 105
炫耀一下:
     */
    public int firstUniqChar1(String s) {
        Set<Character> contains = new HashSet();
        int res = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!contains.contains(c)) {
                contains.add(c);
                res = s.indexOf(c);
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == c) {
                        res = -1;
                    }
                }
            }
            if (res!=-1){
                return res;
            }
        }
        return -1;
    }
}
