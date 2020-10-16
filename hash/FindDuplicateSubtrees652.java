import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @ author  wilbur
 * @ date   2020/10/16 10:52
 *
 *                                 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *                                两棵树重复是指它们具有相同的结构以及相同的结点值
 *
 *          思路：          通过一个编码还有一个解码的方式来得到原数据，那么就从侧面说明，对于原数据来说，使用相同序列化后的结果肯定是唯一的。
 *                              所以，既然我们要找重复的子树，那么我们只需要将所有子树都使用相同的方式进行序列化，那在此过程中如果发现有相同的序列，那我们就可以找出相同的子树。
 *
 */




public class FindDuplicateSubtrees652 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<String,Integer> map = new HashMap<>();
    LinkedList<TreeNode> res = new LinkedList<TreeNode>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root ==null ) return  res;
        serlize(root);
        return  res;
    }
    public  String serlize(TreeNode root){
        if(root == null ) return "@";
        //序列化以当前节点为根节点的二叉树
        String str =root.val+","+serlize(root.left)+","+serlize(root.right);
        //使用一个HashMap来记录所有的子树的序列
        map.put(str,map.getOrDefault(str,0)+1);
        //当其value为2时，则表示出现了重复结构，将这个子树的根节点放入到结果当中。
        if (map.get(str)==2){
            res.add(root);
        }
        return  str;
    }

}
