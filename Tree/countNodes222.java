public class countNodes222 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    //
//    public int countNodes(TreeNode root) {
//        if(root == null){
//            return 0;
//        }
//        int left = countLevel(root.left);
//        int right = countLevel(root.right);
//        if(left == right){
//            return countNodes(root.right) + (1<<left);
//        }else{
//            return countNodes(root.left) + (1<<right);
//        }
//    }
//    private int countLevel(TreeNode root){
//        int level = 0;
//        while(root != null){
//            level++;
//            root = root.left;
//        }
//        return level;
//    }


}
