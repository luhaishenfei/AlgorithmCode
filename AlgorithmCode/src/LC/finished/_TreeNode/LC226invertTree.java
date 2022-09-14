package LC.finished._TreeNode;

/*
翻转二叉树
 */
public class LC226invertTree {
    public static void main(String[] args) {

    }


    public TreeNode invertTree(TreeNode root) {
        invertTreeDG(root);
        return root;
    }

    void invertTreeDG(TreeNode root){
        if (root==null) return;
        if (root.left==null&&root.right==null) return;
        TreeNode tmpNode=root.left;
        root.left=root.right;
        root.right=tmpNode;
        invertTree(root.left);
        invertTree(root.right);
    }

    public TreeNode invertTreeLCDG(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTreeLCDG(root.left);
        TreeNode right = invertTreeLCDG(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

}
