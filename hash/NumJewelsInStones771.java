import java.util.HashMap;
import java.util.Map;

/**
 * @ author  wilbur
 * @ date   2020/10/16 11:32
 *
 * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 */
public class NumJewelsInStones771 {
    //Map
    public int numJewelsInStones(String J, String S) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        int jL = J.length(), sL = S.length();
        for (int i = 0; i < sL; i++) {
            char stone = S.charAt(i);
            map.put(stone, map.getOrDefault(stone, 0) + 1);
        }
        for (int i = 0; i < jL; i++) {
            char jewel = J.charAt(i);
            if (map.containsKey(jewel)) {
                ans += map.get(jewel);
            }
        }
        return ans;
    }

    //Set
    public int numJewelsInStones2(String J, String S) {
        int jewelsCount = 0;
        int jewelsLength = J.length(), stonesLength = S.length();
        for (int i = 0; i < stonesLength; i++) {
            char stone = S.charAt(i);
            for (int j = 0; j < jewelsLength; j++) {
                char jewel = J.charAt(j);
                if (stone == jewel) {
                    jewelsCount++;
                    break;
                }
            }
        }
        return jewelsCount;
    }

}
