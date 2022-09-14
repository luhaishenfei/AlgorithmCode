package LC.finished;


import java.util.*;

/*
//给你一个整数数组 arr ，请你删除最小 5% 的数字和最大 5% 的数字后，剩余数字的平均值。
//
// 与 标准答案 误差在 10⁻⁵ 的结果都被视为正确结果。
//
 */
public class LC1619trimMean {
    public static void main(String[] args) {
        LC1619trimMean l = new LC1619trimMean();
        l.trimMean(new int[]{1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3});

    }


    //too bad
    /*
     2022/09/14 16:26:10
解答成功:
	执行耗时:9 ms,击败了6.54% 的Java用户
	内存消耗:40.9 MB,击败了88.28% 的Java用户
     */
    public double trimMean1(int[] arr) {
        int count=arr.length/20;

        Queue<Integer> queueMin = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        Queue<Integer> queueMax = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            queueMax.add(arr[i]);
            queueMin.add(arr[i]);
            if (queueMax.size() > count) {
                queueMax.poll();
            }
            if (queueMin.size() > count) {
                queueMin.poll();
            }
        }
        while (!queueMax.isEmpty()) {
            sum = sum - queueMax.poll();
        }
        while (!queueMin.isEmpty()) {
            sum = sum - queueMin.poll();
        }

        return sum / (double) (arr.length-2*count );
    }


    //sort :just ok
    public double trimMean(int[] arr) {
        int count = arr.length / 20;
        Arrays.sort(arr);
        int sum = 0;
        for (int i = count; i < arr.length - count; i++) {
            sum = sum + arr[i];
        }
        double res = sum / (double) (arr.length - 2 * count);
        return res;
    }
}
