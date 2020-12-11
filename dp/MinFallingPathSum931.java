/**
 * @ author  wilbur
 * @ date   2020/12/11 19:56
 * <p>
 * <p>
 * 给定一个方形整数数组A，我们想要得到通过 A 的下降路径的最小和。
 * <p>
 * 下降路径可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列。
 * <p>
 * dp[i][j] 代表到该位置的最小和
 *
 * 从题解中学到了
 * 1、数组原地处理
 * 直接在原数组 A 上计算 dp(r, c)，因为最后一行 A 的值就是 dp 的值 。因此我们从倒数第二行开始，从下往上进行动态规划，状态转移方程为：
 *                                                  A[r][c] = A[r][c] + min{A[r + 1][c - 1], A[r + 1][c], A[r + 1][c + 1]}
 * 注意需要处理超出边界的情况，即在第一列和最后一列只能下降到两个位置。
 * 最精妙的是官方题解的 边界处理    （c>0）  (c+1<N)
 *
 * 2、直接对原数组 加顶一层0，左右两侧 MAX_VALUE，直接解决边界问题（加壳）
 * 注意加壳后 状态转移方程有所改变
 * dp[i][j]=min(dp[i?1][j?1],dp[i?1][j],dp[i?1][j+1])+A[i][j]  ---》 dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i - 1][j + 1]) + A[i-1][j-1]
 */
public class MinFallingPathSum931 {
    public int minFallingPathSum1(int[][] A) {
        //原地修改
        int N = A.length;
        //注意--r  --c
        for (int r = N - 2; r >= 0; --r) {
            for (int c = 0; c < N; ++c) {
                // best = min(A[r+1][c-1], A[r+1][c], A[r+1][c+1])
                int best = A[r + 1][c];
                if (c > 0)
                    best = Math.min(best, A[r + 1][c - 1]);
                if (c + 1 < N)
                    best = Math.min(best, A[r + 1][c + 1]);
                A[r][c] += best;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int x : A[0])
            ans = Math.min(ans, x);
        return ans;
    }

    //套壳
    public int minFallingPathSum2(int[][] A) {
        // 设dp[i][j]为到i, j位置的最小路径和
        int len = A.length;
        int[][] dp = new int[len + 1][len + 2];

        // 套壳处理
        for (int i = 0; i < len + 1; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][len + 1] = Integer.MAX_VALUE;
        }
        for (int j = 0; j < len + 2; j++) {
            dp[0][j] = 0;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < len + 1; i++) {
            for (int j = 1; j < len + 1; j++) {
                dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i - 1][j + 1]) + A[i - 1][j - 1];
            }
        }
        for (int i = 1; i < len + 1; i++) {
            ans = Math.min(ans, dp[len][i]);
        }
        return ans;
    }
}


