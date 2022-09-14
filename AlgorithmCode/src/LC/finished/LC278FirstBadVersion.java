package LC.finished;

public class LC278FirstBadVersion {

    public static void main(String[] args) {
        LC278FirstBadVersion l = new LC278FirstBadVersion();
        System.out.println(l.firstBadVersion(2126753390));
    }

    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        boolean isGet = false;

        while (!isGet) {
            int mid = ( high-low) / 2+low;
            if (isBadVersion(mid)) {
                if (!isBadVersion(--mid)) {
                    return mid + 1;
                } else {
                    high = --mid;
                }
            } else {
                if (isBadVersion(++mid)) {
                    return mid;
                } else {
                    low = ++mid;
                }
            }
        }
        return -1;
    }

    private boolean isBadVersion(int i) {
        if (i >= 1702766719) return true;
        else return false;
    }

    /*
      public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) { // 循环直至区间左右端点相同
            int mid = left + (right - left) / 2; // 防止计算时溢出
            if (isBadVersion(mid)) {
                right = mid; // 答案在区间 [left, mid] 中
            } else {
                left = mid + 1; // 答案在区间 [mid+1, right] 中
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;
    }

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/first-bad-version/solution/di-yi-ge-cuo-wu-de-ban-ben-by-leetcode-s-pf8h/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
