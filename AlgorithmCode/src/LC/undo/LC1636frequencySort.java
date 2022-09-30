package LC.undo;

import java.util.*;

public class LC1636frequencySort {
    public static void main(String[] args) {
        LC1636frequencySort l = new LC1636frequencySort();
        l.frequencySort(new int[]{1, 2, 2, 3, 3});

        //test PriorityQueue
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        priorityQueue.offer(1);
        priorityQueue.offer(3);
        priorityQueue.offer(2);
        priorityQueue.offer(5);
        priorityQueue.offer(7);
        priorityQueue.offer(4);
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }


    //nums = [2,3,1,3,2]
    //[1,3,3,2,2]

    /*
    	执行耗时:5 ms,击败了86.01% 的Java用户
	内存消耗:41.5 MB,击败了77.24% 的Java用户
     */
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
        PriorityQueue<Integer[]> priorityQueue = new PriorityQueue<Integer[]>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if (o1[1] > o2[1]) {
                    return 1;
                } else if (o1[1] < o2[1]) {
                    return -1;
                } else {
                    return o2[0] - o1[0];
                }
            }
        });
        for (int i :
                map.keySet()
        ) {
            priorityQueue.add(new Integer[]{i, map.get(i)});
        }
        int idx = 0;
        while (!priorityQueue.isEmpty()) {
            Integer[] ints = priorityQueue.poll();
            for (int i = 0; i < ints[1]; i++) {
                nums[idx] = ints[0];
                idx++;
            }
        }
        return nums;
    }
}
