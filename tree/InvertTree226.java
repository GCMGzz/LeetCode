public class InvertTree226 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode invertTree(TreeNode root) {
        swap(root);
        return root;
    }
    public  void swap(TreeNode root){
        if (root == null ){return ;}
        TreeNode temp=new TreeNode(0) ;
        temp= root.left;
        root.left= root.right;
        root.right = temp;
        swap(root.left);
        swap(root.right);
    }
//    public TreeNode invertTree(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        TreeNode left = invertTree(root.left);
//        TreeNode right = invertTree(root.right);
//        root.left = right;
//        root.right = left;
//        return root;
//    }


}
