import java.util.Arrays;

/**
 * @ author  wilbur
 * @ date   2020/12/4 21:07
 *
 *
 * //你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
 * //房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 *
 *    主体解法同198.打家劫舍，本地关键所有房屋都围成一圈成环状
 *    拆分环 ----》 即首尾都不取时，它的最大值肯定小于等于只去掉首或者只去掉尾的队列。
 * 即f（n1,n2,n3）<=f(n1,n2,n3,n4)
 * 所以比较有首 和有尾两种情况即可
 */
public class RobII213 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob1(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                rob1(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    public int rob1(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length == 0 || nums == null) return 0;
        if (nums.length == 1) return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}
