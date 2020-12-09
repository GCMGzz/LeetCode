/**
 * @ author  wilbur
 * @ date   2020/12/9 14:46
 *
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 该题与[剑指 Offer 14- I]剪绳子 一样
 *
 * /为什么用 j 乘 而不用 dp[j]/
 * dp[j]*dp[i-j]已经包含在j*dp[i-j]中，dp[j]的意思是将j拆成至少两个更小的正整数之和，
 * 这些正整数的最大乘积，如果i拆成了m个数之和，那一定能将这m个数分成1个数和其余的m-1个数，只需要遍历那1个数的所有可能取值即可，
 * 其余的m-1个数的最大乘积显然之前已经计算过了。如果考虑dp[j]*dp[i-j]，就是不必要地重复考虑了之前已经计算过的情况。
 *
 * 还有根据数学方法进行优化 以及 解答
 */
public class IntegerBreak343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
}
