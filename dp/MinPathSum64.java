/**
 * @ author  wilbur
 * @ date   2020/12/5 20:10
 *
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *  说明：每次只能向下或者向右移动一步。
 *
 *  注意边界
 *  最左边路径的dp值 = 当前节点的 相邻上dp节点 + 当前节点的值
 *  最上边路径的dp值 = 当前节点的 相邻左dp节点 + 当前节点的值
 */
public class MinPathSum64 {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //0 0 起点，循环继续
                if (i == 0 && j == 0) continue;
                else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];

    }
}
