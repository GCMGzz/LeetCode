/**
 * @ author  wilbur
 * @ date   2020/12/17 22:12
 *
 *      此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1组或更多组：
        * // 每组都有 X 张牌。
        * // 组内所有的牌上都写着相同的整数。
 *
 *  每种数字的卡牌张数必须是X的倍数（只有这样才能每X张牌分为1组，且每组牌的数字都相同), 且X>1。由此，本题转换成了求: 每种卡牌张数的最大公约数。
 *
 *  2个数求gcd直接辗转相除法，至于如何求多个数的最大公约数：
 *
 * 根据数论中的gcd结合律知：
 *  gcd(a,b,c) =gcd(gcd(a,b),c)
 */
public class HasGroupsSizeX914 {
    public boolean hasGroupsSizeX(int[] deck) {
        //计数
        int[] count = new int[10000];
        for (int i : deck) {
            count[i]++;
        }
        int X = 0;
        for (int cnt : count) {
            if (cnt > 0) {
                X = gcd(X, cnt);
                if (X == 1) { // 如果某步中gcd是1，直接返回false
                    return false;
                }
            }
        }
        return X >= 2;

    }

    // 辗转相除法
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
