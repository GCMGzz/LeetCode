/**
 * @ author  wilbur
 * @ date   2020/11/3 16:43
 *
 *                                                                  //给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a方 + b方 = c 。
 *                                                                  二分法
 */
public class JudgeSquareSum633 {


    public boolean judgeSquareSum1(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b)
                return true;
        }
        return false;
    }
    public boolean judgeSquareSum(int c) {

        for (long a = 0; a * a <= c; a++) {
            int b = c - (int) (a * a);
            if (serach(0, b, b))
                return true;
        }
        return false;
    }


    public boolean serach(long start, long end, int n) {
        if (start > end)
            return false;
        long mid = start + (end - start) / 2;
        if (mid * mid == n)
            return true;
        if (mid * mid > n)
            return serach(start, mid - 1, n);
        return serach(mid + 1, end, n);
    }
}
