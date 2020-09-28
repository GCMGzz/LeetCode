import java.util.HashMap;
import java.util.Map;

/**
 * @ author  wilbur
 * @ date   2020/9/28 14:30
 * @ 题目描述                       给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * @ 解题思路                        	s.toCharArray()  将此字符串转换为一个新的字符数组。
 *                                             map.getOrDefault()	获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值
 */
public class FirstUniqChar387 {
    public int firstUniqChar(String s) {
    Map<Character,Integer> map =new HashMap<>() ;
    // 统计各字符出现次数；
        for (char ch : s.toCharArray()) {
        map.put(ch, map.getOrDefault(ch, 0)+1);
    }
        for (int i = 0;i<s.length();i++){
        if (map.get(s.charAt(i))==1){
            return  i ;
        }
    }
        return -1;
}
}
