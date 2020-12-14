/**
 * @ author  wilbur
 * @ date   2020/12/14 21:14
 *
 *  //����һ�����飬���ĵ� i ��Ԫ����һ֧������Ʊ�� i ��ļ۸�
 * //
 * // ���һ���㷨�����������ܻ�ȡ�������������Ծ����ܵ���ɸ���Ľ��ף��������һ֧��Ʊ����
 * //
 * // ע�⣺�㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����
 *
 *
 *          ��Ʊ����ϵ��  121    122        123    188  309    714   ����˼·����
 *  * https://leetcode-cn.com/circle/article/qiAgHn/
 */
public class MaxProfit122 {
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length==0)return 0;
        int L =prices.length;
        int [][]dp =new int[L][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for (int i = 1; i <L ; i++) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[L-1][0];
    }
}
