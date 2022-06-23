package LC;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LC386LexicalOrder {
    public static void main(String[] args) {
        LC386LexicalOrder l = new LC386LexicalOrder();
        List<Integer> integers = l.lexicalOrder2(213);
        for (int i :
                integers) {
            System.out.print(i + ",");
        }
    }

    //不符合   时间复杂度为 O(n) 且使用 O(1) 额外空间的算法
    public List<Integer> lexicalOrder(int n) {

        List list = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        list.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {

                String str1 = o1.toString();
                String str2 = o2.toString();
                return str1.compareTo(str2);
            }
        });

        return list;
    }

    List<Integer> list = new ArrayList<>();

    public List<Integer> lexicalOrder2(int n) {

        int num = 1;
        for (int i = 1; i <= 9; i++) {
            dp(i, n);
        }
        return list;
    }

    void dp(int num, int limit) {
        if (num > limit) return;
        list.add(num);
        for (int i = 0; i < 10; i++) {
            dp(num * 10 + i, limit);
        }

    }


    //
    List<Integer> ans = new ArrayList<>();

    public List<Integer> lexicalOrderLC(int n) {
        for (int i = 1; i <= 9; i++) dfs(i, n);
        return ans;
    }

    void dfs(int cur, int limit) {
        if (cur > limit) return;
        ans.add(cur);
        for (int i = 0; i <= 9; i++) dfs(cur * 10 + i, limit);
    }

}
