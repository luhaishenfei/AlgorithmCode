package LC._undo;

import java.util.HashMap;
import java.util.Map;

public class LC1224maxEqualFreq {

    //[2,2,1,1,5,3,3,5]  X
    public int maxEqualFreq(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                //不包含，则添加
                map.put(nums[i], 1);
            } else {
                map.replace(nums[i], map.get(nums[i]) + 1);
            }
        }
        int normalNum = -1;
        int specialNum = -1;
        int aim=-1;
        for (Integer i :
                map.keySet()) {
            int v = map.get(i);
            if (normalNum == -1) {
                normalNum = v;
            }
            if (normalNum!=v){
                if (specialNum==-1){
                    specialNum=v;
                }else {
                    if (specialNum==v){
                        specialNum=normalNum;
                        normalNum=v;
                        aim=i;
                    }
                    break;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==aim){
                return i+1;
            }
        }
        return -1;
    }

}
