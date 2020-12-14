/**
 * @ author  wilbur
 * @ date   2020/12/14 21:18
 *
 *
 *
 *   //����һ���������飬���е� i ��Ԫ�ش����˵� i ��Ĺ�Ʊ�۸� ��
 * // ���һ���㷨����������������������Լ�������£�����Ծ����ܵ���ɸ���Ľ��ף��������һ֧��Ʊ��:
 * // �㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����
 * // ������Ʊ�����޷��ڵڶ��������Ʊ (���䶳��Ϊ 1 ��)��
 *
 *          ��Ʊ����ϵ��  121    122        123    188  309    714   ����˼·����
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
