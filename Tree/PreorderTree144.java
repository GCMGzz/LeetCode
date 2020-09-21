import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTree144 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //递归算法
    private List<Integer> ans = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return ans;
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }


    //迭代算法


    public List<Integer> preOrder2(TreeNode root) {
        if (root == null) {
            return ans ;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return ans;
    }


    }

