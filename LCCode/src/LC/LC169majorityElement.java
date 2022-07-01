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

    //Boyer-Moore 算法
    public int majorityElementLCBM(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

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

    //
    private int randRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private int countOccurences(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    /*
    方法三：随机化
思路

因为超过 \lfloor \dfrac{n}{2} \rfloor⌊
2
n
​
 ⌋ 的数组下标被众数占据了，这样我们随机挑选一个下标对应的元素并验证，有很大的概率能找到众数。

算法

由于一个给定的下标对应的数字很有可能是众数，我们随机挑选一个下标，检查它是否是众数，如果是就返回，否则继续随机挑选

     */
    //随机化
    public int majorityElementLC(int[] nums) {
        Random rand = new Random();

        int majorityCount = nums.length / 2;

        while (true) {
            int candidate = nums[randRange(rand, 0, nums.length)];
            if (countOccurences(nums, candidate) > majorityCount) {
                return candidate;
            }
        }
    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    //
    private int majorityElementRec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi - lo) / 2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    //分治
    public int majorityElementLC2(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
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
