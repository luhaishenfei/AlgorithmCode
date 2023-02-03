package LC.finished;

/*
解答成功:
	执行耗时:1 ms,击败了83.26% 的Java用户
	内存消耗:38.4 MB,击败了46.03% 的Java用户
 */

public class LC2180countEven {
    public static void main(String[] args) {
        LC2180countEven l = new LC2180countEven();
    }

    public int countEven(int num) {
        int count=0;
        for (int i = 1; i <= num; i++) {
            if (isEven(i)) count++;
        }
        return count;
    }

    public boolean isEven(int num){
        boolean isEven=true;
        while (num!=0){
            int tail=num%10;
            if (tail%2!=0){
                isEven=!isEven;
            }
            num=num/10;
        }
        return isEven;
    }


    //数学归纳法
    /*
    首先有两个简单的数学结论：

给定 0≤x<100 \le x \lt 100≤x<10，位于区间 [0,x][0, x][0,x] 内的偶数个数为 ⌊x2⌋+1\left\lfloor \dfrac{x}{2} \right\rfloor + 1⌊
2
x
​
 ⌋+1，位于区间 [0,x][0, x][0,x] 内的奇数个数为 ⌈x2⌉\left\lceil \dfrac{x}{2} \right\rceil⌈
2
x
​
 ⌉。

位于区间 [0,10)[0, 10)[0,10) 的奇数和偶数的个数都是 555 个。

我们将 num\textit{num}num 表示为 10×y+x10 \times y + x10×y+x 的形式，其中 0≤x<100 \le x \lt 100≤x<10 且 y≥0y \ge 0y≥0，那么位于区间 [0,num][0, \textit{num}][0,num] 的整数可以分为两个部分：

区间 [10×y+0,10×y+x][10 \times y + 0, 10 \times y + x][10×y+0,10×y+x]：

如果 yyy 的各位数字之和为偶数，那么该区间内各位数字之和为偶数的整数个数为 ⌊x2⌋+1\left\lfloor \dfrac{x}{2} \right\rfloor + 1⌊
2
x
​
 ⌋+1；

如果 yyy 的各位数字之和为奇数，那么该区间内各位数字之和为偶数的整数个数为 ⌈x2⌉\left\lceil \dfrac{x}{2} \right\rceil⌈
2
x
​
 ⌉。

区间 [0,10×y+0)[0, 10 \times y + 0)[0,10×y+0)：

注意到该区间的数可以表示为 10×t+g10 \times t + g10×t+g 的形式，其中 0≤t<y0 \le t \lt y0≤t<y 且 0≤g<100 \le g \lt 100≤g<10。固定住 ttt 时，如果 ttt 的各位数字之和为偶数，那么 ggg 为偶数的取值数目为 555，奇数时类似，因此该区间内的各位数字之和为偶数的整数个数为 y×5y \times 5y×5。

注意到上述区间中我们多计入了整数 000，因此结果应该是位于上述区间且各位数字之和为偶数的个数减 111。

Python3
C++
Java
C#
C
JavaScript
Golang


作者：力扣官方题解
链接：https://leetcode.cn/problems/count-integers-with-even-digit-sum/solutions/2045888/tong-ji-ge-wei-shu-zi-zhi-he-wei-ou-shu-rvqol/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int countEvenLC(int num) {
        int y = num / 10, x = num % 10;
        int res = y * 5, ySum = 0;
        while (y != 0) {
            ySum += y % 10;
            y /= 10;
        }
        if (ySum % 2 == 0) {
            res += x / 2 + 1;
        } else {
            res += (x + 1) / 2;
        }
        return res - 1;
    }

}
