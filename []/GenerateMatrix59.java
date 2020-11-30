/**
 * @ author  wilbur
 * @ date   2020/11/30 16:03
 *
 *
 *                          //给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *                          来自题解，简单直观
 *                          顺时针即始终遵循//从左到右，从上到下，从右到左，从下到上
 *                           num <= tar 时，始终按照 从左到右 从上到下 从右到左 从下到上 填入顺序循环，每次填入后：
 *                          执行 num += 1：得到下一个需要填入的数字；
 *                         更新边界：例如从左到右填完后，上边界 t += 1，相当于上边界向内缩 1。
 *                          使用num <= tar而不是l < r || t < b作为迭代条件，是为了解决当n为奇数时，矩阵中心数字无法在迭代过程中被填充的问题。
 *
 */
public class GenerateMatrix59 {

    public int[][] generateMatrix(int n) {

        int[][] ans = new int[n][n];
        //从左到右，从上到下，从右到左，从下到上
        int L = 0, R = n - 1, T = 0, B = n - 1;
        int num = 1, tar = n * n;
        while (num <= tar) {
            for (int i = L; i <= R; i++) ans[T][i] = num++;
            T++;
            for (int i = T; i <= B; i++) ans[i][R] = num++;
            R--;
            for (int i = R; i >= L; i--) ans[B][i] = num++;
            B--;
            for (int i = B; i >= T; i--) ans[i][L] = num++;
            L++;
        }
        return ans;
    }
}
