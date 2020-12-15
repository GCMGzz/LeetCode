/**
 * @ author  wilbur
 * @ date   2020/12/15 15:09
 *
 *
 * //����һ���������� prices�����е� i ��Ԫ�ش����˵� i ��Ĺ�Ʊ�۸� ���Ǹ����� fee �����˽��׹�Ʊ���������á�
 * //
 * // ��������޴ε���ɽ��ף�������ÿ�ʽ��׶���Ҫ�������ѡ�������Ѿ�������һ����Ʊ����������֮ǰ��Ͳ����ټ��������Ʊ�ˡ�
 * //
 * // ���ػ����������ֵ��
 *
 * ��Ʊ����ϵ��  121    122        123    188  309    714   ����˼·����
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
            //�������Ʊʱ�۳�������
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]-fee);
        }
        return  dp[L-1][0];
    }
}
