package LC.finished._TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LC104maxDepth {
    public static void main(String[] args) {
        TreeNode t7 = new TreeNode(7);
        TreeNode t6 = new TreeNode(6);
        TreeNode t3 = new TreeNode(3, null, t7);
        TreeNode t2 = new TreeNode(2 ,t6 ,null);
        TreeNode t1 = new TreeNode(1, t2, t3);
        LC104maxDepth l = new LC104maxDepth();
        l.maxDepth(t1);
    }
/*
              1
      2               3
  4      null     null         7

[1,2,3,4,null,null,5]
 */

    public int maxDepth(TreeNode root) {
        int maxDepth=0;
        Deque<TreeNode> stk = new LinkedList();
        if (root==null){
            return 0;
        }else {
            stk.offer(root);
        }
        while (!stk.isEmpty()){
            int currentStkSize=stk.size();
            for (int i = 0; i < currentStkSize; i++) {
                root=stk.poll();
                if (root.left!=null){
                    stk.offer(root.left);
                }
                if (root.right!=null){
                    stk.offer(root.right);
                }
            }
            maxDepth++;
        }
        return maxDepth;
    }


    public int maxDepthLC(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }



    public int maxDepthLCMorris(TreeNode root) {
        if (root == null) return 0;
        TreeNode pre = null;
        int depth = 1;
        int maxDepth = Integer.MIN_VALUE;
        while (root != null) {
            if ((pre = root.left) != null) {
                int n = 1;
                while (pre.right != null && pre.right != root) {
                    pre = pre.right;
                    n++;
                }
                if (pre.right == null) {
                    maxDepth = Math.max(maxDepth, depth);
                    pre.right = root;
                    root = root.left;
                    depth++;
                } else {
                    pre.right = null;
                    root = root.right;
                    depth = depth - n;
                }
            } else {
                maxDepth = Math.max(maxDepth, depth);
                root = root.right;
                depth++;
            }
        }
        return maxDepth;
    }
}
