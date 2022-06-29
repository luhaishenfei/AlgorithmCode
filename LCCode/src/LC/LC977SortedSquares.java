package LC;

public class LC977SortedSquares {

    public static void main(String[] args) {
        LC977SortedSquares l = new LC977SortedSquares();
        int[] res=l.sortedSquares(new int[]{-2, -1, 0, 1, 2});
        for (int i :
                res) {
            System.out.print(i+",");
        }
    }

    public int[] sortedSquares(int[] nums) {

        int left=0;
        int right=nums.length-1;

        int[] squares=new int[nums.length];
        int index=right;

        while (left<=right){
            int l=nums[left];
            int r=nums[right];
            if (l<0){
                 l=-l;
            }
            if (r<0){
                r=-r;
            }
            if (l<r){
                squares[index--]=r*r;
                right--;
            }else {
                squares[index--]=l*l;
                left++;
            }
        }
        return squares;
    }

    public int[] sortedSquaresLC(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j;) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                ans[pos] = nums[i] * nums[i];
                ++i;
            } else {
                ans[pos] = nums[j] * nums[j];
                --j;
            }
            --pos;
        }
        return ans;
    }

}
