package LC;

public class LC88Merge {
    public static void main(String[] args) {
        LC88Merge l = new LC88Merge();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        nums1 = new int[]{2, 0};
        m = 1;
        nums2 = new int[]{1};
        n = 1;
        l.merge(nums1, m, nums2, n);

        for (int i :
                nums1) {
            System.out.print(i + ",");
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n < 1) {
            return;
        }
        if (m < 1) {
            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        m--;
        n--;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (nums1[m] > nums2[n]) {
                nums1[i] = nums1[m];
                m--;
            } else {
                nums1[i] = nums2[n];
                n--;
            }
            if (n < 0) {
                return;
            }
            if (m < 0) {
                for (int j = 0; j <= n; j++) {
                    nums1[j] = nums2[j];
                }
                return;
            }
        }
        return;

    }
}
