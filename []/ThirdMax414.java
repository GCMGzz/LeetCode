/**
 * @ author  wilbur
 * @ date   2020/12/24 21:00
 *
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 *
 *
 *
 * 非空数组，所以长度大于0的
 * 每次更新第一大值和第二大值时，都传递给第三大值
 * 注意重复的跳过，最后判断第三大有没有更新过
 */
public class ThirdMax414 {
    public int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        //最小值为Long类型的最小值，因为测试用例会使用Integer类型的最小值导致出错，
        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;
        for (int n : nums) {
            if (n > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = n;
            } else if (firstMax == n){
                continue;
            }else  if (n > secondMax) {
                thirdMax = secondMax;
                secondMax = n;
            } else if (n == secondMax) {
                continue;
            } else if (n > thirdMax) {
                thirdMax = n;
            }
        }
        return thirdMax == Long.MIN_VALUE ? (int)firstMax : (int)thirdMax;
    }
}
