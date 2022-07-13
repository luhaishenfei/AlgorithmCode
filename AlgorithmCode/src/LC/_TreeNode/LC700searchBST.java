package LC._TreeNode;

public class LC700searchBST {
/*
给定二叉搜索树（BST）的根节点 root 和一个整数值 val。

你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。



示例 1:



输入：root = [4,2,7,1,3], val = 2
输出：[2,1,3]
Example 2:


输入：root = [4,2,7,1,3], val = 5
输出：[]

 */

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        return null;

    }

/*
执行用时：
0 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗：
42.1 MB
, 在所有 Java 提交中击败了
7.05%
的用户
通过测试用例：
36 / 36
 */
    public TreeNode searchBSTDG(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        TreeNode res = searchBSTDG(root.left, val);
        return res == null ? searchBSTDG(root.right, val) : res;
    }
}
