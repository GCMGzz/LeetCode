import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class FindBottomLeftValue513 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public int findBottomLeftValue(TreeNode root) {
        ArrayList<ArrayList<Integer>> temp1 = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            ArrayList<Integer> temp2 =new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                temp2.add(node.val);
                if(node.left!=null){
                    queue.add(node.left) ;
                }
                if(node.right!=null) {
                    queue.add(node.right);
                }
            }
            temp1.add(temp2);
        }
        return temp1.get(temp1.size()-1).get(0);
    }
}
