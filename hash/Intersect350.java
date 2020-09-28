import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ author  wilbur
 * @ date   2020/9/28 15:31
 * @ 题目描述                              给定两个数组，编写一个函数来计算它们的交集。 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * @ 解题思路                           Arrays.copyOfRange  将一个原始的数组original，从from开始复制，复制到to，生成一个新的数组。注意这里包括from，不包括to
 */
public class Intersect350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        //将长度较小的数组用map记录每个数字以及出现的次数
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        //二者交集长度最多为二者最小的数组长度
        int[] res = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            //第二个数组中的数字与map 中相同 即为重复数字 ，记录其出现的次数
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                //存在重复，将该数字添加入答案，并减少map中该数字出现的次数
                res[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        //复制新的数组 ，只包括需要的重复元素
        return Arrays.copyOfRange(res, 0, index);//将一个原始的数组original，从from开始复制，复制到to，生成一个新的数组。注意这里包括from，不包括to
    }
}
