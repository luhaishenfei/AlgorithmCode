package LC.undo;

public class LC33rotatedSortedArr {

    public static void main(String[] args) {
        LC33rotatedSortedArr l = new LC33rotatedSortedArr();
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(l.search(arr, 2));
    }

    //输入：nums = [4,5,6,7,0,1,2], target = 0
    //输出：4
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        if (nums[start] < nums[mid]) {
            //front sorted
            if (nums[start] <= target && target <= nums[mid]) {
                return binarySearch(nums, target, start, mid);
            } else {
                return search(nums, target, mid + 1, end);
            }
        } else {
            //bak sorted
            if (nums[mid] <= target && target <= nums[end]) {
                return binarySearch(nums, target, mid, end);
            } else {
                return search(nums, target, start, mid-1);
            }
        }

    }

    private int binarySearch(int[] arr, int target, int start, int end) {
        for (int i = start; i < end; i++) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                return binarySearch(arr, target, mid + 1, end);
            } else {
                return binarySearch(arr, target, start, end - 1);
            }
        }
        return -1;
    }
}
