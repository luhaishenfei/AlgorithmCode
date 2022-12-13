package LC.undo;

public class LC33rotatedSortedArr {

    //输入：nums = [4,5,6,7,0,1,2], target = 0
    //输出：4
    public int search(int[] nums, int target) {

        int res=search(nums, target, 0, nums.length / 2);
        return res==-1? search(nums, target, nums.length / 2, nums.length - 1):res;
    }

    private int search(int[] nums, int target, int start, int end) {
        if (nums[start]<nums[end]){
//            biniarySearch(nums);
        }
        return -1;
    }

}
