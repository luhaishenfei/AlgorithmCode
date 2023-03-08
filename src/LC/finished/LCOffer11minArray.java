package LC.finished;

//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
//
// 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3
//,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。
//
// 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2],
//..., a[n-2]] 。
//
//
//
// 示例 1：
//
//
//输入：numbers = [3,4,5,1,2]
//输出：1
//
//
// 示例 2：
//
//
//输入：numbers = [2,2,2,0,1]
//输出：0
//
//
//
//
// 提示：
//
//
// n == numbers.length
// 1 <= n <= 5000
// -5000 <= numbers[i] <= 5000
// numbers 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
//
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-
//sorted-array-ii/
//


public class LCOffer11minArray {

    public static void main(String[] args) {
        int[] ints = new int[]{3, 1, 3, 3};
        LCOffer11minArray l = new LCOffer11minArray();
        int res = l.minArray(ints);
        System.out.println(res);
    }

    /*
    执行耗时:0 ms,击败了100.00% 的Java用户
	内存消耗:41.3 MB,击败了42.82% 的Java用户
     */
    public int minArray(int[] numbers) {
        int mid = numbers.length / 2;
        return Math.min(minArray(numbers, 0, mid), minArray(numbers, mid + 1, numbers.length - 1));
    }

    public int minArray(int[] numbers, int start, int end) {
        int sub = end - start;
        if (sub <= 0) return numbers[end];
        if (numbers[start] < numbers[end]) return numbers[start];
        int mid = (start + end) / 2;
        return Math.min(minArray(numbers, start, mid), minArray(numbers, mid + 1, end));
    }


    public int minArrayLC(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }
}
