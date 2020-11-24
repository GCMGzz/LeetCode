/**
 * @ author  wilbur
 * @ date   2020/11/24 13:27
 *
 *                                      //给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * //
 *                                  // 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 *                                     X   Y    Z
 *                                    当数组长度小于3时，最多需要调整一次就能满足条件
 *                                   当数组长度大于等于3时，出现前一个元素y大于后一个元素z时，
 *                                  如果y的前元素x不存在，让y=z即可；若x存在，会有以下情况
 *
 *
 *                                  要满足条件，需要如下调整：
 *                                1，当x<z,让y=z
 *                               2，当x>z,让z=y
 *                              3 , 当x=z,让y=z
 *                            综合以上可以得到：当x存在且x>z，就让z=y，否则让y=z
 *                          当变更超过2次就不再满足条件
 *
 *
 *

 */
public class CheckPossibility665 {
    public boolean checkPossibility(int[] nums) {
        if (nums.length<3)
            return true;

        int count = 0;
        for (int i = 0; i < nums.length - 1 && count <= 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                if (i - 1 >= 0 && nums[i - 1] > nums[i + 1]) {
                    nums[i + 1] = nums[i];
                } else {
                    nums[i] = nums[i + 1];
                }
            }
        }
        return count <= 1;

    }
}
