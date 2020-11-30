import java.util.LinkedList;
import java.util.List;

/**
 * @ author  wilbur
 * @ date   2020/11/30 16:26
 *
 *                      //给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *                      思路同59题一样
 *                      顺时针输出即遵循从左到右，从上到下，从右到左，从下到上
 *                      注意边界条件
 */
public class SpiralOrder54 {
    public List<Integer> spiralOrder(int[][] matrix) {

        LinkedList<Integer> ans = new LinkedList<>();
        int L = 0, R = matrix[0].length - 1, T = 0, B = matrix.length - 1;
        int num = matrix.length * matrix[0].length;
        if (matrix == null || matrix.length == 0)
            return ans;
        while (num >= 1) {
            //从左到右
            for (int i = L; i <= R && num>= 1; i++) {
                ans.add(matrix[L][i]);
                num--;
            }
            T++;
            //从上到下
            for (int i = T; i <= B && num >= 1; i++) {
                ans.add(matrix[i][R]);
                num--;
            }
            R--;
            //从右到左
            for (int i = R; i >= L && num >= 1; i--) {
                ans.add(matrix[B][i]);
                num--;
            }
            B--;
            //从下到上
            for (int i = B; i >= T && num>= 1; i--) {
                ans.add(matrix[i][L]);
                num--;
            }
            L++ ;
        }
        return ans;
    }
}
