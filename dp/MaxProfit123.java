/**
 * @ author  wilbur
 * @ date   2020/12/15 15:17
 *
 *
 * //����һ�����飬���ĵ� i ��Ԫ����һ֧�����Ĺ�Ʊ�ڵ� i ��ļ۸�
 * //
 * // ���һ���㷨�����������ܻ�ȡ�������������������� ���� ���ס�
 * //
 * // ע��: �㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����
 *
 * ��Ʊ����ϵ��  121    122        123    188  309    714   ����˼·����
 * https://leetcode-cn.com/circle/article/qiAgHn/
 */
public class MaxProfit123 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int L = prices.length;
        int[][][]dp =new int[L][3][2];
        dp[0][1][0]=0;
        dp[0][1][1]=-prices[0];
        dp[0][2][0]=0;
        dp[0][2][1]=-prices[0];
        for (int i = 1; i < L; i++) {
            dp[i][2][0]=Math.max(dp[i-1][2][0],dp[i-1][2][1]+prices[i]);
            dp[i][2][1]=Math.max(dp[i-1][2][1],dp[i-1][1][0]-prices[i]);
            dp[i][1][0]=Math.max(dp[i-1][1][0],dp[i-1][1][1]+prices[i]);
            dp[i][1][1]=Math.max(dp[i-1][1][1],dp[i-1][0][0]-prices[i]);
        }
        return dp[L-1][2][0];
    }
}
