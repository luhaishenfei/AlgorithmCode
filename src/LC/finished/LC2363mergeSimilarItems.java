//给你两个二维整数数组 items1 和 items2 ，表示两个物品集合。每个数组 items 有以下特质：
//
//
// items[i] = [valuei, weighti] 其中 valuei 表示第 i 件物品的 价值 ，weighti 表示第 i 件物品的 重量 。
//
// items 中每件物品的价值都是 唯一的 。
//
//
// 请你返回一个二维数组 ret，其中 ret[i] = [valuei, weighti]， weighti 是所有价值为 valuei 物品的 重量之和
//。
//
// 注意：ret 应该按价值 升序 排序后返回。
//
//
//
// 示例 1：
//
//
//输入：items1 = [[1,1],[4,5],[3,8]], items2 = [[3,1],[1,5]]
//输出：[[1,6],[3,9],[4,5]]
//解释：
//value = 1 的物品在 items1 中 weight = 1 ，在 items2 中 weight = 5 ，总重量为 1 + 5 = 6 。
//value = 3 的物品再 items1 中 weight = 8 ，在 items2 中 weight = 1 ，总重量为 8 + 1 = 9 。
//value = 4 的物品在 items1 中 weight = 5 ，总重量为 5 。
//所以，我们返回 [[1,6],[3,9],[4,5]] 。
//
//
// 示例 2：
//
//
//输入：items1 = [[1,1],[3,2],[2,3]], items2 = [[2,1],[3,2],[1,3]]
//输出：[[1,4],[2,4],[3,4]]
//解释：
//value = 1 的物品在 items1 中 weight = 1 ，在 items2 中 weight = 3 ，总重量为 1 + 3 = 4 。
//value = 2 的物品在 items1 中 weight = 3 ，在 items2 中 weight = 1 ，总重量为 3 + 1 = 4 。
//value = 3 的物品在 items1 中 weight = 2 ，在 items2 中 weight = 2 ，总重量为 2 + 2 = 4 。
//所以，我们返回 [[1,4],[2,4],[3,4]] 。
//
// 示例 3：
//
//
//输入：items1 = [[1,3],[2,2]], items2 = [[7,1],[2,2],[1,4]]
//输出：[[1,7],[2,4],[7,1]]
//解释：
//value = 1 的物品在 items1 中 weight = 3 ，在 items2 中 weight = 4 ，总重量为 3 + 4 = 7 。
//value = 2 的物品在 items1 中 weight = 2 ，在 items2 中 weight = 2 ，总重量为 2 + 2 = 4 。
//value = 7 的物品在 items2 中 weight = 1 ，总重量为 1 。
//所以，我们返回 [[1,7],[2,4],[7,1]] 。
//
//
//
//
// 提示：
//
//
// 1 <= items1.length, items2.length <= 1000
// items1[i].length == items2[i].length == 2
// 1 <= valuei, weighti <= 1000
// items1 中每个 valuei 都是 唯一的 。
// items2 中每个 valuei 都是 唯一的 。
//
//
// Related Topics 数组 哈希表 有序集合 排序 👍 26 👎 0


package LC.finished;

import java.util.*;

public class LC2363mergeSimilarItems {
    public static void main(String[] args) {
        LC2363mergeSimilarItems l = new LC2363mergeSimilarItems();
        int[][] items1={{15,5},{2,6},{5,3},{14,8},{12,4},{19,6},{25,4},{13,4},{9,1}};
        int[][] items2={{15,9},{2,4},{5,2},{14,4},{12,3},{19,10},{25,7},{13,6},{9,9}};
        l.mergeSimilarItems2(items1,items2);

    }

    /*
        //v1.0轻松秒杀
        执行耗时:8 ms,击败了61.75% 的Java用户
        内存消耗:41.8 MB,击败了97.54% 的Java用户
     */
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> recordMap = new HashMap<>();
        for (int i = 0; i < items1.length; i++) {
            recordMap.put(items1[i][0], items1[i][1]);
        }
        for (int i = 0; i < items2.length; i++) {
            int key = items2[i][0];
            if (!recordMap.containsKey(key)) {
                recordMap.put(key, items2[i][1]);
            } else {
                recordMap.put(key, recordMap.get(key) + items2[i][1]);
            }
        }
        for (int key :
                recordMap.keySet()) {
            List list = new ArrayList();
            list.add(key);
            list.add(recordMap.get(key));
            res.add(list);
        }
        res.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });
        return res;
    }


    //相同思路的链接：https://leetcode.cn/problems/merge-similar-items/solutions/2137998/javapythonshuang-zhi-zhen-he-bing-you-xu-234c/
    public List<List<Integer>> mergeSimilarItems2(int[][] items1, int[][] items2) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(items1, (int[] a, int[] b) -> {
            return a[0] - b[0];
        });
        Arrays.sort(items2, (int[] a, int[] b) -> {
            return a[0] - b[0];
        });


        return res;
    }

    /*
    	执行耗时:8 ms,击败了61.75% 的Java用户
    	内存消耗:42.2 MB,击败了63.51% 的Java用户
        ps:感觉速度一般啊
     */
    public List<List<Integer>> mergeSimilarItemsLCUser(int[][] items1, int[][] items2) {
        List<List<Integer>> res = new ArrayList<>();    // 结果列表
        // 两个数组分别排序
        Arrays.sort(items1, (int[] a, int[] b) -> {
            return a[0] - b[0];
        });
        Arrays.sort(items2, (int[] a, int[] b) -> {
            return a[0] - b[0];
        });
        int p1 = 0;     // 遍历item1的指针
        int p2 = 0;     // 遍历item2的指针
        int n1 = items1.length;     // item1长度
        int n2 = items2.length;     // item2长度
        List<Integer> ans;
        while (p1 < n1 && p2 < n2) {
            if (items1[p1][0] == items2[p2][0]) {
                // 两个item的价值一样
                ans = new ArrayList<>();
                ans.add(items1[p1][0]);
                ans.add(items1[p1][1] + items2[p2][1]);
                res.add(ans);
                p1++;
                p2++;
            } else if (items1[p1][0] < items2[p2][0]) {
                // item1[p1]的价值小，直接加入，p1后移搜索更大价值
                ans = new ArrayList<>();
                ans.add(items1[p1][0]);
                ans.add(items1[p1][1]);
                res.add(ans);
                p1++;
            } else {
                // item2[p2]的价值小，直接加入，p2后移搜索更大价值
                ans = new ArrayList<>();
                ans.add(items2[p2][0]);
                ans.add(items2[p2][1]);
                res.add(ans);
                p2++;
            }
        }
        // 如果p1未遍历完，将item1剩下的item加入结果集
        while (p1 < n1) {
            ans = new ArrayList<>();
            ans.add(items1[p1][0]);
            ans.add(items1[p1][1]);
            res.add(ans);
            p1++;
        }
        // 如果p2未遍历完，将item2剩下的item加入结果集
        while (p2 < n2) {
            ans = new ArrayList<>();
            ans.add(items2[p2][0]);
            ans.add(items2[p2][1]);
            res.add(ans);
            p2++;
        }
        return res;
    }
}
