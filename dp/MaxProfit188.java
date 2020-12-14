/**
 * @ author  wilbur
 * @ date   2020/12/14 21:16
 *
 *
 *   ����һ���������� prices �����ĵ� i ��Ԫ�� prices[i] ��һ֧�����Ĺ�Ʊ�ڵ� i ��ļ۸�
 * ���һ���㷨�����������ܻ�ȡ�������������������� k �ʽ��ס�
 * ע�⣺�㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����
 *
 *       ��Ʊ����ϵ��  121    122        123    188  309    714   ����˼·����
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
