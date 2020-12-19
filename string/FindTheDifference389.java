import java.util.HashSet;
import java.util.Set;

/**
 * @ author  wilbur
 * @ date   2020/12/19 12:41
 *
 * //���������ַ��� s �� t������ֻ����Сд��ĸ��
 * //
 * // �ַ��� t ���ַ��� s ������ţ�Ȼ�������λ�����һ����ĸ��
 * //
 * // ���ҳ��� t �б���ӵ���ĸ��
 */
public class FindTheDifference389 {
    //���
    // a^a=0; �κ����ֺ��Լ������0
    //a^0=a; �κ����ֺ�0��������Լ�
    //a^b^a=a^a^b ���������н�����
    public char findTheDifference1(String s, String t) {
        char[] diff = s.concat(t).toCharArray();
        char res = 0;
        for (char c : diff) {
            res ^= c;
        }
        return  res;
    }

    //Set
    //���ַ���s��t�ϲ���Ȼ������ϲ���ÿ���ַ����жϼ���set���Ƿ�������ַ�������о��Ƴ�������ͼ��뵽����set�С�
    // ��󼯺�set��ֻ��һ���ַ�������ַ���������Ҫ��ġ�
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
