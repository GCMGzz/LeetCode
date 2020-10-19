import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ author  wilbur
 * @ date   2020/10/19 9:59
 *
 *                                                              给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *                                                             桶排序  堆  快排
 */
public class TopKFrequent347star {
    public int[] topKFrequent(int[] nums, int k) {

        List<Integer> res = new ArrayList();
        Map<Integer, Integer> map = new HashMap<>();
        //元素为键，出现的次数为值
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }
        //桶排序
        //将元素出现次数作为数组下标，对于出现次数不同的数字集合，存入对应的数组下标
        //数组每个元素出现次数最少为1  桶0不可能有值
        // 一个数字最多出现 nums.length 次，因此定义一个长度为 nums.length + 1 的数组
        List<Integer>[] list = new List[nums.length+1];
        for(int key : map.keySet()){
            // 获取出现的次数作为下标
            int i = map.get(key);
            if(list[i] == null){
                list[i] = new ArrayList();
            }
            list[i].add(key);
        }

        // 倒序遍历数组获取出现顺序从大到小的排列
        for(int i = list.length - 1;i >= 0 && res.size() < k;i--){
            if(list[i] == null) continue;
            res.addAll(list[i]);
        }
        int[] res1 = res.stream().mapToInt(Integer::valueOf).toArray();
        return res1;
    }
}
