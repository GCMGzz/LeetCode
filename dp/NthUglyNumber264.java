/**
 * @ author  wilbur
 * @ date   2020/12/5 16:14
 *
 * 编写一个程序，找出第 n 个丑数。
 *丑数就是 质因数 只包含 2, 3, 5 的正整数。
 *
 * 每个丑数即由 2,  3，5 相乘得到
 * 利用3指针 实现归并排序  选出最小的丑数添加到数组中
 *
 * 一开始，丑数只有{1}，1可以同2，3，5相乘，取最小的1×2=2添加到丑数序列中。
 * 现在丑数中有{1，2}，在上一步中，1已经同2相乘过了，所以今后没必要再比较1×2了，我们说1失去了同2相乘的资格，u1++,让其指向下一个丑数
 *
 */
public class NthUglyNumber264 {
    public int nthUglyNumber(int n) {
        if (n == 0) return 0;
        //丑数数组
        int[] dp = new int[n];
        dp[0] = 1;
        int u1 = 0, u2 = 0, u3 = 0;
        for (int i = 1; i < n; i++) {
            int temp1 = 2 * dp[u1];
            int temp2 = 3 * dp[u2];
            int temp3 = 5 * dp[u3];
            //选出最小的丑数依次添加到数组中
            dp[i] = Math.min(Math.min(temp1, temp2), temp3);
            if (dp[i] == temp1) u1++;
            if (dp[i] == temp2) u2++;
            if (dp[i] == temp3) u3++;
        }
        return dp[n - 1];
    }
}
