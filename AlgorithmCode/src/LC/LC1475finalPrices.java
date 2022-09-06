package LC;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC1475finalPrices {

    /*
	执行耗时:1 ms,击败了98.71% 的Java用户
	内存消耗:41.6 MB,击败了53.99% 的Java用户
 */
    /*
    //normal way,maybe try 单调栈,will more faster
        时间:O(n^2)
        空间:O(1)
     */
    public int[] finalPrices1(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    prices[i] -= prices[j];
                    break;
                }
            }
        }
        return prices;
    }

    public static void main(String[] args) {
        LC1475finalPrices l = new LC1475finalPrices();
        int[] res = l.finalPrices1(new int[]{8, 4, 6, 2, 3});
        System.out.println(res);
    }

    //[8,4,6,2,3]
    /*  好像更辣鸡了，第二次好像还不错？
    1.	执行耗时:4 ms,击败了13.71% 的Java用户
	内存消耗:41.8 MB,击败了18.28% 的Java用户

	2.	执行耗时:3 ms,击败了38.28% 的Java用户
	内存消耗:41.4 MB,击败了81.09% 的Java用户


     */
    public int[] finalPrices(int[] prices) {
        Deque<Integer> stack = new ArrayDeque();
        for (int i = prices.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(prices[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() > prices[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    stack.push(prices[i]);
                } else {
                    int v = stack.peek();
                    stack.push(prices[i]);
                    prices[i] -= v;
                }
            }
        }
        return prices;
    }


    /*
        感觉也就一般般
    	执行耗时:4 ms,击败了13.71% 的Java用户
	内存消耗:41.3 MB,击败了85.51% 的Java用户
     */
    public int[] finalPricesLC(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? prices[i] : prices[i] - stack.peek();
            stack.push(prices[i]);
        }
        return ans;
    }
}
