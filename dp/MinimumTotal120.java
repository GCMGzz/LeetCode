import java.util.List;

/**
 * @ author  wilbur
 * @ date   2020/12/8 22:55
 * <p>
 * //给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * // 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 */
public class MinimumTotal120 {

    //dp[i][j] 表示从点 (i, j)(i,j) 到底边的最小路径和。
    public int minimumTotal1(List<List<Integer>> triangle) {
        int n = triangle.size();

        //1、从上到下
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        if (triangle.size() == 0 || triangle == null) return 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    // 最左端特殊处理
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == i) {
                    // 最右端特殊处理
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        // dp最后一行记录了最小路径
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[n - 1][i]);
        }
        return res;
    }

    // dp 从下到上  直接输出dp[0][0]  最后不用进行比较
    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    //优化
//在上述代码中，我们定义了一个 N行 N 列 的 dp 数组（N是三角形的行数）。
//但是在实际递推中我们发现，计算 dp[i][j]dp[i][j] 时，只用到了下一行的 dp[i + 1][j] dp[i+1][j] 和 dp[i + 1][j + 1]dp[i+1][j+1]。
//因此 dp数组不需要定义 N 行，只要定义 1 行就阔以啦。
//所以我们稍微修改一下上述代码，将 i所在的维度去掉（如下），就可以将 O(N^2)O(N2) 的空间复杂度优化成 O(N)O(N) ～

    public int minimumTotal3(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];

    }
}
