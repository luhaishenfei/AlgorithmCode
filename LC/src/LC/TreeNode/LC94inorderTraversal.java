package LC.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//中序
public class LC94inorderTraversal {

    public static void main(String[] args) {

        TreeNode t7 = new TreeNode(7);
        TreeNode t6 = new TreeNode(6);
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3, t6, t7);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t1 = new TreeNode(1, t2, t3);
        LC94inorderTraversal l = new LC94inorderTraversal();
        l.inorderTraversal(t1);
        System.out.println(l.list);
        l.inorderTraversalLC(t1);
    }

    List<Integer> list = new ArrayList();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorderT(root);
        return list;

    }

    void inorderT(TreeNode node) {
        if (node == null) return;
        inorderT(node.left);
        list.add(node.val);
        inorderT(node.right);
    }

    //迭代
    public List<Integer> inorderTraversalDD(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        return null;
    }











    public List<Integer> inorderTraversalLC(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }


}
