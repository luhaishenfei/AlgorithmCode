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
题目中求最少的翻转 000 的数目等价于求矩阵中两个岛的最短距离，因此我们可以广度优先搜索来找到矩阵中两个块的最短距离。首先找到其中一座岛，然后将其不断向外延伸一圈，直到到达了另一座岛，延伸的圈数即为最短距离。广度优先搜索时，我们可以将已经遍历过的位置标记为 −1-1−1，实际计算过程如下：

我们通过遍历找到数组 grid\textit{grid}grid 中的 111 后进行广度优先搜索，此时可以得到第一座岛的位置集合，记为 island\textit{island}island，并将其位置全部标记为 −1-1−1。
随后我们从 island\textit{island}island 中的所有位置开始进行广度优先搜索，当它们到达了任意的 111 时，即表示搜索到了第二个岛，搜索的层数就是答案。
 */

    public int shortestBridge(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        Deque<Integer[]> stack = new ArrayDeque();
        this.island1 = new ArrayList();

        int i=0;
        int j=0;
        while (grid[i][j] == 0) {

        }

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
    }
}
        System.out.println(island1);


                return-1;
                }


    /*
        shit hole;
        执行耗时:727 ms,击败了5.01% 的Java用户
        内存消耗:43.4 MB,击败了5.03% 的Java用户
     */
                int width;
                int height;
                List<Integer[]>island1;

public int shortestBridge1(int[][]grid){
        this.height=grid.length;
        this.width=grid[0].length;

        Deque<Integer[]>stack=new ArrayDeque();
        this.island1=new ArrayList();
        List<Integer[]>island2=new ArrayList();
        for(int i=0;i<height; i++){
        for(int j=0;j<width; j++){
        //not find any island
        if(grid[i][j]==1){
        if(island1.size()==0){
        stack.push(new Integer[]{i,j});
        grid[i][j]=0;
        while(!stack.isEmpty()){
        Integer[]pos=stack.pop();
        int x=pos[0];
        int y=pos[1];
        island1.add(new Integer[]{x,y});
        //added,set zero
        if(isLegal(x-1,y)&&grid[x-1][y]==1){
        grid[x-1][y]=0;
        stack.push(new Integer[]{x-1,y});
        }
        if(isLegal(x+1,y)&&grid[x+1][y]==1){
        grid[x+1][y]=0;
        stack.push(new Integer[]{x+1,y});
        }
        if(isLegal(x,y-1)&&grid[x][y-1]==1){
        grid[x][y-1]=0;
        stack.push(new Integer[]{x,y-1});
        }
        if(isLegal(x,y+1)&&grid[x][y+1]==1){
        grid[x][y+1]=0;
        stack.push(new Integer[]{x,y+1});
        }
        }
        System.out.println(island1);
        }else{
        stack.push(new Integer[]{i,j});
        grid[i][j]=0;
        while(!stack.isEmpty()){
        Integer[]pos=stack.pop();
        int x=pos[0];
        int y=pos[1];
        island2.add(new Integer[]{x,y});
        //added,set zero
        if(isLegal(x-1,y)&&grid[x-1][y]==1){
        grid[x-1][y]=0;
        stack.push(new Integer[]{x-1,y});
        }
        if(isLegal(x+1,y)&&grid[x+1][y]==1){
        grid[x+1][y]=0;
        stack.push(new Integer[]{x+1,y});
        }
        if(isLegal(x,y-1)&&grid[x][y-1]==1){
        grid[x][y-1]=0;
        stack.push(new Integer[]{x,y-1});
        }
        if(isLegal(x,y+1)&&grid[x][y+1]==1){
        grid[x][y+1]=0;
        stack.push(new Integer[]{x,y+1});
        }
        }

        }
        }
        }
        }
        System.out.println(island1);
        System.out.println(island2);

        int minDistance=width+height;
        for(Integer[]land1:
        island1){
        for(Integer[]land2:
        island2){
        int distance=(Math.abs(land1[0]-land2[0])+Math.abs(land1[1]-land2[1]));
        if(distance<minDistance){
        minDistance=distance;
        }
        }
        }


        return minDistance-1;
        }


public boolean isLegal(int i,int j){
        if(i< 0||i>=width||j< 0||j>=height){
        return false;
        }else{
        return true;
        }
        }


        }
