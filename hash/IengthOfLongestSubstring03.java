import java.util.HashMap;
import java.util.Map;

/**
 * @ author  wilbur
 * @ date   2020/10/18 14:56
 *
 *                          给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */

//滑动窗口
public class IengthOfLongestSubstring03 {
    /**
     * map (k, v)，其中 key 值为字符，value 值为字符位置;
     */
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int max = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < length; end++) {
            char element = s.charAt(end);
            if (map.containsKey(element)) {
                start = Math.max(map.get(element) + 1, start); //map.get()的地方进行+1操作
            }
            max = Math.max(max, end - start + 1);
            map.put(element, end);
        }
        return max;
    }
}
