import java.util.ArrayList;
import java.util.List;

/**
 * @ author  wilbur
 * @ date   2020/9/25 21:59
 * @ 题目描述                 给定一个范围在1 ≤ a[i] ≤ n (n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * @ 解题思路                     根据题目特点，可以把数组中的元素与索引建立一一对应的关系。因为索引是确定的0到n-1,一个也不缺，而数组的元素不确定，少了哪个也不知道。
 *                                        既然两者是一一对应的关系，那么我们对数组中的每个元素对应的索引做个标记；
 *                                       然后再对索引进行一次遍历，那么不存的元素就不会对它对应的索引进行比较，由此可查找出这些不存在的元素
 。                                    遍历每个元素，对索引进行标记      时间O(n)   空间O(1)
 *                                                                          将对应索引位置的值变为负数；
 *                                                                          遍历下索引，看看哪些索引位置上的数不是负数的。
 *                                                                          位置上不是负数的索引，对应的元素就是不存在的。
 */
public class FindDisappearedNumbers448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //用来存放结果
        List<Integer> res = new ArrayList<>();
        //1. 遍历下数组的元素，对对应的索引位置的元素作标记
        int len = nums.length;
        for(int i = 0; i < len; i++){
            int num = Math.abs(nums[i]);  //由于数组的元素有可能被*-1，所以取绝对值
            int index = num - 1;
            if(nums[index] > 0){
                nums[index] *= -1;
            }
        }
        // 寻找没有标记的索引位置
        for(int i = 0; i < len; i++){
            if(nums[i] > 0){
                int num = i + 1;  //将索引转化为对应的元素
                res.add(num);
            }
        }
        return res;
    }
}
