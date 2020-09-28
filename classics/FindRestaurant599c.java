import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ author  wilbur
 * @ date   2020/9/28 14:04
 * @ 题目描述
 * @ 解题思路    HashMap
 */
public class FindRestaurant599c {
    public String[] findRestaurant(String[] list1, String[] list2) {
        //保证使用最小的空间
        if (list1.length > list2.length) {
            return findRestaurant(list2, list1);
        }
        //避免重复计算
        int m = list1.length;
        int n = list2.length;

        // 定义时给定初始容量 避免 rehash
        //假设初始容量为 n , HashMap 的默认负载因子为 0.75, HashMap 会在装了 n/0.75 个数时进行扩容和重新哈希, 这个操作非常耗时, 所以一开始就给定初始容量就不需要扩容
        Map<String, Integer> map = new HashMap<>((int) (list1.length / 0.75));
        for (int i = 0; i < m; i++) {
            map.put(list1[i], i);
        }

        int min = Integer.MAX_VALUE;
        // 定义时给定列表的大小 避免频繁的扩容
        List<String> list = new ArrayList<>(map.size());
        for (int j = 0; j < n; j++) {
            Integer i;//提前定义变量，减少操作
            if ((i = map.get(list2[j])) != null) {
                if (i + j < min) {
                    list.clear();
                    min = i + j;
                    list.add(list2[j]);
                } else if (i + j == min) {
                    list.add(list2[j]);
                }
            }
        }
        return list.toArray(new String[0]);
    }
}
