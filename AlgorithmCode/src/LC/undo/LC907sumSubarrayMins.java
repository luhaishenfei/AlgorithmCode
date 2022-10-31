package LC.undo;
/*
    //输入：arr = [3,1,2,4]
    //输出：17
    [3]，        [1]，        [2]，        [4]，       5
    [3,1]，      [1,2]，      [2,4]，                  4,5
    [3,1,2]，    [1,2,4]，                             2,4,5
    [3,1,2,4]。                                       1,2,4,5
                                                      3,1,2,4,5
    //最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。

 */

public class LC907sumSubarrayMins {
    /*
// 1 <= arr.length <= 3 * 10⁴
// 1 <= arr[i] <= 3 * 10⁴
     */
    public int sumSubarrayMins(int[] arr) {
        int[] minArr=new int[arr.length];
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            for (int z = 0; z <minArr.length ; z++) {
                if (minArr[z]==0){
                    minArr[z]=arr[i];
                }else {
                    if (minArr[z] > arr[i]) {
                        minArr[z] = arr[i];
                    }
                }
                if (i%z==0){
                    sum+=minArr[z];
                }
            }


            sum+=arr[i]*(arr.length-i);
        }
        return sum;
    }

}
