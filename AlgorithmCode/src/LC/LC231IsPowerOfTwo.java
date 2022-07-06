package LC;

public class LC231IsPowerOfTwo {
    public static void main(String[] args) {
        LC231IsPowerOfTwo l = new LC231IsPowerOfTwo();
        System.out.println(l.isPowerOfTwo(1024));

        System.out.println(Integer.toBinaryString(1024));
        System.out.println(Integer.toBinaryString(-1024));
        System.out.println(Integer.toBinaryString(~1024));
        System.out.println(Integer.toBinaryString(~-1024));
        //00000000000000000000010000000000
        //11111111111111111111101111111111    取反
        //11111111111111111111110000000000     +1
        //00000000000000000000001111111111    取反

        //11111111111111111111110000000000
        //11111111111111111111101111111111
        //00000000000000000000001111111111
    }

    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        while ((n & 1) != 1) {
            n >>= 1;
        }
        return n == 1;
    }

    public boolean isPowerOfTwoLC(int n) {
        //   n=10000000
        // n-1=01111111
//     n&(n-1)=00000000

        //   n=1010000000
        // n-1=1001111111
//     n&(n-1)=1000000000

        return n > 0 && (n & (n - 1)) == 0;
    }


    /*
    方法二：判断是否为最大 2 的幂的约数
思路与算法

除了使用二进制表示判断之外，还有一种较为取巧的做法。

在题目给定的 3232 位有符号整数的范围内，最大的 22 的幂为 2^30 = 10737418242
。我们只需要判断 n 是否是 2^30
  的约数即可。

代码:
     */
    static final int BIG = 1 << 30;

    public boolean isPowerOfTwoLC2(int n) {
        return n > 0 && BIG % n == 0;
    }
}
