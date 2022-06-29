package LC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
383. 赎金信
给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。

如果可以，返回 true ；否则返回 false 。

magazine 中的每个字符只能在 ransomNote 中使用一次。



示例 1：

输入：ransomNote = "a", magazine = "b"
输出：false
示例 2：

输入：ransomNote = "aa", magazine = "ab"
输出：false
示例 3：

输入：ransomNote = "aa", magazine = "aab"
输出：true


提示：

1 <= ransomNote.length, magazine.length <= 105
ransomNote 和 magazine 由小写英文字母组成
 */
public class LC383CanConstruct {
    public static void main(String[] args) {
        LC383CanConstruct l = new LC383CanConstruct();
        l.canConstruct2("hotwindandhw", "honmjlkjoklj");
    }

    /*
    执行用时：
4 ms
, 在所有 Java 提交中击败了
30.86%
的用户
内存消耗：
41.2 MB
, 在所有 Java 提交中击败了
85.33%
的用户
通过测试用例：
126 / 126
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        //加了这段代码后
        /*
        执行用时：
4 ms
, 在所有 Java 提交中击败了
30.86%
的用户
内存消耗：
41.4 MB
, 在所有 Java 提交中击败了
75.09%
的用户
通过测试用例：
126 / 126
         */
        if (ransomNote.length() > magazine.length()) return false;
        Map<Character, Integer> rMap = new HashMap();
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (rMap.containsKey(c)) {
                rMap.replace(c, rMap.get(c) + 1);
            } else {
                rMap.put(c, 1);
            }
        }
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            if (rMap.containsKey(c)) {
                rMap.replace(c, rMap.get(c) - 1);
                if (rMap.get(c) == 0) {
                    rMap.remove(c);
                }
            }
        }
        return rMap.size() == 0 ? true : false;
    }

    //too slow
    public boolean canConstruct2(String ransomNote, String magazine) {
        char[] chars = ransomNote.toCharArray();
        List<Character> list = new ArrayList();
        for (char c :
                chars) {
            list.add(c);
        }
        for (int i = 0; i < magazine.length(); i++) {
            if (list.contains(magazine.charAt(i))){
                list.remove((Character) magazine.charAt(i));
            }
            if (list.size()==0){
                return true;
            }
        }


        return false;
    }
}
