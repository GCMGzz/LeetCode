import java.util.ArrayList;
import java.util.List;

/**
 * @author wilbur
 * @date 2020/9/22 14:30
 * @题目描述                                        结点左子树中所含结点的值小于等于当前结点的值
 *                                                          结点右子树中所含结点的值大于等于当前结点的值
 *                                                          左子树和右子树都是二叉搜索树
 *                                                          如果众数超过1个，不需考虑输出顺序
 *
 * @解题思路                         currentTimes 纪录当前节点出现的次数；maxTimes纪录节点出现的最大次数；
 *                                             pre用来与root节点比较；利用BST中序遍历可以得到一个递增的遍历; 将出现次数与最大次数相同的节点放入List;
 *                                             如果出现currentTimes>maxTimes ,清空List , maxTimes=currentTimes,将该节点放入List；递归
 *
 */
public class FindMode501 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    int currentTimes = 0;
    int maxTimes=0;
    List<Integer> temp =new ArrayList<>();
    TreeNode pre =null;
    public int[] findMode(TreeNode root) {
        inOrder(root);
        int[]res =new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            res[i]=temp.get(i);
        }
        return res;
    }
    private void inOrder(TreeNode root){
        if (root==null) return;
        inOrder(root.left);
        if(pre!=null&&pre.val==root.val){
            currentTimes++;
        }else {
            currentTimes =1;
        }
        if(currentTimes==maxTimes){
            temp.add(root.val);
        }else if (currentTimes>maxTimes){
            maxTimes=currentTimes;
            temp.clear();
            temp.add(root.val);
        }
        pre = root;
        inOrder(root.right);
    }
}
