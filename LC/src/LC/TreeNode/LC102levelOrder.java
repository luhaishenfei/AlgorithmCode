package LC.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//层序遍历
public class LC102levelOrder {
    public static void main(String[] args) {
        TreeNode t7 = new TreeNode(7);
        TreeNode t6 = new TreeNode(6);
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3, t6, t7);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t1 = new TreeNode(1, t2, t3);

        LC102levelOrder l = new LC102levelOrder();
        l.levelOrder(t1);
    }

    /*
    执行用时：
1 ms
, 在所有 Java 提交中击败了
60.70%
的用户
内存消耗：
41.5 MB
, 在所有 Java 提交中击败了
45.02%
的用户
通过测试用例：
34 / 34
炫耀一下:
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> stk = new LinkedList();
        LinkedList<TreeNode> stkCache = new LinkedList();
        stk.offer(root);
        while (root != null || !stk.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while (!stk.isEmpty()) {
                root = stk.pop();
                if (root != null) {
                    list.add(root.val);
                    stkCache.offer(root.left);
                    stkCache.offer(root.right);
                }
            }
            if (list.size()!=0){
                res.add(list);
            }
            stk=stkCache;
            stkCache=new LinkedList<>();
        }
        return res;
    }




/*
执行用时：
1 ms
, 在所有 Java 提交中击败了
60.70%
的用户
内存消耗：
41.4 MB
, 在所有 Java 提交中击败了
52.38%
的用户
 */
    public List<List<Integer>> levelOrderLC(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }

}
