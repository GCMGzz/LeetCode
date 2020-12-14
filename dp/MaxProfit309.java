/**
 * @ author  wilbur
 * @ date   2020/12/14 21:18
 *
 *
 *
 *   //给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。
 * // 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * // 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * // 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 *
 *          股票问题系列  121    122        123    188  309    714   解题思路整理
 *          https://leetcode-cn.com/circle/article/qiAgHn/
 *
 */
public class MaxProfit309 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], (i >= 2 ? dp[i - 2][0] : 0) - prices[i]);
        }
        return dp[length - 1][0];
    }

}
