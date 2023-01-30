package LC.finished;

/*
给定2D空间中四个点的坐标 p1, p2, p3 和 p4，如果这四个点构成一个正方形，则返回 true 。

点的坐标 pi 表示为 [xi, yi] 。输入 不是 按任何顺序给出的。

一个 有效的正方形 有四条等边和四个等角(90度角)。

 

示例 1:

输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
输出: True
示例 2:

输入：p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
输出：false
示例 3:

输入：p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
输出：true
 

提示:

p1.length == p2.length == p3.length == p4.length == 2
-104 <= xi, yi <= 104
通过次数22,070提交次数47,660

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/valid-square
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC593validSquare {

    /*

输入：p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
false
     */

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        double side=0;
        double diagonal=0;
        side = getDistance(p1, p2);
        double t = getDistance(p1, p3);
        if (t != side) {
            diagonal=Math.max(side,t);
            side=Math.min(side,t);
            if (diagonal != side * 2) {
                return false;
            }
        }
        t = getDistance(p1, p4);
        if (t != side) {
            diagonal=Math.max(side,t);
            side=Math.min(side,t);
            if (diagonal != side * 2) {
                return false;
            }
        }
        if (side==0||diagonal==0) return false;
        t = getDistance(p2, p3);
        if (t!=side&&t!=diagonal) return false;
        t=getDistance(p2,p4);
        if (t!=side&&t!=diagonal) return false;
        t=getDistance(p3,p4);
        if (t!=side&&t!=diagonal) return false;
        return true;
    }

    double getDistance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
