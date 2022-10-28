package LC.undo;


//输入：grid = [[0,1],
//             [1,0]]
//输出：1
//
//输入：grid = [[0,1,0],
//             [0,0,0],
//             [0,0,1]]
//输出：2
//
//
// 示例 3：
//
//
//                  {0,2} - {2,2}
//输入：grid = [[1,1,1,1,1],
//             [1,0,0,0,1],
//             [1,0,1,0,1],
//             [1,0,0,0,1],
//             [1,1,1,1,1]]
//输出：1
//
//


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC934shortestBridge {
    public static void main(String[] args) {
//        List<Integer[]> list = new ArrayList();
//        list.add(new Integer[]{0, 0});
//        System.out.println(list.contains(new Integer[]{0, 0}));

        LC934shortestBridge l = new LC934shortestBridge();
        int res = l.shortestBridge(new int[][]{
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1}
        });
        System.out.println(res);
    }



/*
    shit hole;
    执行耗时:727 ms,击败了5.01% 的Java用户
    内存消耗:43.4 MB,击败了5.03% 的Java用户
 */
    int width;
    int height;
    List<Integer[]> island1;
    public int shortestBridge(int[][] grid) {
        this.height = grid.length;
        this.width = grid[0].length;

        Deque<Integer[]> stack = new ArrayDeque();
        this.island1 = new ArrayList();
        List<Integer[]> island2 = new ArrayList();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                //not find any island
                if (grid[i][j] == 1) {
                    if (island1.size() == 0) {
                        stack.push(new Integer[]{i, j});
                        grid[i][j] = 0;
                        while (!stack.isEmpty()) {
                            Integer[] pos = stack.pop();
                            int x = pos[0];
                            int y = pos[1];
                            island1.add(new Integer[]{x, y});
                            //added,set zero
                            if (isLegal(x - 1, y) && grid[x - 1][y] == 1) {
                                grid[x - 1][y] = 0;
                                stack.push(new Integer[]{x - 1, y});
                            }
                            if (isLegal(x + 1, y) && grid[x + 1][y] == 1) {
                                grid[x + 1][y] = 0;
                                stack.push(new Integer[]{x + 1, y});
                            }
                            if (isLegal(x, y - 1) && grid[x][y - 1] == 1) {
                                grid[x][y - 1] = 0;
                                stack.push(new Integer[]{x, y - 1});
                            }
                            if (isLegal(x, y + 1) && grid[x][y + 1] == 1) {
                                grid[x][y + 1] = 0;
                                stack.push(new Integer[]{x, y + 1});
                            }
                        }
                        System.out.println(island1);
                    } else {
                        stack.push(new Integer[]{i, j});
                        grid[i][j] = 0;
                        while (!stack.isEmpty()) {
                            Integer[] pos = stack.pop();
                            int x = pos[0];
                            int y = pos[1];
                            island2.add(new Integer[]{x, y});
                            //added,set zero
                            if (isLegal(x - 1, y) && grid[x - 1][y] == 1) {
                                grid[x - 1][y] = 0;
                                stack.push(new Integer[]{x - 1, y});
                            }
                            if (isLegal(x + 1, y) && grid[x + 1][y] == 1) {
                                grid[x + 1][y] = 0;
                                stack.push(new Integer[]{x + 1, y});
                            }
                            if (isLegal(x, y - 1) && grid[x][y - 1] == 1) {
                                grid[x][y - 1] = 0;
                                stack.push(new Integer[]{x, y - 1});
                            }
                            if (isLegal(x, y + 1) && grid[x][y + 1] == 1) {
                                grid[x][y + 1] = 0;
                                stack.push(new Integer[]{x, y + 1});
                            }
                        }

                    }
                }
            }
        }
        System.out.println(island1);
        System.out.println(island2);

        int minDistance = width + height;
        for (Integer[] land1 :
                island1) {
            for (Integer[] land2 :
                    island2) {
                int distance = (Math.abs(land1[0] - land2[0]) + Math.abs(land1[1] - land2[1]));
                if (distance < minDistance) {
                    minDistance = distance;
                }
            }
        }


        return minDistance - 1;
    }


    public boolean isLegal(int i, int j) {
        if (i < 0 || i >= width || j < 0 || j >= height) {
            return false;
        } else {
            return true;
        }
    }


}
