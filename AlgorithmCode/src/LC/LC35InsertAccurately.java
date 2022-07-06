package LC;

public class LC35InsertAccurately {

    public static void main(String[] args) {
        LC35InsertAccurately l = new LC35InsertAccurately();
        System.out.println(l.searchInsert(new int[]{1, 3}, 4));
    }

    public int searchInsert(int[] nums, int target) {
        int low =0;
        int high=nums.length-1;
        while (low<high){
            int mid=(high-low)/2+low;
            if (nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                low=mid+1;
            }else {
                high=mid-1;
            }
        }
        if (target<=nums[low]){
            return low;
        }else {
            return high+1;
        }
    }

    /*
     public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

作者：guanpengchn
链接：https://leetcode-cn.com/problems/search-insert-position/solution/hua-jie-suan-fa-35-sou-suo-cha-ru-wei-zhi-by-guanp/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
