package LC.undo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LC904totalFruit {
    //输入：fruits = [3,3,3,1,2,1,1,2,3,3,4]
    //输出：5
    //解释：[1,2,1,1,2]


    //[3,3,3,1,2,1,1,2,2,3,3,3,4]
    public int totalFruit(int[] fruits) {
        Set<Integer> typeSet = new HashSet();
        if (fruits.length <= 2) {
            return fruits.length;
        }
        //最近的类型
        int currentType = -1;
        //最近类型的数量
        int currentTypeNum = -1;
        //本次的数量
        int tmpNum = 0;
        int longest = 0;
        ArrayList l = new ArrayList();
        for (int i = 0; i < fruits.length; i++) {
            int t = fruits[i];
            if (!typeSet.contains(t)) {
                if (typeSet.size() < 2) {
                    typeSet.add(t);
                    currentType = t;
                    currentTypeNum = 1;
                    tmpNum++;
                } else {
                    //中断  种类大于2，且不包含新类型t
                    if (tmpNum > longest) {
                        longest = tmpNum;
                    }
                    //上一个的数量转移，并加1重新计数
                    tmpNum = currentTypeNum + 1;
                    typeSet.retainAll()

                    currentType = fruits[i];
                    currentTypeNum = 1;
                    type1 = fruits[i - 1];
                    type2 = currentType;

                }
            }


        }


        return -1;
    }
}
