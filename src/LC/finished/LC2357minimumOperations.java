package LC.finished;


//输入：nums = [1,5,0,3,5]
//输出：3
// x = 1 ，之后 nums = [0,4,0,2,4] 。
// x = 2 ，之后 nums = [0,2,0,0,2] 。
// x = 2 ，之后 nums = [0,0,0,0,0] 。

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
//1,2,3,5

//0,1,2,4
//0,0,1,3
//0,0,0,2
//0,0,0,0
public class LC2357minimumOperations {
    public static void main(String[] args) {
        LC2357minimumOperations l = new LC2357minimumOperations();
        int res = l.minimumOperations(new int[]{0, 0, 1, 1, 2, 3, 5});
        System.out.println(res);
    }

    /*
	执行耗时:0 ms,击败了100.00% 的Java用户
	内存消耗:39.1 MB,击败了67.44% 的Java用户
     */
    public int minimumOperations1(int[] nums) {
        Set<Integer> set = new HashSet();
        for (int n :
                nums) {
            set.add(n);
        }
        return set.contains(0) ? set.size() - 1 : set.size();
    }


    /*
    执行耗时:1 ms,击败了57.44% 的Java用户
	内存消耗:39.2 MB,击败了44.87% 的Java用户
     */
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int record = 0;
        int count = 0;
        for (int n :
                nums) {
            if (n != record) {
                record = n;
                count++;
            }
//            可要可不要
//            if (record==nums[nums.length-1]) return count;
        }
        return count;
    }
}
