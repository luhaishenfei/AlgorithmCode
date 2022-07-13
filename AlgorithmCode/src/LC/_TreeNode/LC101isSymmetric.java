package LC._TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
对称二叉树
 */
public class LC101isSymmetric {
    public static void main(String[] args) {
        //[1,2,2,3,4,4,3]
    /*
                1
        2               2
    3        4      4           3

     */

        TreeNode n7 = new TreeNode(3);
        TreeNode n6 = new TreeNode(4);
        TreeNode n5 = new TreeNode(4);
        TreeNode n4 = new TreeNode(3);
        TreeNode n3 = new TreeNode(2, n6, n7);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n1 = new TreeNode(1, n2, n3);

        LC101isSymmetric l = new LC101isSymmetric();
        System.out.println(l.isSymmetricDG(n1));
    }


    //迭代
    /*
    执行用时：
1 ms
, 在所有 Java 提交中击败了
22.55%
的用户
内存消耗：
39.7 MB
, 在所有 Java 提交中击败了
37.66%
的用户
通过测试用例：
198 / 198
     */

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> list= new LinkedList();
        if (root==null) return true;
        list.add(root.left);
        list.add(root.right);
        TreeNode n1;
        TreeNode n2;
        while (!list.isEmpty()){
            n1=list.poll();
            n2=list.poll();
            if (n1==null&n2==null){
            }else if (n1==null||n2==null){
                return false;
            }else if(n1.val!=n2.val){
                return false;
            }else {
                list.offer(n1.left);
                list.offer(n2.right);
                list.offer(n1.right);
                list.offer(n2.left);
            }
        }
        return true;
    }

    //递归
    /*
    执行用时：
1 ms
, 在所有 Java 提交中击败了
22.55%
的用户
内存消耗：
39.5 MB
, 在所有 Java 提交中击败了
67.08%
的用户
通过测试用例：
198 / 198
     */
    public boolean isSymmetricDG(TreeNode root) {
        return isSymmetricDG(root.left, root.right);
    }

    public boolean isSymmetricDG(TreeNode lNode, TreeNode rNode) {
        if (lNode == null && rNode == null) {
            return true;
        }
        try {
            if (lNode.val == rNode.val) {
                return isSymmetricDG(lNode.left, rNode.right) && isSymmetricDG(lNode.right, rNode.left) ? true : false;
            }
        } catch (Exception e) {
            return false;

        }
        return false;

    }


    /*
    执行用时：
    0 ms
    , 在所有 Java 提交中击败了
    100.00%
    的用户
    内存消耗：
    39.5 MB
    , 在所有 Java 提交中击败了
    66.57%
    的用户
    通过测试用例：
    198 / 198
     */
    public boolean isSymmetricLCDG(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }


}
