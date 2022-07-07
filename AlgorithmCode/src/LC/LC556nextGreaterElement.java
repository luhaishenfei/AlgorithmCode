package LC;

import java.util.*;

/*
556. 下一个更大元素 III
给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。
注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。

示例 1：
输入：n = 12
输出：21
示例 2：
输入：n = 21
输出：-1
提示：
1 <= n <= 2^31 - 1
 */
public class LC556nextGreaterElement {
    public static void main(String[] args) {
        LC556nextGreaterElement l = new LC556nextGreaterElement();
        System.out.println(l.nextGreaterElement(1200000));
    }

/*
执行用时：
12 ms
, 在所有 Java 提交中击败了
5.72%
的用户
内存消耗：
39.5 MB
, 在所有 Java 提交中击败了
5.02%
的用户
通过测试用例：
39 / 39
 */
    //强撸出来了
    public int nextGreaterElement(int n) {
        LinkedList<Integer> queue = new LinkedList();
        int lastNum = -1;
        while (n != 0) {
            int tmp = n % 10;
            n /= 10;
            if (tmp >= lastNum) {
                queue.offer(tmp);
                lastNum = tmp;
            } else {
                long res = n;
                String bak="";
                while (!queue.isEmpty()) {
                    int i=queue.poll();
                    if (tmp>=i){
                        bak=bak+i;
                    }else {
                        res=res*10+i;
                        bak=bak+tmp;
                        tmp=10;
                    }
                }
                res= Long.parseLong(res+bak);
               if (res <= 2147483647) {
                    return (int) res;
                }
                return -1;
            }
        }
        return -1;
    }

    /*
    执行用时：
0 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗：
38.5 MB
, 在所有 Java 提交中击败了
29.73%
的用户
通过测试用例：
39 / 39
     */
    public int nextGreaterElementLC1(int n) {
        char[] nums = Integer.toString(n).toCharArray();
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i < 0) {
            return -1;
        }

        int j = nums.length - 1;
        while (j >= 0 && nums[i] >= nums[j]) {
            j--;
        }
        swap(nums, i, j);
        reverse(nums, i + 1);
        long ans = Long.parseLong(new String(nums));
        return ans > Integer.MAX_VALUE ? -1 : (int) ans;
    }

    public void reverse(char[] nums, int begin) {
        int i = begin, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public int nextGreaterElementLC2(int n) {
        int x = n, cnt = 1;
        for (; x >= 10 && x / 10 % 10 >= x % 10; x /= 10) {
            ++cnt;
        }
        x /= 10;
        if (x == 0) {
            return -1;
        }

        int targetDigit = x % 10;
        int x2 = n, cnt2 = 0;
        for (; x2 % 10 <= targetDigit; x2 /= 10) {
            ++cnt2;
        }
        x += x2 % 10 - targetDigit; // 把 x2 % 10 换到 targetDigit 上

        for (int i = 0; i < cnt; ++i, n /= 10) { // 反转 n 末尾的 cnt 个数字拼到 x 后
            int d = i != cnt2 ? n % 10 : targetDigit;
            if (x > Integer.MAX_VALUE / 10 || x == Integer.MAX_VALUE / 10 && d > 7) {
                return -1;
            }
            x = x * 10 + d;
        }
        return x;
    }


}
