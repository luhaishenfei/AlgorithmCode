package LC.finished;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC36EffectiveSudoku {
    char[][] board = new char[][]{
              {'9', '3', '.', '.', '7', '.', '.', '.', '.'}
            , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
            , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
            , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
            , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
            , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
            , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
            , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
            , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

    char[][] board2=new char[][]{
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
            , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
            , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
            , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
            , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
            , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
            , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
            , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
            , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };

    public static void main(String[] args) {
        LC36EffectiveSudoku l = new LC36EffectiveSudoku();
        System.out.println(l.isValidSudoku(l.board));
    }

    public boolean isValidSudoku(char[][] board) {

        int wide = board.length;
        int high = board[0].length;
        int sqer= (int) Math.sqrt(wide);
        List<Character> addedList = new ArrayList<>();
        for (int i = 0; i < high; i++) {
            for (int j = 0; j < wide; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (addedList.contains(c)) {
                        return false;
                    } else {
                        addedList.add(c);
                    }
                }

            }
            addedList.clear();
        }
        for (int i = 0; i < wide; i++) {
            for (int j = 0; j < high; j++) {
                char c = board[j][i];
                if (c != '.') {
                    if (addedList.contains(c)) {
                        return false;
                    } else {
                        addedList.add(c);
                    }
                }
            }
            addedList.clear();
        }
        //3x3 x9
        for (int i = 0; i < sqer; i++) {
            for (int j = 0; j < sqer; j++) {
                for (int k = 0; k < sqer; k++) {
                    for (int l = 0; l < sqer; l++) {
                        char c = board[k+i*3][l+j*3];
                        if (c != '.') {
                            if (addedList.contains(c)) {
                                return false;
                            } else {
                                addedList.add(c);
                            }
                        }
                    }

                }
                addedList.clear();
            }
        }


        return true;
    }






    public boolean isValidSudoku2(char[][] board) {

        int wide = board.length;
        int high = board[0].length;
        Set<String> boardSet=new HashSet<>();
        int setSize=boardSet.size();
        for (int i = 0; i <wide ; i++) {
            for (int j = 0; j < high; j++) {
                char c = board[i][j];
                if (c!='.'){
                    boardSet.add("l"+i+"="+c);
                    boardSet.add("r"+j+"="+c);
                    boardSet.add("l"+i/3+"r"+j/3+"="+c);

                    if (boardSet.size()-setSize!=3){
                        return false;
                    }else {
                        setSize=boardSet.size();
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudokuLC(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subboxes = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1;
                    rows[i][index]++;
                    columns[j][index]++;
                    subboxes[i / 3][j / 3][index]++;
                    if (rows[i][index] > 1 || columns[j][index] > 1 || subboxes[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
/*

请你判断一个9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。

数字1-9在每一行只能出现一次。
数字1-9在每一列只能出现一次。
数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）


注意：

一个有效的数独（部分已被填充）不一定是可解的。
只需要根据以上规则，验证已经填入的数字是否有效即可。
空白格用'.'表示。

示例 1：

输入：board =
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
输出：true
示例 2：

输入：board =
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
输出：false
解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-sudoku
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */