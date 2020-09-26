import java.util.HashSet;

/**
 * @ author  wilbur
 * @ date   2020/9/26 14:46
 * @ 题目描述               如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * @ 解题思路               利用HashSet无重复元素 判断set 和nums 的长度
 */
public class ContainsDuplicate217 {
    public boolean containsDuplicate(int[] nums) {
        HashSet set = new HashSet(nums.length);
        for(int i: nums )if(!set.add(i)) return true;
        return false;
    }
}
