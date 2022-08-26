package LC._undo;
/*
658. 找到 K 个最接近的元素
给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。

整数 a 比整数 b 更接近 x 需要满足：

|a - x| < |b - x| 或者
|a - x| == |b - x| 且 a < b


示例 1：

输入：arr = [1,2,3,4,5], k = 4, x = 3
输出：[1,2,3,4]
示例 2：

输入：arr = [1,2,3,4,5], k = 4, x = -1
输出：[1,2,3,4]


提示：

1 <= k <= arr.length
1 <= arr.length <= 104
arr 按 升序 排列
-104 <= arr[i], x <= 104
通过次数62,161提交次数130,169
 */

import java.util.*;

public class LC658findClosestElements {
    //
//        for (int i = 0; i <arr.length ; i++) {
//            arr[i]=arr[i]-x;
//        }
//        Comparator<Object> comparator= new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                int i=(Integer)o1;
//                int j=(Integer)o2;
//                if (i<0){
//                    i=-i;
//                }
//                if (j<0){
//                    j=-j;
//                }
//                return i-j;
//            }
//        };
//        List res = new ArrayList();
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i]>=0){
//                res.add(arr[i]+3);
//            }
//            if (res.size()==k){
//                return res;
//            }
//        }
//        return res;
    public static void main(String[] args) {
        LC658findClosestElements l = new LC658findClosestElements();
        int[] ints = new int[10];

        for (int i = 0; i < ints.length; i++) {
            ints[i] =(int) (Math.random() * 100);
        }
        Arrays.sort(ints);

        l.findClosestElements(ints, 4, ints[7]);
    }


    // x:aim   k:count
    // [1,2,3,4,5], k = 4, x = 3
    // [1,2,3,4]
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List res = new ArrayList();

        int aim = getIdx(arr, x);
        int leftIdx=aim-1;
        int rightIdx=aim+1;
        res.add(arr[aim]);
        for (int i = 0; i <k-1; i++) {
            if (leftIdx<0){
                res.add(arr[rightIdx++]);
            }else if (rightIdx>=arr.length){
                res.add(arr[leftIdx--]);
            }else {
                int l =x-arr[leftIdx];
                int r =arr[rightIdx]-x;
                if (l<=r){
                    res.add(arr[leftIdx--]);
                }else{
                    res.add(arr[rightIdx++]);
                }
            }

        }
        res.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        return res;
    }

    private int getIdx(int[] arr, int aim) {
        return getIdx(arr, aim, 0, arr.length);
    }

    private int getIdx(int[] arr, int aim, int start, int end) {
        int mid = (end - start) / 2 + start;
        if (arr[mid] == aim) return mid;
        if (arr[mid] > aim) return getIdx(arr, aim, start, mid);
        return getIdx(arr, aim, mid, end);
    }
}
