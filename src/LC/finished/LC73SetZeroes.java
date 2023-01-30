package LC.finished;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC73SetZeroes {

    public static void main(String[] args) {
        LC73SetZeroes l = new LC73SetZeroes();

        int[][] matrix = {
                {1, 1, 2, 1},
                {3, 0, 5, 2},
                {1, 3, 0, 5}};

        l.setZeroesLCPowcai(matrix);

    }

    /*
    执行结果：
通过
显示详情
添加备注

执行用时：
1 ms
, 在所有 Java 提交中击败了
38.09%
的用户
内存消耗：
42.6 MB
, 在所有 Java 提交中击败了
88.42%
的用户
通过测试用例：
164 / 164
     */
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> rList = new HashSet<>();
        HashSet<Integer> lList = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rList.add(i);
                    lList.add(j);
                }
            }
        }
        for (int i :
                rList) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 0;
            }
        }
        for (int i :
                lList) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][i] = 0;
            }
        }
    }

    /*
执行用时：
7 ms
, 在所有 Java 提交中击败了
12.04%
的用户
内存消耗：
43.1 MB
, 在所有 Java 提交中击败了
28.79%
的用户
通过测试用例：
164 / 164
 */
    public void setZeroes1(int[][] matrix) {
        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    list.add(new Integer[]{i, j});
                }
            }
        }
        for (int k = 0; k < list.size(); k++) {
            Integer[] ban = list.get(k);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (i == ban[0] || j == ban[1]) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }

    /*
    执行用时：
0 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗：
43.1 MB
, 在所有 Java 提交中击败了
25.00%
的用户
通过测试用例：
164 / 164
     */
    public void setZeroesLCPowcai(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean row0_flag = false;
        boolean col0_flag = false;
        // 第一行是否有零
        for (int j = 0; j < col; j++) {
            if (matrix[0][j] == 0) {
                row0_flag = true;
                break;
            }
        }
        // 第一列是否有零
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                col0_flag = true;
                break;
            }
        }
        // 把第一行第一列作为标志位
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // 置0
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row0_flag) {
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col0_flag) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }

}
