/**
 * @ author  wilbur
 * @ date   2020/12/8 23:07
 *
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 这种求特定数据结构的数目  一定有规律
 * 如果整数 1 ~ n 中的 k 作为根节点值，则 1 ~k-1 会去构建左子树，k+1 ~ n 会去构建右子树。
 * 左子树出来的形态有 a 种，右子树出来的形态有 b种，则整个树的形态有 a * b 种。
 * 以 kk 为根节点的 BST 种类数 = 左子树 BST种类数 * 右子树 BST 种类数
 * 问题变成：不同的 k 之下，等号右边的乘积，进行累加
 *
 *
 *
 */
public class NumTrees96 {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n+1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
