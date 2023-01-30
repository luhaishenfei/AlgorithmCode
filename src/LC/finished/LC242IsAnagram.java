package LC.finished;

import java.util.Arrays;
import java.util.Random;

/*
242. 有效的字母异位词
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。



示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
 */
public class LC242IsAnagram {
    public static void main(String[] args) {

        LC242IsAnagram l = new LC242IsAnagram();
        System.out.println(l.isAnagram("aacc", "ccac"));
        boolean b = new Random().nextBoolean();


    }


    //位运算  "aa","bb"时，错误
    public boolean isAnagram2(String s, String t) {
        int res = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            res=res^s.charAt(i);
        }
        for (int j = 0; j < t.length(); j++) {
            res=res^t.charAt(j);
        }
        return res%0==0;
    }




    /*执行用时：
3 ms
, 在所有 Java 提交中击败了
58.61%
的用户
内存消耗：
41.4 MB
, 在所有 Java 提交中击败了
63.38%
的用户
通过测试用例：
36 / 36*/
    public boolean isAnagramLC(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        for (int i=0; i<str1.length; i++) {
            if (str1[i] != str2[i])
                return false;
        }
        return true;
    }

    /*
执行用时：
2381 ms
, 在所有 Java 提交中击败了
5.13%
的用户
内存消耗：
41.1 MB
, 在所有 Java 提交中击败了
92.73%
的用户
通过测试用例：
36 / 36
 */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        for (int i = 0; i < chart.length; i++) {
            boolean isOk = false;
            for (int j = 0; j < chars.length; j++) {
                if (chart[i] == chars[j]) {
                    chars[j]=1;
                    isOk = true;
                    break;
                }
            }
            if (!isOk) {
                return false;
            }
        }
        return true;
    }




    //超出时间限制
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] chars = s.toCharArray();
        for (int i = 0; i < t.length(); i++) {
            boolean isOk = false;
            for (int j = 0; j < chars.length; j++) {
                if (t.charAt(i) == chars[j]) {
                    chars[j]=1;
                    isOk = true;
                    break;
                }
            }
            if (!isOk) {
                return false;
            }
        }
        return true;
    }
}
