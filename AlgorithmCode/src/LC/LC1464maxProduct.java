package LC;

public class LC1464maxProduct {
    //ans1:
    public int maxProduct(int[] nums) {
        int maxValue1=-1;
        int maxValue2=-1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>maxValue1){
                maxValue2=maxValue1;
                maxValue1=nums[i];
            }else if (nums[i]>maxValue2){
                maxValue2=nums[i];
            }
        }
        return (maxValue1-1)*(maxValue2-1);
    }
    //ans2: too slow
//    public int maxProduct(int[] nums) {
//        Arrays.sort(nums);
//        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
//    }



}
