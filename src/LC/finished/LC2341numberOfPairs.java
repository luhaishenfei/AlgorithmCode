package LC.finished;

import java.util.*;

public class LC2341numberOfPairs {

    // 1 <= nums.length <= 100
    // 0 <= nums[i] <= 100

    /*  method1:set 轻松秒杀
        执行耗时:1 ms,击败了54.00% 的Java用户
        内存消耗:40.4 MB,击败了38.00% 的Java用户
     */
    public int[] numberOfPairs1(int[] nums) {
        Set<Integer> existSet = new HashSet<>();
        int pairs = 0;
        for (int num :
                nums) {
            if (existSet.contains(num)) {
                pairs++;
                existSet.remove(num);
            } else {
                existSet.add(num);
            }
        }
        return new int[]{pairs, nums.length - pairs * 2};
    }

    public int[] numberOfPairsLC(int[] nums) {
        Map<Integer, Boolean> cnt = new HashMap<Integer, Boolean>();
        int res = 0;
        for (int num : nums) {
            cnt.put(num, !cnt.getOrDefault(num, false));
            if (!cnt.get(num)) {
                res++;
            }
        }
        return new int[]{res, nums.length - 2 * res};
    }

    //sort
    /*
	执行耗时:1 ms,击败了54.00% 的Java用户
	内存消耗:39.9 MB,击败了93.20% 的Java用户
	*/
    public int[] numberOfPairs(int[] nums) {
        Arrays.sort(nums);
        int pairs = 0;
        int lastNum = -1;
        for (int n :
                nums) {
            if (lastNum == n) {
                pairs++;
                lastNum = -1;
            } else {
                lastNum = n;
            }
        }
        return new int[]{pairs, nums.length - pairs * 2};
    }

    }
