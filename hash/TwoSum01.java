import java.util.HashMap;
import java.util.Map;

/**
 * @ author  wilbur
 * @ date   2020/9/26 19:03
 * @ 题目描述                   给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标
 * @ 解题思路
 */
public class TwoSum01 {

    //1
    public int[] twoSum(int[] nums, int target) {
        int [] temp = new int[2] ;
        for(int i = 0; i<nums.length;i++){
            for(int j = i+1 ;j <nums.length ; j++){
                if(nums[i]+nums[j]==target){
                    temp[0]=i;
                    temp[1]=j;
                    return temp;
                }
            }
        }
        return null;
    }
    //2、HashMap  遍历数组 nums，i 为当前下标，每个值都判断map中是否存在 target-nums[i] 的 key 值
    //如果存在则找到了两个值，如果不存在则将当前的 (nums[i],i) 存入 map 中，继续遍历直到找到为止
    //如果最终都没有结果则抛出异常

//  如果数组有重复的数据 那么map中键对应的值肯定是数组中两个重复值中的后者，但是循环数组时 先取到的是数组中重复值的前者     [3,3]    6   res =[0,1]
    public int[] twoSum2(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i< nums.length; i++) {
                if(map.containsKey(target - nums[i])) {
                    return new int[] {map.get(target-nums[i]),i};
                }
                map.put(nums[i], i);
            }
            throw new IllegalArgumentException("No two sum solution");
        }
}
