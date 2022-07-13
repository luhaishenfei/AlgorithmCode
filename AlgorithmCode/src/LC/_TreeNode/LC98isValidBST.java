package LC._TreeNode;

import java.util.Deque;
import java.util.LinkedList;

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
    //[1,null,1]
    public static void main(String[] args) {
        LC98isValidBST l = new LC98isValidBST();
        TreeNode t1 = new TreeNode(1, null, new TreeNode(1));
        l.isValidBSTDG(t1);

    }


    //中序遍历
    public boolean isValidBSTLCInorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }


    /*
    //速度内存差不多，但是写的简洁
    执行用时：
0 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗：
41.2 MB
, 在所有 Java 提交中击败了
12.21%
的用户
通过测试用例：
80 / 8
     */
    double last = -Double.MAX_VALUE;

    public boolean isValidBSTLC(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isValidBSTLC(root.left)) {
            if (last < root.val) {
                last = root.val;
                return isValidBSTLC(root.right);
            }
        }
        return false;
    }


    //my version  that LC plus it.
    /*
    执行结果：
通过
显示详情
添加备注

执行用时：
0 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗：
41.3 MB
, 在所有 Java 提交中击败了
9.88%
的用户
通过测试用例：
80 / 80
     */
    public boolean isValidBSTLC2(TreeNode root) {
        return isValidBSTLC2(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBSTLC2(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBSTLC2(node.left, lower, node.val) && isValidBSTLC2(node.right, node.val, upper);
    }


    /*
    执行用时：
0 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗：
41.3 MB
, 在所有 Java 提交中击败了
7.21%
的用户
通过测试用例：
80 / 80
     */
    public boolean isValidBSTDG(TreeNode root) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return true;
        if (root.left == null) {
            if (root.right.val > root.val) {
                return isValidDG(root.right, root.val, Integer.MAX_VALUE);
            } else {
                return false;
            }
        }

        if (root.right == null) {
            if (root.left.val < root.val) {
                return isValidDG(root.left, Integer.MIN_VALUE, root.val);
            } else {
                return false;
            }
        }

        if (root.left.val >= root.val || root.right.val <= root.val) {
            return false;
        }

        return isValidDG(root.right, root.val, 2147483648l) && isValidDG(root.left, -2147483649l, root.val);
    }


    public boolean isValidDG(TreeNode root, long minValue, long maxValue) {
        if (root.left == null && root.right == null) return true;
        if (root.left == null) {
            if (root.right.val <= root.val || root.right.val <= minValue || root.right.val >= maxValue) {
                return false;
            }
            return isValidDG(root.right, Math.max(root.val, minValue), maxValue);
        }
        if (root.right == null) {
            if (root.left.val >= root.val || root.left.val <= minValue || root.left.val >= maxValue) {
                return false;
            }
            return isValidDG(root.left, minValue, root.val);
        }
        if (root.left.val >= root.val || root.left.val <= minValue || root.left.val >= maxValue
                || root.right.val <= root.val || root.right.val <= minValue || root.right.val >= maxValue) {
            return false;
        }
        return isValidDG(root.right, Math.max(root.val, minValue), maxValue) && isValidDG(root.left, minValue, root.val);
    }
}
