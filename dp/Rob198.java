/**
 * @ author  wilbur
 * @ date   2020/12/1 15:17
 *
 *
 *         ������������������䣬Ӧ����μ����ܹ�͵�Ե�������ܽ���أ����ڵ� k~(k>2) �䷿�ݣ�������ѡ�
 *
 * ͵�Ե� k �䷿�ݣ���ô�Ͳ���͵�Ե� k-1�䷿�ݣ�͵���ܽ��Ϊǰ k-2�䷿�ݵ�����ܽ����� kk �䷿�ݵĽ��֮�͡�
 *
 * ��͵�Ե� kk �䷿�ݣ�͵���ܽ��Ϊǰ k-1�䷿�ݵ�����ܽ�
 *
 * ������ѡ����ѡ��͵���ܽ��ϴ��ѡ���ѡ���Ӧ��͵���ܽ�Ϊǰ kk �䷿����͵�Ե�������ܽ�
 *
 * �� dp[i]dp[i] ��ʾǰ ii �䷿����͵�Ե�������ܽ���ô�������µ�״̬ת�Ʒ��̣�
 *
 * dp[i]=max( dp[i-2] + nums[i] , dp[i-1] )
 *
 * �߽�����Ϊ��
 * dp[0]=nums[0]                                    ֻ��һ�䷿�ݣ���͵�Ը÷���
 * dp[1]=max(nums[0],nums[1])           ֻ�����䷿�ݣ�ѡ�����н��ϸߵķ��ݽ���͵��
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
