package LC.finished;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC350Intersect {

    public static void main(String[] args) {
        LC350Intersect l = new LC350Intersect();
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        l.intersect(nums1, nums2);
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap();

        for (int i :
                nums1) {
            if (map.get(i) == null) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }

        Map<Integer, Integer> resultMap = new HashMap();
        for (int i :
                nums2) {
            if (map.containsKey(i)) {
                if (!resultMap.containsKey(i)) {
                    resultMap.put(i, 1);
                } else {
                    resultMap.put(i, resultMap.get(i) + 1);
                }
                int isDelete = map.get(i) - 1;
                if (isDelete < 1) {
                    map.remove(i);
                } else {
                    map.put(i, isDelete);
                }

            }
        }
        int len = 0;
        for (Integer value : resultMap.values()) {
            len += value;
        }
        int[] res = new int[len];
        for (int i = 0; i < res.length; i++) {
            for (Integer integer : resultMap.keySet()) {
                for (int j = 0; j < resultMap.get(integer); j++) {
                    res[i] = integer;
                    i++;
                }
            }
        }
        return res;
    }
/*
    执行用时：
            3ms,
    在所有 Java    提交中击败了
    37.83%    的用户
    内存消耗：
            41.3MB,
    在所有 Java    提交中击败了
    62.32%
    的用户
*/

    public int[] intersectLC(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersectLC(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
}
