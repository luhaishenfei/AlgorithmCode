package LC._TreeNode;

/*
给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。

注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。

 

示例 1：


输入：root = [4,2,7,1,3], val = 5
输出：[4,2,7,1,3,5]
解释：另一个满足题目要求可以通过的树是：

示例 2：

输入：root = [40,20,60,10,30,50,70], val = 25
输出：[40,20,60,10,30,50,70,null,null,25]
示例 3：

输入：root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
输出：[4,2,7,1,3,5]
提示：
树中的节点数将在[0,104]的范围内。
-108<= Node.val <= 108
所有值Node.val是 独一无二 的。
-108<= val <= 108
保证val在原始BST中不存在。

 */
public class LC701insertIntoBST {
    public static void main(String[] args) {
        LC701insertIntoBST l = new LC701insertIntoBST();
        TreeNode res = l.insertIntoBST(null, 5);
        System.out.println(res.val);
    }

    /*
    执行结果：
通过
显示详情
添加备注

执行用时：
0 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗：
41.9 MB
, 在所有 Java 提交中击败了
77.60%
的用户
通过测试用例：
35 / 35
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        TreeNode currentN = root;
        while (currentN != null) {
            if (currentN.val > val) {
                if (currentN.left == null) {
                    currentN.left = new TreeNode(val);
                    break;
                } else {
                    currentN = currentN.left;
                }
            }
            if (currentN.val < val) {
                if (currentN.right == null) {
                    currentN.right = new TreeNode(val);
                    break;
                } else {
                    currentN = currentN.right;
                }
            }
        }
        currentN = new TreeNode(val);
        return root;
    }

    /*
    执行结果：
通过
显示详情
添加备注

执行用时：
0 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗：
42.1 MB
, 在所有 Java 提交中击败了
47.96%
的用户
通过测试用例：
35 / 35
     */
    public TreeNode insertIntoBSTdg(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        insertIntoBSTDG(root, val);
        return root;
    }

    public void insertIntoBSTDG(TreeNode root, int val) {
        if (root.val > val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else {
                insertIntoBSTDG(root.left, val);

            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else {
                insertIntoBSTDG(root.right, val);
            }
        }

    }
}
