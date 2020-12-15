/**
 * @ author  wilbur
 * @ date   2020/12/15 15:09
 *
 *
 * //给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 * //
 * // 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * //
 * // 返回获得利润的最大值。
 *
 * 股票问题系列  121    122        123    188  309    714   解题思路整理
 *   https://leetcode-cn.com/circle/article/qiAgHn/
 *
 */
public class MaxProfit714 {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int L = prices.length;
        int [][]dp =new int[L][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0]-fee;
        for (int i =1;i<L;i++){
            //在买入股票时扣除手续费
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]-fee);
        }
        return  dp[L-1][0];
    }
}
