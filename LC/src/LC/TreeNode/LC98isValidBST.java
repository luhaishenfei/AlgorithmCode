package LC.TreeNode;

/*
98. 验证二叉搜索树
给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。

有效 二叉搜索树定义如下：

节点的左子树只包含 小于 当前节点的数。
节点的右子树只包含 大于 当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。


示例 1：


输入：root = [2,1,3]
输出：true
示例 2：


输入：root = [5,1,4,null,null,3,6]
输出：false
解释：根节点的值是 5 ，但是右子节点的值是 4 。


提示：

树中节点数目范围在[1, 104] 内
-231 <= Node.val <= 231 - 1
 */
public class LC98isValidBST {


    //[5,1,4,null,null,3,6]
    public boolean isValidBST(TreeNode root) {
        if (root.left == null && root.right == null) return true;
        if (root.left == null) {
            if (root.right.val > root.val) {
                return isValidBSTDG(root.right, root.val, false);
            } else {
                return false;
            }
        }
        if (root.right == null) {
            if (root.left.val < root.val) {
                return isValidBSTDG(root.left, root.val, true);
            } else {
                return false;
            }
        }
        if (root.left.val < root.val && root.right.val > root.val) {
            return isValidBSTDG(root.left, root.val, true) && isValidBSTDG(root.right, root.val, false);
        }else {
            return false;
        }
    }

    boolean isValidBSTDG(TreeNode root, int lastVal, boolean isLeft) {
        if (root.left == null && root.right == null) {
            return true;
        }

        if (root.left == null) {
            if (isLeft) {
                if (root.right.val > lastVal) return false;
            }
            if (root.right.val < root.val) return false;
            return isValidBSTDG(root.right, root.val, false);
        }
        if (root.right == null) {
            if (!isLeft) {
                if (root.left.val < lastVal) return false;
            }
            if (root.left.val > root.val) return false;
            return isValidBSTDG(root.left, root.val, true);
        }
        if (root.left.val<root.val&&root.right.val>root.val){
            return isValidBSTDG(root.left, root.val, true) && isValidBSTDG(root.right, root.val, false);
        }else {
            return false;
        }

    }
}
