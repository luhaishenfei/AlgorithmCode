package LC._undo;

/*
1184. 公交站间的距离
环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。

环线上的公交车都可以按顺时针和逆时针的方向行驶。

返回乘客从出发点 start 到目的地 destination 之间的最短距离。

示例 1：

输入：distance = [1,2,3,4], start = 0, destination = 1
输出：1
解释：公交站 0 和 1 之间的距离是 1 或 9，最小值是 1。


示例 2：



输入：distance = [1,2,3,4], start = 0, destination = 2
输出：3
解释：公交站 0 和 2 之间的距离是 3 或 7，最小值是 3。


示例 3：



输入：distance = [1,2,3,4], start = 0, destination = 3
输出：4
解释：公交站 0 和 3 之间的距离是 6 或 4，最小值是 4。


提示：

1 <= n <= 10^4
distance.length == n
0 <= start, destination < n
0 <= distance[i] <= 10^4
通过次数38,218提交次数61,384
 */
public class LC1184distanceBetweenBusStops {
    /*
    输入：distance = [1,2,3,4], start = 0, destination = 1
输出：1
     */
    public static void main(String[] args) {
        LC1184distanceBetweenBusStops l = new LC1184distanceBetweenBusStops();
        l.distanceBetweenBusStops(new int[]{1,2,3,4} ,0,3);
    }


    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start==destination) return 0;
        int res1=distance[start];
        int res2=0;
        int idx1=0;
        int idx2=0;
        while (true){
            if ((start+idx1)%distance.length==destination){
            }

            if (res1>res2){
                res2=res2 + distance[(start-idx2-1+distance.length)%distance.length];
                idx2++;
            }else {
                res1=res1 + distance[(start+idx1)%distance.length];
                idx1++;
            }
        }

    }

    /*
    执行用时：
0 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗：
41.4 MB
, 在所有 Java 提交中击败了
12.41%
的用户
通过测试用例：
37 / 37
     */
    public int distanceBetweenBusStops1(int[] distance, int start, int destination) {
        int res = 0;
        for (int i = 0; i < distance.length; i++) {
            if ((start+i)%distance.length==destination) break;
            res = res + distance[(start+i)%distance.length];
        }
        int res2=0;
        for (int i = 0; i < distance.length; i++) {
            if ((start-i+distance.length)%distance.length==destination) break;
            res2 = res2 + distance[(start-i-1+distance.length)%distance.length];

        }
        return Math.min(res,res2);
    }
}
