package LC.finished;

public class LCOffer10fib {
    // 0 <= n <= 100

    //0,1,1,2,3,5,8,13,21
    //0,1,2,3,4,5,6,7
    public static void main(String[] args) {
        LCOffer10fib l = new LCOffer10fib();
        System.out.println(l.fibPlus(6));
    }

    /*
    	执行耗时:0 ms,击败了100.00% 的Java用户
	内存消耗:38.3 MB,击败了54.28% 的Java用户
     */
    public int fib(int n) {
        if (n == 0) return 0;
        final int MOD = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % MOD;
        }
        return dp[n];
    }

    /*
    执行耗时:0 ms,击败了100.00% 的Java用户
	内存消耗:37.8 MB,击败了99.52% 的Java用户
     */

    public int fibPlus(int n) {
        if (n < 2) return n;
        final int MOD = 1000000007;
        int p=0;
        int q=1;
        int res=0;
        for (int i = 2; i <n+1 ; i++) {
            res=(p+q)%MOD;
            p=q;
            q=res;
        }
        return res;

    }



    //矩阵快速幂
    static final int MOD = 1000000007;

    public int fibLC(int n) {
        if (n < 2) {
            return n;
        }
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n - 1);
        return res[0][0];
    }

    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = (int) (((long) a[i][0] * b[0][j] + (long) a[i][1] * b[1][j]) % MOD);
            }
        }
        return c;
    }
/*
    作者：力扣官方题解
    链接：https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/solutions/976888/fei-bo-na-qi-shu-lie-by-leetcode-solutio-hbss/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */



}
