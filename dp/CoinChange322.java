import java.util.Arrays;

/**
 * @ author  wilbur
 * @ date   2020/12/4 15:05
 * <p>
 * //������ͬ����Ӳ�� coins ��һ���ܽ�� amount����дһ��������������Դճ��ܽ����������ٵ�Ӳ�Ҹ��������û���κ�һ��Ӳ�����������ܽ�����
 * // -1��
 * //
 * // �������Ϊÿ��Ӳ�ҵ����������޵ġ�
 */
public class CoinChange322 {
    //dp �Ե�����
    public int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[coin] != amount + 1) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        if (dp[amount] == amount + 1) return -1;
        return dp[amount];
    }

    //���仯�ݹ�  ֱ������  ��������
    public int coinChange2(int[] coins, int amount) {

        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -2);
        Arrays.sort(coins);
        return dfs(coins, amount, memo);
    }

    private int dfs(int[] coins, int amount, int[] memo) {
        int res = Integer.MAX_VALUE;
        if (amount == 0) {
            return 0;
        }

        if (memo[amount] != -2) {
            return memo[amount];
        }

        for (int coin : coins) {
            if (amount - coin < 0) {
                break;
            }

            int subRes = dfs(coins, amount - coin, memo);
            if (subRes == -1) {
                continue;
            }
            res = Math.min(res, subRes + 1);
        }
        return memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
    }

//https://leetcode-cn.com/problems/coin-change/solution/dong-tai-gui-hua-shi-yong-wan-quan-bei-bao-wen-ti-/

    }


