/**
 * @ author  wilbur
 * @ date   2020/12/14 21:16
 *
 *
 *   给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *       股票问题系列  121    122        123    188  309    714   解题思路整理
 *  *  *https://leetcode-cn.com/circle/article/qiAgHn/
 */
public class MaxProfit188 {
    public int maxProfit(int k, int[] prices) {
        if (prices==null || prices.length==0)return 0;
        int length =prices.length;
        int[][][] dp = new int[length][k + 1][2];
        for (int i = 1; i <= k; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }
        for (int i = 1; i < length; i++) {
            for (int j = k; j > 0; j--) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[length - 1][k][0];

    }
}
