package LC._undo;

/*

3. 无重复字符的最长子串
给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。



示例 1:

输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。


提示：

0 <= s.length <= 5 * 104
s 由英文字母、数字、符号和空格组成
通过次数1,860,956提交次数4,784,678
 */
public class LC3lengthOfLongestSubstring {
    public static void main(String[] args) {
        LC3lengthOfLongestSubstring l = new LC3lengthOfLongestSubstring();
        String str = "abcdefgcab";
        System.out.println((int) 'a');
        System.out.println((int) 'z');
        l.lengthOfLongestSubstringLCUser(str);
    }


    //cabsjkaljs
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                for (int k = i + 1; k < j; k++) {
                    if (s.charAt(k) == s.charAt(j)) {
                        if (k - i > longest) {
                            longest = k - i;
                        }
                        break;
                    }
                }

            }
        }


        return 0;
    }


    public int lengthOfLongestSubstringLCUser(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for (int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }
}
