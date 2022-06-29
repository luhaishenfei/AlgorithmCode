package LC;

import java.util.ArrayDeque;
import java.util.Queue;

public class LC189Rotate {
    public static void main(String[] args) {
        LC189Rotate l = new LC189Rotate();
        int[] nums = new int[]{-1, -100, 3, 99};
        l.rotate2(nums, 2);
        for (int i :
                nums) {
            System.out.printf(i + ",");
        }
    }

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int lastIndex = len - 1;
        int aimIndex = (lastIndex + k) % len;
        int count = 0;
        while (aimIndex != lastIndex) {
            int tmp = nums[aimIndex];
            nums[aimIndex] = nums[lastIndex];
            nums[lastIndex] = tmp;
            aimIndex = (aimIndex + k) % len;
            count++;
        }
    }

    public void rotate2(int[] nums, int k) {
        /*
        执行用时：
6 ms
, 在所有 Java 提交中击败了
10.92%
的用户
内存消耗：
55.8 MB
, 在所有 Java 提交中击败了
85.79%
的用户
通过测试用例：
38 / 38
         */
        Queue<Integer> queue =new ArrayDeque();
        for (int i :
                nums) {
            queue.add(i);
        }
        for (int i = 0; i < nums.length; i++) {
                nums[(i + k)%nums.length] = queue.poll();
        }
    }
}
