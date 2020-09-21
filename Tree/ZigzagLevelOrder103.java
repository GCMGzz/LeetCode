import java.util.*;

/**
 * @author wilbur
 * @date 2020/9/21 16:55
 * @题目描述   给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * @解题思路    层次遍历+使用一个标识符 step++ 来通过奇偶数确定层次遍历的方向
 */
public class ZigzagLevelOrder103 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
            int step = 0;
            while (queue.size() != 0) {
                ArrayList<Integer> temp = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();
                    temp.add(cur.val);
                    if (cur.left != null) {
                        queue.add(cur.left);
                    }
                    if (cur.right != null) {
                        queue.add(cur.right);
                    }
                }
                if (step % 2 == 1) { //右到左
                    Collections.reverse(temp);
                }
                res.add(temp);
                step++;
            }
        }
        return res;
    }
}
