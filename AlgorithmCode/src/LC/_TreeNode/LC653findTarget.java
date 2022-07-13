package LC._TreeNode;

import java.util.*;

/*
653. 两数之和 IV - 输入 BST
给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
示例 1：
输入: root = [5,3,6,2,4,null,7], k = 9
输出: true
示例 2：
输入: root = [5,3,6,2,4,null,7], k = 28
输出: false
提示:
二叉树的节点个数的范围是  [1, 104].
-104 <= Node.val <= 104
root 为二叉搜索树
-105 <= k <= 105
 */
public class LC653findTarget {


    //LC 递归//speed spiked  my method,memory better than my method
    /*
    执行用时：
2 ms
, 在所有 Java 提交中击败了
95.43%
的用户
内存消耗：
41.4 MB
, 在所有 Java 提交中击败了
90.89%
的用户
通过测试用例：
422 / 422
     */
    Set<Integer> set = new HashSet<Integer>();

    public boolean findTargetLC(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return findTargetLC(root.left, k) || findTargetLC(root.right, k);
    }

    //LC2 Just so so,but still better than mine
    /*
    执行用时：
3 ms
, 在所有 Java 提交中击败了
44.76%
的用户
内存消耗：
41.8 MB
, 在所有 Java 提交中击败了
58.04%
的用户
通过测试用例：
422 / 422
     */
    public boolean findTargetLC2(TreeNode root, int k) {
        Set<Integer> set = new HashSet<Integer>();
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (set.contains(k - node.val)) {
                return true;
            }
            set.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return false;
    }

    /*
    //速度确实降了，但也才一点点，空间差距不大
    执行用时：
463 ms
, 在所有 Java 提交中击败了
5.34%
的用户
内存消耗：
42.1 MB
, 在所有 Java 提交中击败了
21.42%
的用户
通过测试用例：
422 / 422
     */
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(root.val, k - root.val);

        Deque<TreeNode> stackLeft = new LinkedList<TreeNode>();
        Deque<TreeNode> stackRight = new LinkedList<TreeNode>();

        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        while (!stackLeft.isEmpty() || !stackRight.isEmpty() || leftNode != null || rightNode != null) {
            while (leftNode != null) {
                stackLeft.push(leftNode);
                if (map.containsValue(leftNode.val)) {
                    return true;
                }
                map.put(leftNode.val, k - leftNode.val);
                leftNode = leftNode.left;
            }
            if (!stackLeft.isEmpty()) {
                leftNode = stackLeft.pop();
                leftNode = leftNode.right;
            }

            while (rightNode != null) {
                stackRight.push(rightNode);
                if (map.containsValue(rightNode.val)) {
                    return true;
                }
                map.put(rightNode.val, k - rightNode.val);
                rightNode = rightNode.right;
            }
            if (!stackRight.isEmpty()) {
                rightNode = stackRight.pop();
                rightNode = rightNode.left;
            }
        }
        return false;
    }


    /*
    //一开始思路是向右中序遍历，实际上左右都一样，下一步用双指针优化
    执行用时：
540 ms
, 在所有 Java 提交中击败了
5.34%
的用户
内存消耗：
42.6 MB
, 在所有 Java 提交中击败了
5.80%
的用户
通过测试用例：
422 / 422
     */
    public boolean findTarget1(TreeNode root, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        //中序遍历 向右
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                if (map.containsValue(root.val)) {
                    return true;
                }
                map.put(root.val, k - root.val);
                root = root.right;
            }
            root = stack.pop();
            root = root.left;
        }
        return false;
    }
}
