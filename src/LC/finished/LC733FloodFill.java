package LC.finished;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC733FloodFill {
    public static void main(String[] args) {
        int[][] i = new int[][]{
//                {1,1,1},{1,1,0},{1,0,1}
//                {0,0,0},{0,0,0}
                {0, 0, 0}, {0, 1, 1}
        };
        LC733FloodFill l = new LC733FloodFill();

        i = l.floodFill(i, 1, 1, 1);
        System.out.println(i);
    }


    //    image[sr][sc]

    Queue<int[]> searchQue = new LinkedList();
    List<String> addedList = new ArrayList();
    int target;
    int newColor;
    int[][] image;


    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        this.target = image[sr][sc];
        this.newColor = newColor;
        this.image = image;
        searchQue.offer(new int[]{sr, sc});
        this.image[sr][sc] = newColor;

        while (!searchQue.isEmpty()) {
            int[] node = searchQue.poll();
            int r = node[0];
            int l = node[1];
            //up   1,2
            isSelect(r - 1, l);
            //down
            isSelect(r + 1, l);
            //left
            isSelect(r, l - 1);
            //right
            isSelect(r, l + 1);
            addedList.add(r + "-" + l);
        }

        return this.image;
    }

    public void isSelect(int r, int l) {
        //基础有效性判断
        if (r >= 0 && r < image.length && l >= 0 && l < image[r].length) {
            if (image[r][l] == target && !addedList.contains(r + "-" + l)) {
                image[r][l] = newColor;
                searchQue.offer(new int[]{r, l});
            }
            addedList.add(r + "-" + l);
        }
    }


    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    public int[][] floodFillLC(int[][] image, int sr, int sc, int newColor) {
        int currColor = image[sr][sc];
        if (currColor == newColor) {
            return image;
        }
        int n = image.length, m = image[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < n && my >= 0 && my < m && image[mx][my] == currColor) {
                    queue.offer(new int[]{mx, my});
                    image[mx][my] = newColor;
                }
            }
        }
        return image;
    }
}
/*
    作者：LeetCode-Solution
    链接：https://leetcode-cn.com/problems/flood-fill/solution/tu-xiang-xuan-ran-by-leetcode-solution/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

 */
