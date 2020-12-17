/**
 * @ author  wilbur
 * @ date   2020/12/17 22:12
 *
 *      ��ʱ������Ҫѡ��һ������ X��ʹ���ǿ��Խ������ư���������ֳ� 1�������飺
        * // ÿ�鶼�� X ���ơ�
        * // �������е����϶�д����ͬ��������
 *
 *  ÿ�����ֵĿ�������������X�ı�����ֻ����������ÿX���Ʒ�Ϊ1�飬��ÿ���Ƶ����ֶ���ͬ), ��X>1���ɴˣ�����ת��������: ÿ�ֿ������������Լ����
 *
 *  2������gcdֱ��շת�������������������������Լ����
 *
 * ���������е�gcd�����֪��
 *  gcd(a,b,c) =gcd(gcd(a,b),c)
 */
public class HasGroupsSizeX914 {
    public boolean hasGroupsSizeX(int[] deck) {
        //����
        int[] count = new int[10000];
        for (int i : deck) {
            count[i]++;
        }
        int X = 0;
        for (int cnt : count) {
            if (cnt > 0) {
                X = gcd(X, cnt);
                if (X == 1) { // ���ĳ����gcd��1��ֱ�ӷ���false
                    return false;
                }
            }
        }
        return X >= 2;

    }

    // շת�����
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
