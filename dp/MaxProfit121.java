/**
 * @ author  wilbur
 * @ date   2020/12/14 21:11
 *
 *
 * //����һ�����飬���ĵ� i ��Ԫ����һ֧������Ʊ�� i ��ļ۸�
 * //
 * // ��������ֻ�������һ�ʽ��ף������������һ֧��Ʊһ�Σ������һ���㷨�����������ܻ�ȡ���������
 * //
 * // ע�⣺�㲻���������Ʊǰ������Ʊ��
 *
 * ��Ʊ����ϵ��  121    122        123    188  309    714   ����˼·����
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
