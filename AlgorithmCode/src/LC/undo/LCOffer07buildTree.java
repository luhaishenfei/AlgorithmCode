package LC.undo;

import LC.finished._TreeNode.TreeNode;

public class LCOffer07buildTree {

    /*
    //Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    //Output: [3,9,20,null,null,15,7]

    3,
  9,

              1,
           2,          3,
       4,    5,     6,   7,
      8,9,  10
    pre[1,2,3,4,5,6,7,8,9,10]
    in[8,4,9,2,10,5,1,6,3,7]
     */

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return getNode(preorder,inorder,preorder[0],0,inorder.length-1);
    }


    private int getTarget(int[] arr,int target ){

        //idx
        return 0;
    }

    private TreeNode getNode(int[] preorder, int[] inorder, int v,int start, int end){
        TreeNode root=new TreeNode(v);
        int idx = getTarget(inorder, v);
        root.left= getNode(preorder,inorder,v,start,idx-1);
        root.right=getNode(preorder,inorder,v,idx+1, end);
//        TreeNode tmp=new TreeNode(preorder[p]);
//        if (inorder[i]==preorder[p]){
//            tmp.left = null;
//        }else {
//            tmp.left=new TreeNode(preorder[p]);
//
//        }
        return root;



    }

}
