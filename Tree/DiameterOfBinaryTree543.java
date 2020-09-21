public class DiameterOfBinaryTree543 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //二叉树上的任一“路径”上一定有一个结点是所有其他结点的祖先结点（因为“路径”是由一个个父子关系连接而成的）
    // 那么换个表述方法，对于任一结点，以此结点为根的diameter就可以表示为左子树高度 + 右子树高度
    // 而二叉树的diameter就是所有结点为根的diameter中最大的那个。
    //最大的直径不一定包括根节点

        int ans;
        public int diameterOfBinaryTree(TreeNode root) {
            ans = 1;
            depth(root);
            return ans - 1;
        }
        public int depth(TreeNode node) {
            if (node == null) return 0; // 访问到空节点了，返回0
            int L = depth(node.left); // 左儿子为根的子树的深度
            int R = depth(node.right); // 右儿子为根的子树的深度
            ans = Math.max(ans, L+R+1); // 计算d_node即L+R+1 并更新ans
            return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
        }
    }


