/**
 * @author wilbur
 *
 * @date 2020/9/21 17:37
 * @题目描述 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 * @解题思路  递归  /   DFS (将所有节点遍历到list里 再判断是否有不同的)
 */
public class IsUnivalTree965 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    private int temp =0;
    public boolean isUnivalTree(TreeNode root) {

        temp =root.val;
        return judge(root);

    }
    private boolean judge(TreeNode root){
        if(root == null )
            return  true;
        else if(root.val!=temp){
            return false;
        }
        else
            return judge(root.left)&&judge(root.right);
    }
}
