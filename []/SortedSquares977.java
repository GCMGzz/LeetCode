import java.util.Arrays;

/**
 * @ author  wilbur
 * @ date   2020/10/16 11:14
 *
 *                               给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 */


public class SortedSquares977 {
    public int[] sortedSquares(int[] A) {

        int[] ans = new int[A.length];
        for (int i = 0; i < A.length; ++i) {
            ans[i] = A[i] * A[i];
        }
        Arrays.sort(ans);
        return ans;

    }
}
