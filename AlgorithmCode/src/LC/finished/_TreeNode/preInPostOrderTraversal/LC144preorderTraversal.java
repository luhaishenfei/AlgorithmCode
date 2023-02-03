package LC.finished._TreeNode.preInPostOrderTraversal;

import LC.finished._TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

//前序
public class LC144preorderTraversal {
    public static void main(String[] args) {

        TreeNode t7 = new TreeNode(7);
        TreeNode t6 = new TreeNode(6);
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3, t6, t7);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t1 = new TreeNode(1, t2, t3);
        LC144preorderTraversal l =new LC144preorderTraversal();
        List<Integer> list = l.preorderTraversal(t1);
        System.out.println(list);
    }

    List list = new ArrayList();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return list;

        list.add(root.val);

        if (root.left != null) {
            preorderTraversal(root.left);
        }
        if (root.right != null) {
            preorderTraversal(root.right);
        }
        return list;
    }




    //Morris遍历
    public List<Integer> preorderTraversalLC(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        TreeNode p1 = root, p2 = null;

        while (p1 != null) {
            p2 = p1.left;
            if (p2 != null) {
                while (p2.right != null && p2.right != p1) {
                    p2 = p2.right;
                }
                if (p2.right == null) {
                    res.add(p1.val);
                    p2.right = p1;
                    p1 = p1.left;
                    continue;
                } else {
                    p2.right = null;
                }
            } else {
                res.add(p1.val);
            }
            p1 = p1.right;
        }
        return res;
    }


}
