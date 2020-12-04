import java.util.Arrays;

/**
 * @ author  wilbur
 * @ date   2020/12/4 21:07
 *
 *
 * //����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݣ�ÿ�䷿�ڶ�����һ�����ֽ�����ط����еķ��ݶ� Χ��һȦ ������ζ�ŵ�һ�����ݺ����һ�������ǽ����ŵġ�ͬʱ�����ڵ�
 * //����װ���໥��ͨ�ķ���ϵͳ������������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ����� ��
 *
 *
 *    ����ⷨͬ198.��ҽ��ᣬ���عؼ����з��ݶ�Χ��һȦ�ɻ�״
 *    ��ֻ� ----�� ����β����ȡʱ���������ֵ�϶�С�ڵ���ֻȥ���׻���ֻȥ��β�Ķ��С�
 * ��f��n1,n2,n3��<=f(n1,n2,n3,n4)
 * ���ԱȽ����� ����β�����������
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
