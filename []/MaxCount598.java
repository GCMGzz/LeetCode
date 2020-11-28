/**
 * @ author  wilbur
 * @ date   2020/11/28 13:47
 *
 *
 *              /����һ����ʼԪ��ȫ��Ϊ 0����СΪ m*n �ľ��� M �Լ��� M �ϵ�һϵ�и��²�����
 *
 *           �����ö�ά�����ʾ�����е�ÿ��������һ���������������� a �� b �������ʾ�������ǽ����з��� 0 <= i < a �Լ� 0 <= j < b ��Ԫ��
 *          M[i][j] ��ֵ������ 1��
 *        ��ִ�и�����һϵ�в���������Ҫ���ؾ����к������������Ԫ�ظ�����
 *
 *          a=b --> a*b
 *          a>b --> b*b                  -->  ����ɾ���ĺ���������Сֵ���
 *          a<b --> a*b
 */
public class MaxCount598 {
    public int maxCount(int m, int n, int[][] ops) {
        if(ops.length == 0) {
            return m * n;
        }
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for (int i = 0; i < ops.length; i++) {
            if(ops[i][0] < minX) {
                minX = ops[i][0];
            }
            if(ops[i][1] < minY) {
                minY = ops[i][1];
            }
        }
        return minX * minY;
    }
}
