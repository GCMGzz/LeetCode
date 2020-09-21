public class FindTilt {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    int ans=0;
    public int findTilt(TreeNode root) {
        Tilt(root);
        return ans;
    }
    public int Tilt(TreeNode root){

        if (root==null){return  0;  }
        int L=Tilt(root.left);
        int R =Tilt(root.right);
        ans+=Math.abs(L-R);
        return L+R+root.val;

    }
}
