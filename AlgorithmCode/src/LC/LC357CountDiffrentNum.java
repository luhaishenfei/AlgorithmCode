package LC;

public class LC357CountDiffrentNum {

    public static void main(String[] args) {
        LC357CountDiffrentNum l=new LC357CountDiffrentNum();
        System.out.println(l.countNumbersWithUniqueDigits(4));
    }

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 10;
        } else {
            int sum=9;

            int nums=9;
            for (int i = 0; i < n-1; i++) {
                sum=sum*nums--;
            }
            sum+=countNumbersWithUniqueDigits(n-1);
            return sum;
        }

    }
    /*
    class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        int res = 10, cur = 9;
        for (int i = 0; i < n - 1; i++) {
            cur *= 9 - i;
            res += cur;
        }
        return res;
    }
}

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/count-numbers-with-unique-digits/solution/tong-ji-ge-wei-shu-zi-du-bu-tong-de-shu-iqbfn/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
