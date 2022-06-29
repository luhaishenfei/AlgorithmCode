package LC;

public class LC704BinarySearch {
    public static void main(String[] args) {
        LC704BinarySearch l = new LC704BinarySearch();
        int index=l.search(new int[]{1,2,4,6,8,9},8);
        System.out.println(index);
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (right-left ) / 2+left;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }

    public int LCsearch(int[] nums, int target) {
        int low = 0,
                high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


}
