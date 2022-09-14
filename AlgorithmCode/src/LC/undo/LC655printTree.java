package LC.undo;

import LC.finished._TreeNode.TreeNode;

import java.util.*;

public class LC655printTree {

    public static void main(String[] args) {
        LC655printTree l = new LC655printTree();

        TreeNode n13 = new TreeNode(13);
        TreeNode n6 = new TreeNode(6, n13, null);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2, null, n6);
        TreeNode n1 = new TreeNode(1, n3, n4);
        TreeNode n0 = new TreeNode(0, n1, n2);
        l.printTree(n0);

    }


    public int maxDepth(TreeNode root) {
        int maxDepth = 0;
        Deque<TreeNode> stk = new LinkedList();
        if (root == null) {
            return 0;
        } else {
            stk.offer(root);
        }
        while (!stk.isEmpty()) {
            int currentStkSize = stk.size();
            for (int i = 0; i < currentStkSize; i++) {
                root = stk.poll();
                if (root.left != null) {
                    stk.offer(root.left);
                }
                if (root.right != null) {
                    stk.offer(root.right);
                }
            }
            maxDepth++;
        }
        return maxDepth;
    }


    class TreeNodeWithPosition {
        int v;
        int w;
        int h;

        TreeNodeWithPosition(int v, int w, int h) {
            this.v = v;
            this.h = h;
            this.w = w;
        }
    }

    public List<List<String>> printTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNodeWithPosition> queue = new LinkedList();
        Queue<TreeNode> qTreeNode=new LinkedList<>();
        int height = maxDepth(root) - 1;
        int width = (int) Math.pow(2, height + 1) - 1;
        queue.offer(new TreeNodeWithPosition(root.val, (width - 1) / 2, 0));
        while (!qTreeNode.isEmpty()) {
            TreeNode node = qTreeNode.poll();
            qTreeNode.offer(node.left);
            qTreeNode.offer(node.right);
//            queue.offer(new TreeNodeWithPosition);



        }

//            queue.offer(new TreeNodeWithPosition())

        return null;
    }


    public List<List<String>> printTree1(TreeNode root) {
        int height = maxDepth(root) - 1;
        int width = (int) Math.pow(2, height + 1) - 1;
        List<List<String>> res = new ArrayList();
        for (int i = 0; i < height; i++) {
            List<String> l = new ArrayList();
            for (int j = 0; j < width; j++) {
                if (i ==0)
                    l.add("");


            }


        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<Integer[]> tmpList = new ArrayList<>();

        int position = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                tmpList.add(new Integer[]{position, node.val});
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                queue.offer(null);
                queue.offer(null);
            }
            position++;
        }


        List<String> list = new ArrayList();


        return null;
    }
}
