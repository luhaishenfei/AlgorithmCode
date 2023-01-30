package LC.finished;

import java.util.*;

/*
//找出数组中重复的数字。
//
// 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
//请找出数组中任意一个重复的数字。
//
// 示例 1：
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3
//
*/
public class LCOffer03findRepeatNumber {
    public static void main(String[] args) {
        LCOffer03findRepeatNumber l =new LCOffer03findRepeatNumber();
        l.findRepeatNumberLC(new int[]{5,1,3,2,3,2});
    }


    //? fine,but don't know how
    public int findRepeatNumberLC2(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int k = nums[i];
            if(k < 0) k += n;
            if(nums[k] < 0) return k;
            nums[k] -= n;
        }
        return -1;
    }

    //原地交换 利用数字都在 0～n-1 的范围内
    /*
    > 2022/11/09 16:15:27
    解答成功:
	执行耗时:0 ms,击败了100.00% 的Java用户
	内存消耗:48.6 MB,击败了84.42% 的Java用户
     */
    public int findRepeatNumberLC(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) return nums[i];
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }


    /*
    解答成功:
	执行耗时:3 ms,击败了63.22% 的Java用户
	内存消耗:48.6 MB,击败了88.70% 的Java用户
     */
    public int findRepeatNumber2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return nums[i];
        }
        return -1;
    }


    /*
        解答成功:
        执行耗时:7 ms,击败了35.89% 的Java用户
        内存消耗:49.9 MB,击败了41.39% 的Java用户
    */
    public int findRepeatNumber1(int[] nums) {
        Set<Integer> set = new HashSet();
        for (int n :
                nums) {
            if (set.contains(n)) {
                return n;
            } else {
                set.add(n);
            }
        }
        return -1;
    }

}
