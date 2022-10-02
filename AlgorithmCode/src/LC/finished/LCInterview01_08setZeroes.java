package LC.finished;

import java.util.HashSet;
import java.util.Set;

public class LCInterview01_08setZeroes {

    public static void main(String[] args) {
        //this same as LC76
        LC76setZeroes lc76 = null;

        LCInterview01_08setZeroes l = new LCInterview01_08setZeroes();
        l.setZeroes(new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        });
    }

    // O(1）
    /*
    我们可以对方法二进一步优化，只使用一个标记变量记录第一列是否原本存在 00。
    这样，第一列的第一个元素即可以标记第一行是否出现 00。
    但为了防止每一列的第一个元素被提前更新，我们需要从最后一行开始，倒序地处理矩阵元素。
     */
    public void setZeroesLC2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (flagCol0) {
                matrix[i][0] = 0;
            }
        }
    }

    //LC: use bool[]
    public void setZeroesLC1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }


    /*
        执行耗时:1 ms,击败了43.70% 的用户
        内存消耗:43.5 MB,击败了5.00% 的用户
     */
    public void setZeroes(int[][] matrix) {
        Set<Integer> rowSet = new HashSet();
        Set<Integer> lineSet = new HashSet();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    lineSet.add(i);
                    rowSet.add(j);
                }
            }
        }
        Object[] linesInts = lineSet.toArray();
        Object[] rowInts = rowSet.toArray();
        for (Object l :
                linesInts) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[(int) l][i] = 0;
            }
        }
        for (Object r :
                rowInts) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][(int) r] = 0;
            }
        }
        return;
    }
}
