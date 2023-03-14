package LC.undo;

public class LC915partitionDisjoint {
    // 2 <= nums.length <= 10⁵
    // 0 <= nums[i] <= 10⁶

    public static void main(String[] args) {
        LC915partitionDisjoint l = new LC915partitionDisjoint();
        System.out.println(l.partitionDisjointLCUser(new int[]{4, 0, 3, 5, 7, 1, 8, 6}));
    }


    //    nums = [5,0,3,8,6]
    //            3
    //    left = [5,0,3]，right = [8,6]

    // X
    public int partitionDisjoint(int[] nums) {

        int leftMaxNum = nums[0];
        int rightMinNum = nums[nums.length - 1];


        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            if (nums[i] >= nums[j])


                if (leftMaxNum < nums[i]) {
                    leftMaxNum = nums[i];
                }
            i++;
            if (rightMinNum > nums[j]) {
                rightMinNum = nums[j];
            }
            j++;
        }


        return 0;
    }






    /*
    执行耗时:3 ms,击败了87.28%
    内存消耗:50.3 MB,击败了89.74%
     */
    public int partitionDisjointLCUser(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int leftMax = nums[0];
        int max = nums[0];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] < leftMax) {
                leftMax = max;
                index = i;
            }
        }

        return index + 1;
    }


}
