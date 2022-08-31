package LC._undo;

import LC._TreeNode.TreeNode;

import java.util.*;

public class LC998insertIntoMaxTree {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tmpNode = queue.poll();
            if (val > tmpNode.val) {
                TreeNode node = new TreeNode(val, root, root.right);
                root = node;
                break;
            }

        }

        return root;
    }
}
