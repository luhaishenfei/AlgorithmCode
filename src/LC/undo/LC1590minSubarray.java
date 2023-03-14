package LC.undo;

import java.util.Arrays;

public class LC1590minSubarray {
    public static void main(String[] args) {
        LC1590minSubarray l = new LC1590minSubarray();
        int[] nums = {6, 3, 5, 2};
        int p = 9;
        l.minSubarray(nums, p);
    }


    public int minSubarray(int[] nums, int p) {
//        Arrays.s



        return -1;
    }


        // 输入：nums = [6,3,5,2], p = 9
//输出：2
    public int minSubarray1(int[] nums, int p) {

        int sum = 0;
        for (int i :
                nums) {
            sum += i;
        }
        Arrays.sort(nums);

        int quotient = sum / p;
        int Remainder = sum % p;
        while (quotient > 0) {


        }

        return -1;
    }

    private int findSolution(int[] nums,int aim, int limit) {




        return -1;
    }
}
