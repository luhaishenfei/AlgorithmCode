package LC.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
513. 找树左下角的值
给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。

假设二叉树中至少有一个节点。



示例 1:



输入: root = [2,1,3]
输出: 1
示例 2:



输入: [1,2,3,4,null,5,6,null,null,7]
输出: 7


提示:

二叉树的节点个数的范围是 [1,104]
-231 <= Node.val <= 231 - 1
 */
public class LC513findBottomLeftValue {

    public static void main(String[] args) {
        LC513findBottomLeftValue l = new LC513findBottomLeftValue();

        TreeNode n7 = new TreeNode(7);
        TreeNode n6 = new TreeNode(6);
        TreeNode n5 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3, n6, n7);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n1 = new TreeNode(1, n2, n3);

        System.out.println(l.findBottomLeftValueLC(n1));
    }

    /*
    执行用时：
2 ms
, 在所有 Java 提交中击败了
15.19%
的用户
内存消耗：
41.5 MB
, 在所有 Java 提交中击败了
5.14%
的用户
通过测试用例：
76 / 76
     */
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> stk = new LinkedList();
        TreeNode leftestNode = null;
        stk.offer(root);
        while (!stk.isEmpty()) {
            leftestNode = null;
            int stkSize = stk.size();
            for (int i = 0; i < stkSize; i++) {
                TreeNode node = stk.poll();
                if (leftestNode == null) {
                    leftestNode = node;
                }
                if (node.left != null) {
                    stk.offer(node.left);
                }
                if (node.right != null) {
                    stk.offer(node.right);
                }
            }
        }
        return leftestNode.val;
    }





    public int findBottomLeftValueLC(TreeNode root) {
        int ret = 0;
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            //从右边往左边加
            if (p.right != null) {
                queue.offer(p.right);
            }
            if (p.left != null) {
                queue.offer(p.left);
            }
            ret = p.val;
        }
        return ret;
    }

}
