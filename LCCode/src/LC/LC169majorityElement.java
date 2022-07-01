package LC;

import java.util.*;

/*
169. 多数元素
给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。


示例 1：

输入：nums = [3,2,3]
输出：3
示例 2：

输入：nums = [2,2,1,1,1,2,2]
输出：2


提示：
n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109


进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 */
public class LC169majorityElement {

    /*
    执行用时：
2 ms
, 在所有 Java 提交中击败了
59.56%
的用户
内存消耗：
44.7 MB
, 在所有 Java 提交中击败了
70.26%
的用户
通过测试用例：
43 / 43
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }





    /*
    执行用时：
12 ms
, 在所有 Java 提交中击败了
23.49%
的用户
内存消耗：
46.5 MB
, 在所有 Java 提交中击败了
15.78%
的用户
通过测试用例：
43 / 43
     */
    public int majorityElement1(int[] nums) {
        if (nums.length==1) return nums[0];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i :
                nums) {
            if (!map.containsKey(i)) {
                map.put(i,1);
            }else {
                int value=map.get(i);
                if (value==nums.length/2) return i;
                map.put(i,value+1);
            }
        }
        return 0;
    }



}
