/**
 * @ author  wilbur
 * @ date   2020/12/14 21:11
 *
 *
 * //给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * //
 * // 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * //
 * // 注意：你不能在买入股票前卖出股票。
 *
 * 股票问题系列  121    122        123    188  309    714   解题思路整理
 * https://leetcode-cn.com/circle/article/qiAgHn/
 */
public class MaxProfit121 {
    public int maxProfit(int[] prices) {
      if (prices==null || prices.length==0)return 0;
    int L =prices.length;
    int [][]dp =new int[L][2];
    dp[0][0]=0;
    dp[0][1]=-prices[0];
        for (int i = 1; i <L ; i++) {
        dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
        dp[i][1]=Math.max(dp[i-1][1],-prices[i]);
    }
        return dp[L-1][0];
}
}
