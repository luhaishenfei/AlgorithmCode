package LC.undo;

import java.util.ArrayList;
import java.util.List;

public class LC1470shuffle {

    public static void main(String[] args) {
       List list= new ArrayList();
        for (int i = 0; i < 95; i++) {
            list.add(i);
        }
        for (int i = 0; i < 10; i++) {
            List s = list.subList(i*10,i*10+10);
            s.size();
        }
    }

    //normal solution
    public int[] shuffle1(int[] nums, int n) {
        int len = nums.length;
        int[] tmp = nums.clone();
        for (int i =0; i <len ; i++) {
            if (i%2==0){
                nums[i]=tmp[i/2];
            }   else {
                nums[i]=tmp[i/2+len/2];
            }
        }
        return nums;
    }


    public int[] shuffle(int[] nums, int n) {
        int len = nums.length;
        int[] tmp = new int[len];
        tmp=nums;
        nums[0]=1;

        for (int i =0; i <len/2 ; i++) {
            tmp[i]=nums[i+len/2];
        }
        for (int i = len-1; i >=0; i-=2) {

        }

        return null;
    }
}
