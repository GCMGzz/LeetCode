import java.util.HashSet;

/**
 * @ author  wilbur
 * @ date   2020/12/23 15:42
 *
 * //����һ��ż�����ȵ����飬���в�ͬ�����ִ����Ų�ͬ������ǹ���ÿһ�����ִ���һ���ǹ���
 * ����Ҫ����Щ�ǹ�ƽ���ָ�һ���ܵܺ�һ�����á��������ÿ��Ի�õ�����ǹ�����������
 *
 * ����ǹ������೬��������һ�룬����������һ�뼴�ɣ����֣�
 * ����ǹ�������С��������һ�룬�����ǹ����༴��
 */
public class DistributeCandies575 {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> candy = new HashSet<>();
        for (int i = 0; i < candyType.length; i++) {
            candy.add(candyType[i]);
        }
        return Math.min(candy.size(),candyType.length/2);
    }
}
