import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class FindTarget653 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root,list);
        int p=0;
        int  q =list.size()-1;
        while(p<q){
            int sum =list.get(p)+list.get(q);
            if(sum==k) return true;
            if(sum<k) {p++;}
            else q--;
        }
        return  false;
    }
    public void inOrder(TreeNode root , List<Integer> list){
        if (root ==null ) return;
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }
}
