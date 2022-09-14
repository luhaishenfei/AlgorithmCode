package LC.finished;

import java.util.Random;

public class LC398RandomIndex {

//    public Solution(int[] nums) {
//
//    }
    int[] nums;

    public int pick(int target) {
        Random r= new Random();
        int index=0;
        while (nums[index]==target){
            index=r.nextInt(nums.length);
        }
        return index;
    }
}
