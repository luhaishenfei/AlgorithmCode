package LC.undo;

import java.util.*;

public class LC1636frequencySort {
    public static void main(String[] args) {
        LC1636frequencySort l = new LC1636frequencySort();
       // l.frequencySort(new int[]{1,  2, 2, 1,3, 3});

    }


    //nums = [2,3,1,3,2]
    //[1,3,3,2,2]

    public int[] frequencySort(int[] nums) {

        Map<Integer, Integer> map = new HashMap();
        for (int i :
                nums) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.replace(i, map.get(i) + 1);
            }
        }
        PriorityQueue<Integer[]> priorityQueue = new PriorityQueue(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if (o1[1] > o2[1]) {
                    return 1;
                } else if (o1[1] < o2[1]) {
                    return -1;
                } else {
                    return o2[0]- o1[0] ;
                }
            }
        });
        for (int i :
                map.keySet()
        ) {
            priorityQueue.add(new Integer[]{i, map.get(i)});
        }
        int idx = 0;
        for (Integer[] ints :
                priorityQueue) {
            for (int i = 0; i < ints[1]; i++) {
                nums[idx] = ints[0];
                idx++;
            }
        }
        return nums;
    }
}
