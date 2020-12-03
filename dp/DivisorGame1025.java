/**
 * @ author  wilbur
 * @ date   2020/12/3 13:12
 *
 *
 *  选出任一 x，满足 0 < x < N 且 N % x == 0 。
 *  用 N - x 替换黑板上的数字 N 。
 *  爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 *  如果玩家无法执行这些操作，就会输掉游戏。
 * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 False。
 */
public class DivisorGame1025 {
    //数学推理
    public boolean divisorGame1(int N) {
        return N%2==0;
    }
    //dp
    public boolean divisorGame2(int N) {
        if (N == 1) {
            return false;
        }

        // 为了不处理下标偏移，多设置 1 格
        // dp[i]：黑板上的数字为 i 时，当前做出选择的人是否会赢
        boolean[] dp = new boolean[N + 1];
        // 最基本情况
        dp[1] = false;
        dp[2] = true;

        // 以线性的方式逐步递推得到结果
        for (int i = 3; i <= N; i++) {
            for (int j = 1; j <= i / 2; j++) {
                // 只要做出的选择的其中之一，能让对方输，在当前这一步我们就可以赢
                if ((i % j == 0) && !dp[i - j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        // 根据题意：输出是 dp[N]
        return dp[N];
    }

}
