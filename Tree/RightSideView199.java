import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class RightSideView199 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    // BFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> right = new ArrayList<>();
        if (root==null) return right;
        Queue<TreeNode> queue =new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int n= queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node =queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right!=null ){
                    queue.add(node.right);
                }
                if(i==n-1){
                    right.add(node.val);
                }
            }
        }
        return  right;
    }
    //DFS
//    List<Integer> res = new ArrayList<>();
//
//    public List<Integer> rightSideView(TreeNode root) {
//        dfs(root, 0); // 从根节点开始访问，根节点深度是0
//        return res;
//    }
//
//    private void dfs(TreeNode root, int depth) {
//        if (root == null) {
//            return;
//        }
//        // 先访问 当前节点，再递归地访问 右子树 和 左子树。
//        if (depth == res.size()) {   // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
//            res.add(root.val);
//        }
//        depth++;
//        dfs(root.right, depth);
//        dfs(root.left, depth);
    //}
}
