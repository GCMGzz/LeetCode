import java.util.Arrays;
import java.util.HashMap;

/**
 * @ author  wilbur
 * @ date   2020/10/23 21:50
 *
 *                                            给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 *
 *                                            例  n = 12
 *                                             先把 n 减去一个平方数，然后求剩下的数分解成平方数和所需的最小个数
 *
 *                                             把 n 减去 1, 然后求出 11 分解成平方数和所需的最小个数,记做 n1
 *                                             那么当前方案总共需要 n1 + 1 个平方数
 *
 *                                             把 n 减去 4, 然后求出 8 分解成平方数和所需的最小个数,记做 n2
 *                                             那么当前方案总共需要 n2 + 1 个平方数
 *
 *                                             把 n 减去 9, 然后求出 3 分解成平方数和所需的最小个数,记做 n3
 *                                             那么当前方案总共需要 n3 + 1 个平方数
 *
 *                                             下一个平方数是 16, 大于 12, 不能再分了。
 *
 *                                             接下来我们只需要从 (n1 + 1), (n2 + 1), (n3 + 1) 三种方案中选择最小的个数,
 *                                             此时就是 12 分解成平方数和所需的最小个数了
 *
 *                                             至于求 11、8、3 分解成最小平方数和所需的最小个数继续用上边的方法去求
 *
 *                                             直到如果求 0 分解成最小平方数的和的个数, 返回 0 即可
 *
 */
public class NumSquares279 {
    //    public int numSquares(int n) {
//        return helper(n);
//    }
//
//    public int helper(int n) {
//        if (n == 0) return 0;
//        int min = Integer.MAX_VALUE;
//        for (int i = 1; i * i <= n; i++) {
//            min = Math.min(min, helper(n - i * i) + 1);
//        }
//        return min;
//    }
    //会造成很多重复计算 ，利用map剪枝
    public int numSquares(int n) {
        return helper(n, new HashMap<Integer, Integer>());
    }

    private int helper(int n, HashMap<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            min = Math.min(min, helper(n - i * i, map) + 1);
        }
        map.put(n, min);
        return min;
    }

    //dp
    public int numSquaresDp(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        //依次求出 1, 2... 直到 n 的解
        for (int i = 1; i <= n; i++) {
            //依次减去一个平方数
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}