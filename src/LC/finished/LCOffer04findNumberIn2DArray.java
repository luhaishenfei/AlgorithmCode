package LC.finished;

/*
//在一个 n * m 的二维数组中，每一行都按照从左到右 非递减 的顺序排序，每一列都按照从上到下 非递减 的顺序排序。请完成一个高效的函数，输入这样的一个二
//维数组和一个整数，判断数组中是否含有该整数。
//
//
//
// 示例:
//
// 现有矩阵 matrix 如下：
//
//
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
//
//
// 给定 target = 5，返回 true。
//
// 给定 target = 20，返回 false。
//
//
//
// 限制：
//
// 0 <= n <= 1000
//
// 0 <= m <= 1000
//
//
//
// 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
//
// Related Topics 数组 二分查找 分治 矩阵 👍 821 👎 0
 */
public class LCOffer04findNumberIn2DArray {
/*
    [[],
    []]
    */
    /*
[
[1,   4,  7, 11, 15],
[2,   5,  8, 12, 19],
[3,   6,  9, 16, 22],
[10, 13, 14, 17, 24],
[18, 21, 23, 26, 30]
]
        5
     */
    public static void main(String[] args) {
        LCOffer04findNumberIn2DArray l = new LCOffer04findNumberIn2DArray();
//        int[][] ints = new int[3][];
//        ints[0]=new int[]{};
//        ints[1]=new int[]{};
//        ints[2]=new int[]{};
//        l.findNumberIn2DArrayLC(ints,1);

        l.findNumberIn2DArray(new int[][]{{1,1}},2);
    }

    //特殊情况处理的更巧妙 如[],[[]],null
    public boolean findNumberIn2DArrayLC(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) i--;
            else if (matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }


    /*

    > 2022/11/10 10:03:21
    解答成功:
	执行耗时:0 ms,击败了100.00% 的Java用户
	内存消耗:47.1 MB,击败了84.42% 的Java用户
     */
    //从第一行最后一列开始查找，大于目标往左移动，小于则往下移动
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //可以按LC的优化掉下面这个语句
        if (matrix.length==0) return false;
        int l = 0;
        int r = matrix[0].length - 1;
        while (l<matrix.length&&r>=0) {
            if (matrix[l][r] < target) {
                l++;
            } else if (matrix[l][r] > target) {
                r--;
            }else {
                return true;
            }
        }
        return false;
    }

    //X
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        for (int i = matrix.length - 1; i >= 0; i--) {
            if (matrix[i][0] < target) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == target) {
                        return true;
                    }
                }
                return false;
            } else if (matrix[i][0] == target) {
                return true;
            }
        }
        return false;
    }
}
