import java.util.ArrayList;
import java.util.List;

public class PostOrder145 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 递归
    List<Integer> ans = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        return postOrder(root);
    }

    public List<Integer> postOrder(TreeNode root) {
        if (root == null) {
            return ans;
        }
        postOrder(root.left);
        postOrder(root.right);
        ans.add(root.val);
        return ans;
    }

    // 迭代
}

