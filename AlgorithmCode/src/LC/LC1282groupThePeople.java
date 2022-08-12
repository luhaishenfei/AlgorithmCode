package LC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
有n个人被分成数量未知的组。每个人都被标记为一个从 0 到 n - 1 的唯一ID 。

给定一个整数数组 groupSizes ，其中groupSizes[i]是第 i 个人所在的组的大小。例如，如果groupSizes[1] = 3，则第 1 个人必须位于大小为 3 的组中。

返回一个组列表，使每个人 i 都在一个大小为groupSizes[i]的组中。

每个人应该 恰好只 出现在一个组中，并且每个人必须在一个组中。如果有多个答案，返回其中 任何 一个。可以 保证 给定输入 至少有一个 有效的解。

 */
public class LC1282groupThePeople {
    /*
    groupSizes = [3,3,3,3,3,1,3]
    输出：[[5],[0,1,2],[3,4,6]]
     */


    /*
    执行用时：
5 ms
, 在所有 Java 提交中击败了
83.84%
的用户
内存消耗：
41.9 MB
, 在所有 Java 提交中击败了
82.01%
的用户
     */
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List res = new ArrayList();
        Map<Integer, List> map = new HashMap();


        for (int i = 0; i < groupSizes.length; i++) {
            int key = groupSizes[i];
            if (!map.containsKey(key)) {
                //map不包含大小为g[i]的list
                List<Integer> tmpList=new ArrayList();
                tmpList.add(i);
                if (key == 1) {
                    res.add(tmpList);
                }else {
                    map.put(key, tmpList);
                }
            }else {
                //包含
                List tmpList=map.get(key);
                tmpList.add(i);
                if (tmpList.size()==key){
                    res.add(tmpList);
                    map.remove(key);
                }
            }
        }

        return res;
    }
}
