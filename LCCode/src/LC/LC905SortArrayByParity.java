package LC;

public class LC905SortArrayByParity {
    public static void main(String[] args) {
        LC905SortArrayByParity l = new LC905SortArrayByParity();
        int[] nums={1,2,3,4,5,6};
       nums= l.sortArrayByParity(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+",");

        }
    }

    public int[] sortArrayByParity(int[] nums) {
        for (int i = 0, j = nums.length - 1; i < j; i++) {
            //奇数
            if ((nums[i] & 1) == 1) {
                while ((nums[j]&1)==1&&i<j){
                    j--;
                }
                //偶数
                 if ((nums[j]&1)==0){
//                     int tmp=nums[j];
//                     nums[j]=nums[i];
//                     nums[i]=tmp;
                     //异或代替tmp交换
                     nums[i]^=nums[j];
                     nums[j]^=nums[i];
                     nums[i]^=nums[j];
                     j--;
                 }
            }
        }

        return nums;
    }
}
