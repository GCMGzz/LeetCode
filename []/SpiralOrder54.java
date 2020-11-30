import java.util.LinkedList;
import java.util.List;

/**
 * @ author  wilbur
 * @ date   2020/11/30 16:26
 *
 *                      //����һ������ m x n ��Ԫ�صľ���m ��, n �У����밴��˳ʱ������˳�򣬷��ؾ����е�����Ԫ�ء�
 *                      ˼·ͬ59��һ��
 *                      ˳ʱ���������ѭ�����ң����ϵ��£����ҵ��󣬴��µ���
 *                      ע��߽�����
 */
public class SpiralOrder54 {
    public List<Integer> spiralOrder(int[][] matrix) {

        LinkedList<Integer> ans = new LinkedList<>();
        int L = 0, R = matrix[0].length - 1, T = 0, B = matrix.length - 1;
        int num = matrix.length * matrix[0].length;
        if (matrix == null || matrix.length == 0)
            return ans;
        while (num >= 1) {
            //������
            for (int i = L; i <= R && num>= 1; i++) {
                ans.add(matrix[L][i]);
                num--;
            }
            T++;
            //���ϵ���
            for (int i = T; i <= B && num >= 1; i++) {
                ans.add(matrix[i][R]);
                num--;
            }
            R--;
            //���ҵ���
            for (int i = R; i >= L && num >= 1; i--) {
                ans.add(matrix[B][i]);
                num--;
            }
            B--;
            //���µ���
            for (int i = B; i >= T && num>= 1; i--) {
                ans.add(matrix[i][L]);
                num--;
            }
            L++ ;
        }
        return ans;
    }
}
