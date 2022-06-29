package LC;

import java.util.ArrayList;
import java.util.List;

public class LC883ProjectionArea {


    public int projectionArea(int[][] grid) {

        int sum=0;
        int sideR=0;
        int[] maxValueL=new int[grid.length];
        List<Integer> maxValueR=new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                //bottom
                if (grid[i][j]!=0){
                    sum++;
                }
                if (grid[i][j]>maxValueL[i]){
                    maxValueL[i]=grid[i][j];
                }
                if (maxValueR.size()==j){
                    maxValueR.add(grid[i][j]);
                }else if(grid[i][j] >maxValueR.get(j)){
                    maxValueR.set(j,grid[i][j]);
                }
            }
        }
        for (int i = 0; i < maxValueL.length; i++) {
            sum+=maxValueL[i];
        }
        for (int i = 0; i < maxValueR.size(); i++) {
            sum+=maxValueR.get(i);
        }
        return sum;
    }

    public int projectionAreaLC(int[][] grid) {
        int n = grid.length;
        int xyArea = 0, yzArea = 0, zxArea = 0;
        for (int i = 0; i < n; i++) {
            int yzHeight = 0, zxHeight = 0;
            for (int j = 0; j < n; j++) {
                xyArea += grid[i][j] > 0 ? 1 : 0;
                yzHeight = Math.max(yzHeight, grid[j][i]);
                zxHeight = Math.max(zxHeight, grid[i][j]);
            }
            yzArea += yzHeight;
            zxArea += zxHeight;
        }
        return xyArea + yzArea + zxArea;
    }

}
