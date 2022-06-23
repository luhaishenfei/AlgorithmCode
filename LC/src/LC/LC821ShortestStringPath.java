package LC;

import java.util.*;

public class LC821ShortestStringPath {
    public static void main(String[] args) {
        LC821ShortestStringPath l = new LC821ShortestStringPath();
        int[] ints = l.shortestToCharLC("ljlkdjka", 'j');
        for (int i :
                ints) {
            System.out.print(i+",");
        }
        System.out.println();
    }
    public int[] shortestToChar(String s, char c) {
        int[] path=new int[s.length()];
        List list =new ArrayList<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==c){
                path[i]=0;
                list.add(i);
            }else {
                path[i]=1;
            }
        }
        for (int i = 0; i < path.length; i++) {
            if (path[i]!=0){
                path[i]=shortestPath(i,list);
            }
        }

        return  path;
    }

    int shortestPath(int index, List<Integer> aims){
       int shortestInt=Integer.MAX_VALUE;
        for (int i :
                aims) {
            i=Math.abs(i-index);
            if (shortestInt>i){
                shortestInt=i;
            }
        }
        return shortestInt;
    }

    public int[] shortestToCharLC(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                d.addLast(i);
                ans[i] = 0;
            }
        }
        int[] dirs = new int[]{-1, 1};
        while (!d.isEmpty()) {
            int t = d.pollFirst();
            for (int di : dirs) {
                int ne = t + di;
                if (ne >= 0 && ne < n && ans[ne] == -1) {
                    ans[ne] = ans[t] + 1;
                    d.addLast(ne);
                }
            }
        }
        return ans;
    }
/*
    BFS rank:A+
    作者：AC_OIer
    链接：https://leetcode-cn.com/problems/shortest-distance-to-a-character/solution/by-ac_oier-5bjs/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


 */


    public int[] shortestToCharAC_OIer(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];
        Arrays.fill(ans, n + 1);
        for (int i = 0, j = -1; i < n; i++) {
            if (s.charAt(i) == c) j = i;
            if (j != -1) ans[i] = i - j;
        }
        for (int i = n - 1, j = -1; i >= 0; i--) {
            if (s.charAt(i) == c) j = i;
            if (j != -1) ans[i] = Math.min(ans[i], j - i);
        }
        return ans;
    }
    /*
    正向遍历后反向遍历 Rank:C
    作者：AC_OIer
    链接：https://leetcode-cn.com/problems/shortest-distance-to-a-character/solution/by-ac_oier-5bjs/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
