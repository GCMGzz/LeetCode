import java.util.Arrays;

/**
 * @ author  wilbur
 * @ date   2020/9/24 22:24
 * @ 题目描述                                              给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * @ 解题思路
 */
public class MaximumProduct628 {
    int res = 1;

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }
}
