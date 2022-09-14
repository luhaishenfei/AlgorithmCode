package LC.undo;

public class LC782movesToChessboard {

    /*
    [[0,1,1,0],
     [0,1,1,0],
     [1,0,0,1],
     [1,0,0,1]]
     */
    public int movesToChessboard(int[][] board) {
        int n = board.length;
        int iCount = 0;
        int jCount = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    iCount++;
                }
                if (board[j][i] == 0) {
                    jCount++;
                }
            }
            if (iCount != n / 2 && jCount != n / 2) {
                return -1;
            }
        }


        return 1;
    }

}
