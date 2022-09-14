package LC.finished;

public class LC868BinaryGap {
    public static void main(String[] args) {
        LC868BinaryGap l = new LC868BinaryGap();
        System.out.println(l.binaryGap(22));
//        Integer.toBinaryString(1);
    }

    public int binaryGap(int n) {
//         String binaryStr = Integer.toBinaryString(n);
        String binaryStr = "";
        while (n != 0) {
            binaryStr = binaryStr + n % 2;
            n = n / 2;
        }
        int lastIdx = -1;
        int longest = 0;
        for (int i = 0; i < binaryStr.length(); i++) {
            if (binaryStr.charAt(i) == '1') {
                if (lastIdx != -1 && i - lastIdx > longest) {
                    longest = i - lastIdx;
                }
                lastIdx = i;
            }
        }
        return longest;
    }
    /*
        执行用时：
8 ms
, 在所有 Java 提交中击败了
5.77%
的用户
内存消耗：
39.2 MB
, 在所有 Java 提交中击败了
5.25%
的用户
         */

    public int binaryGapLC(int n) {
        int last = -1, ans = 0;
        for (int i = 0; n != 0; ++i) {
            if ((n & 1) == 1) {
                if (last != -1) {
                    ans = Math.max(ans, i - last);
                }
                last = i;
            }
            n >>= 1;
        }
        return ans;
    }

}
