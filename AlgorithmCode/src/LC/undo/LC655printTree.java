//给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，用以表示树的 格式化布局 。构造此格式化布局矩
//阵需要遵循以下规则：
//
//
// 树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。
// 矩阵的列数 n 应该等于 2ʰᵉⁱᵍʰᵗ⁺¹ - 1 。
// 根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。
// 对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2ʰᵉⁱᵍʰᵗ⁻ʳ⁻¹] ，右子节点放置在
//res[r+1][c+2ʰᵉⁱᵍʰᵗ⁻ʳ⁻¹] 。
// 继续这一过程，直到树中的所有节点都妥善放置。
// 任意空单元格都应该包含空字符串 "" 。
//
//
// 返回构造得到的矩阵 res 。
//
//
//
//
//
// 示例 1：
//
//
//输入：root = [1,2]
//输出：
//[["","1",""],
// ["2","",""]]
//
//
// 示例 2：
//
//
//输入：root = [1,2,3,null,4]
//输出：
//[["","","","1","","",""],
// ["","2","","","","3",""],
// ["","","4","","","",""]]
//
//
//
//
// 提示：
//
//
// 树中节点数在范围 [1, 2¹⁰] 内
// -99 <= Node.val <= 99
// 树的深度在范围 [1, 10] 内
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 205 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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


    public List<List<String>> printTree(TreeNode root) {
        List<Integer>  valList=new LinkedList<>();



        return null;
    }

    public List<String> addNode(List<String> list,TreeNode node){
        list.add(node.val+"");
        return null;
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

    public List<List<String>> printTreeO(TreeNode root) {
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
