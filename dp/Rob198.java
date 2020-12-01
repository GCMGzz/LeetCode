/**
 * @ author  wilbur
 * @ date   2020/12/1 15:17
 *
 *
 *         如果房屋数量大于两间，应该如何计算能够偷窃到的最高总金额呢？对于第 k~(k>2) 间房屋，有两个选项：
 *
 * 偷窃第 k 间房屋，那么就不能偷窃第 k-1间房屋，偷窃总金额为前 k-2间房屋的最高总金额与第 kk 间房屋的金额之和。
 *
 * 不偷窃第 kk 间房屋，偷窃总金额为前 k-1间房屋的最高总金额。
 *
 * 在两个选项中选择偷窃总金额较大的选项，该选项对应的偷窃总金额即为前 kk 间房屋能偷窃到的最高总金额。
 *
 * 用 dp[i]dp[i] 表示前 ii 间房屋能偷窃到的最高总金额，那么就有如下的状态转移方程：
 *
 * dp[i]=max( dp[i-2] + nums[i] , dp[i-1] )
 *
 * 边界条件为：
 * dp[0]=nums[0]                                    只有一间房屋，则偷窃该房屋
 * dp[1]=max(nums[0],nums[1])           只有两间房屋，选择其中金额较高的房屋进行偷窃
 *
 */
public class Rob198 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
