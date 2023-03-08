package commonAlgorithm;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci o = new Fibonacci();
        long timer=System.currentTimeMillis();
        for (int i = 0; i < 6; i++) {
            System.out.println(o.FibonacciDPPlis(i));
        }
        System.out.println(o.FibonacciDPPlis(45));

        timer=System.currentTimeMillis()-timer;
        System.out.println(timer);

    }

    //递归
    int FibonacciDG(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n==1||n==2){
            return 1;
        }
        return FibonacciDG(n-1)+FibonacciDG(n-2);
    }



    //动态规划
    int FibonacciDP(int n){
        int[] f=new int[n+1];

        f[0]=0;
        f[1]=1;
        for (int i = 2; i < f.length; i++) {
            f[i]=f[i-1]+f[i-2];
        }
        return f[n];

    }

    //DP优化
    int FibonacciDPPlis(int n){
        if (n <= 0) {
            return 0;
        }
        if (n==1||n==2){
            return 1;
        }
        int res=0;
        int v1=0;
        int v2=1;
        for (int i = 2; i <=n ; i++) {
            res=v1+v2;
            v1=v2;
            v2=res;
        }
        return res;

    }
}
