package LC.finished._TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//后序
public class LC145postorderTraversal {
    public static void main(String[] args) {

        TreeNode t7 = new TreeNode(7);
        TreeNode t6 = new TreeNode(6);
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3, t6, t7);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t1 = new TreeNode(1, t2, t3);

        LC145postorderTraversal l = new LC145postorderTraversal();
        l.postorderTraversalDD(t1);
    }


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderTraversalDG(root,res);
        return res;
    }

    //递归
    void postorderTraversalDG(TreeNode root, List res) {
        if (root==null) return;
        postorderTraversalDG(root.left,res);
        postorderTraversalDG(root.right,res);
        res.add(root.val);
    }


    public List<Integer> postorderTraversalDD(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk=new LinkedList();
        while (root!=null||!stk.isEmpty()){
            while (root!=null){
                stk.push(root);
                root=root.left;
            }
            root=stk.pop();
            if (root.right==null) {
                res.add(root.val);
                stk.pop();
            }else {
                root = root.right;
            }

        }


        return res;
    }

}
