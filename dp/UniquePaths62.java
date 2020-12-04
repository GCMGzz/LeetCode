/**
 * @ author  wilbur
 * @ date   2020/12/4 22:01
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 *
 *                  dp[][]表示到该位置有多少条路径
 *                  假设每个位置都已知到达该位置需要多少条路径，那么 dp[i][j] = dp[i-1][j] + dp[i][j-1] （杨辉三角）(只能向左向下移动，每个位置的路径 = 该位置左边的路径 + 该位置上边的路径)
 *                  边界问题 ，第一行和第一列 都只有一条路径
 */
public class UniquePaths62 {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
