import java.util.Arrays;

/**
 * @ author  wilbur
 * @ date   2020/12/22 19:15
 *
 * //给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得
 * //从 1 到 n 的 min(ai, bi) 总和最大。
 */
public class ArrayPairSum561 {
    public int arrayPairSum(int[] nums) {
        int  ans =0;
        Arrays.sort(nums);
        for (int i=0;i< nums.length;i+=2){
            ans+=nums[i];
        }
        return ans;
    }
}
