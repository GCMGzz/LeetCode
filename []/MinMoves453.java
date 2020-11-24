import java.util.Arrays;

/**
 * @ author  wilbur
 * @ date   2020/11/24 13:20
 *
 *                          //给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动将会使 n - 1 个元素增加 1。
 *                          每次使n-1个元素+1 完全 = 每次使1个元素-1然后所有元素+1
 *                          所以只需找出：每次让1个元素-1，多少次后所有元素相等
 */
public class MinMoves453 {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int  ans =0;
        for (int i = 0; i < nums.length; i++) {
            ans+=nums[i]-nums[0];
        }
        return  ans;

    }
}
