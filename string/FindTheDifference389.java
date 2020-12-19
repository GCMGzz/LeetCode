import java.util.HashSet;
import java.util.Set;

/**
 * @ author  wilbur
 * @ date   2020/12/19 12:41
 *
 * //给定两个字符串 s 和 t，它们只包含小写字母。
 * //
 * // 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * //
 * // 请找出在 t 中被添加的字母。
 */
public class FindTheDifference389 {
    //异或
    // a^a=0; 任何数字和自己异或都是0
    //a^0=a; 任何数字和0异或还是他自己
    //a^b^a=a^a^b 异或运算具有交换律
    public char findTheDifference1(String s, String t) {
        char[] diff = s.concat(t).toCharArray();
        char res = 0;
        for (char c : diff) {
            res ^= c;
        }
        return  res;
    }

    //Set
    //把字符串s和t合并，然后遍历合并的每个字符，判断集合set中是否有这个字符，如果有就移除，否则就加入到集合set中。
    // 最后集合set中只有一个字符，这个字符就是我们要求的。
    public char findTheDifference2(String s, String t) {
        Set<Character> set =new HashSet<>();
        char[] diff = s.concat(t).toCharArray();
        for (int i = 0; i < diff.length; i++) {
            if (set.contains(diff[i]))
                set.remove(diff[i]);
            else
                set.add(diff[i]);
        }
        return (char)set.toArray()[0];
    }
}
