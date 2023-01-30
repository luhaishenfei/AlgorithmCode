package LC.finished;

public class LC1822arraySign {

    public int arraySign(int[] nums) {
        int flag=1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<0){
                flag=-flag;
            } else if (nums[i]==0) {
                return 0;
            }
        }
        return flag;
    }
}
