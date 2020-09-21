public class FindSecondMinimumValue {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
    int count = 0;

    public int findSecondMinimumValue(TreeNode root) {
        helper(root);
        return count == 0 ? -1 : second;
    }

    public void helper(TreeNode root) {
        if (root == null)
            return;

        if (root.val < first) {
            second = first;
            first = root.val;
        } else if (root.val <= second && root.val > first) {
            count++;
            second = root.val;
        }
        helper(root.left);
        helper(root.right);
    }
}
