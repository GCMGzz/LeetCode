import java.util.ArrayDeque;
import java.util.Queue;

/* *
112
* */
public class PathSum {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public boolean hasPathSum(TreeNode root, int sum) {

        //1 DFS
//        if (root == null) {
//            return false;
//        }
//        if (root.left == null && root.right == null) {
//            return root.val == sum;
//        }
//        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);


        //2 BFS
        Queue<TreeNode> nowNode = new ArrayDeque<>();
        Queue<Integer> nowVal = new ArrayDeque<>();
        if (root == null) return false;
        nowNode.add(root);
        nowVal.add(root.val);
        while (!nowNode.isEmpty()) {
            TreeNode node = nowNode.poll();
            int temp = nowVal.poll();
            if (node.left == null && node.right == null) {
                if( temp == sum)  {return  true;}
                continue;
            }
            if (node.left != null) {
                nowNode.add(node.left);
                nowVal.add(node.left.val+temp);
            }
            if (node.right != null) {
                nowNode.add(node.right);
                nowVal.add(node.right.val+temp);
            }
        }
        return  false;
    }
}
