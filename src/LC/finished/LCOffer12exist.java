package LC.finished;


//
// 示例 2：
//
//
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
//
// m == board.length
// n = board[i].length
// 1 <= m, n <= 6
// 1 <= word.length <= 15
// board 和 word 仅由大小写英文字母组成

public class LCOffer12exist {

    public static void main(String[] args) {
        LCOffer12exist l = new LCOffer12exist();
//        char[][] board = new char[][]{
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}
//        };

        char[][] board = new char[][]{{'a', 'b'}};
        System.out.println(board[0][1]);
        String word = "ab";
        System.out.println(l.exist(board, word));
        System.out.println(board.length);
        System.out.println(board[0].length);
    }

    //
//输入：board =
//[["A","B","C","E"],
// ["S","F","C","S"],
// ["A","D","E","E"]], word ="ABCCED"
//    board.length=3
//    board[0].length=4
//输出：true
//


    /*
    执行耗时:57 ms,击败了98.56% 的Java用户
	内存消耗:39.3 MB,击败了82.36% 的Java用户

	remark：总是解决了
     */
    public boolean exist(char[][] board, String word) {
        boolean[][] check = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (exist(board, word, 1, i, j, check)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word, int idx, int r, int l, boolean[][] check) {
        if (idx == word.length()) return true;
        check[r][l] = true;
        if (r > 0) {
//           up
            if (
                //is not used
                    !check[r - 1][l]
                            //is equal
                            && board[r - 1][l] == word.charAt(idx)
                            //continue search
                            && exist(board, word, idx + 1, r - 1, l, check)) {
                return true;
            }
        }

        if (r < board.length - 1) {
//          down
            if (!check[r + 1][l] && board[r + 1][l] == word.charAt(idx) && exist(board, word, idx + 1, r + 1, l, check)) {
                return true;
            }
        }

        if (l > 0) {
//           left
            if (!check[r][l - 1] && board[r][l - 1] == word.charAt(idx) && exist(board, word, idx + 1, r, l - 1, check)) {
                return true;
            }
        }

        if (l < board[0].length - 1) {
//           right
            if (!check[r][l + 1] && board[r][l + 1] == word.charAt(idx) && exist(board, word, idx + 1, r, l + 1, check)) {
                return true;
            }
        }
        check[r][l] = false;
        return false;
    }


    //LC
    public boolean existLC(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        if (board[i][j] != s.charAt(k)) {
            return false;
        } else if (k == s.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited, newi, newj, s, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }

    //LC DFS
    //remark:is same as upper?
    public boolean existDFS(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if(k == word.length - 1) return true;
        board[i][j] = '\0';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        board[i][j] = word[k];
        return res;
    }

//    作者：Krahets
//    链接：https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof/solutions/103929/mian-shi-ti-12-ju-zhen-zhong-de-lu-jing-shen-du-yo/
}

