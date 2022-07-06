package LC.TreeNode;

/*
给你二叉树的根节点root 和一个表示目标和的整数targetSum 。
判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。
如果存在，返回 true ；否则，返回 false 。

叶子节点 是指没有子节点的节点。

 */
public class LC112hasPathSum {


    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.val == targetSum && root.left == null && root.right == null) {
            return true;
        }
        if (hasPathSumDG(root.left, root.val, targetSum)) {
            return true;
        }
        if (hasPathSumDG(root.right, root.val, targetSum)) {
            return true;
        }
        return false;
    }



    /*
    执行用时：
0 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗：
41.5 MB
, 在所有 Java 提交中击败了
19.56%
的用户
通过测试用例：
117 / 117
     */
    public boolean hasPathSumDG(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.val == targetSum && root.left == null && root.right == null) {
            return true;
        }
        if (hasPathSumDG(root.left, root.val, targetSum)) {
            return true;
        }
        if (hasPathSumDG(root.right, root.val, targetSum)) {
            return true;
        }
        return false;
    }

    boolean hasPathSumDG(TreeNode root, int currentSum, int targetSum) {
        if (root == null) return false;
        currentSum = root.val + currentSum;
        if (root.left == null & root.right == null & currentSum == targetSum) {
            return true;
        }
        if (hasPathSumDG(root.left, currentSum, targetSum)) {
            return true;
        }
        if (hasPathSumDG(root.right, currentSum, targetSum)) {
            return true;
        }
        return false;
    }

    //
    public boolean hasPathSumLC(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSumLC(root.left, sum - root.val) || hasPathSumLC(root.right, sum - root.val);
    }
}
