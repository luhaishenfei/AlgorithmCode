package LC.undo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LCInterview01_08setZeroes {

    public static void main(String[] args) {
        LCInterview01_08setZeroes l = new LCInterview01_08setZeroes();
        l.setZeroes(new int[][]{
                        {1, 1, 1},
                        {1, 0, 1},
                        {1, 1, 1}
        });
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
                matrix[i][(int)r] = 0;
            }
        }
        return;
    }
}
