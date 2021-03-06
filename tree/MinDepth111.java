public class MinDepth111 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public int minDepth(TreeNode  root){
        if (root ==null )  return  0;
        else if (root.left!=null&&root.right!=null){
            return Math.min(minDepth(root.left),minDepth(root.right))+1;
        }else
            return Math.max(minDepth(root.left),minDepth(root.right))+1;

    }
}
