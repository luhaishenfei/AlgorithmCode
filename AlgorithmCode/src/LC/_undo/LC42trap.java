package LC._undo;

/*
42. 接雨水
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
示例 1：
输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
输出：6
解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
示例 2：

输入：height = [4,2,0,3,2,5]
输出：9

提示：

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
 */

public class LC42trap {
    public static void main(String[] args) {
        LC42trap l = new LC42trap();
        int[] ints={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(l.trap(ints));
    }
    //[0,1,0,2,1,0,1,3,2,1,2,1]
    public int trap(int[] height) {
        int left = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] < left) {
                left = i - 1;
                break;
            }
            left = height[i];
            if (i == height.length - 1) {
                return 0;
            }
        }
        int right = 0;
        for (int i = height.length - 1; i > left; i--) {
            if (height[i] < right) {
                right = i + 1;
                break;
            }
            right = height[i];
            if (i == left) {
                return 0;
            }
        }
        return getTrap(height, left, right);
    }

    public int getTrap(int[] height, int left, int right) {
        int idx=getMaxIdx(height, left, right);
        if (idx == -1) {
            return (right - left) * Math.min(height[left], height[right]) -getAllValue(height,left,right);
        }else {
            return getTrap(height,left,idx)+getTrap(height,idx,right);
        }
    }


    public int getMaxIdx(int[] height, int l, int r) {
        int max = Math.min(height[l], height[r]);
        int maxIdx = 0;
        for (int i = l + 1; i < r; i++) {
            if (height[i] > max) {
                max = height[i];
                maxIdx = i;
            }
        }
        if (max == Math.min(l, r)) return -1;
        return maxIdx;
    }

    public int getAllValue(int[] height, int l, int r) {
        int sum =0;
        for (int i = l+1; i <r ; i++) {
            sum+=height[i];
        }
        return sum;
    }

}
