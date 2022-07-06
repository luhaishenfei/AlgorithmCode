package LC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
1200. 最小绝对差
给你个整数数组 arr，其中每个元素都 不相同。

请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。

示例 1：
输入：arr = [4,2,1,3]
输出：[[1,2],[2,3],[3,4]]
示例 2：

输入：arr = [1,3,6,10,15]
输出：[[1,3]]
示例 3：

输入：arr = [3,8,-10,23,19,-4,-14,27]
输出：[[-14,-10],[19,23],[23,27]]


提示：

2 <= arr.length <= 10^5
-10^6 <= arr[i] <= 10^6
通过次数50,090提交次数68,841
 */
public class LC1200minimumAbsDifference {
    /*
    输入：arr = [3,8,-10,23,19,-4,-14,27]
    输出：[[-14,-10],[19,23],[23,27]]
     */

    /*
    执行用时：
18 ms
, 在所有 Java 提交中击败了
34.00%
的用户
内存消耗：
52.3 MB
, 在所有 Java 提交中击败了
23.36%
的用户
     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int miniAbs = Integer.MAX_VALUE;
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
                int abs = Math.abs(arr[i] - arr[i+1]);
                if (miniAbs > abs) {
                    res.clear();
                    miniAbs = abs;
                    List tmpList = new ArrayList();
                    tmpList.add(Math.min(arr[i], arr[i+1]));
                    tmpList.add(Math.max(arr[i], arr[i+1]));
                    res.add(tmpList);
                }else if (miniAbs==abs){
                    List tmpList = new ArrayList();
                    tmpList.add(Math.min(arr[i], arr[i+1]));
                    tmpList.add(Math.max(arr[i], arr[i+1]));
                    res.add(tmpList);
                }
        }
        return res;
    }
}
