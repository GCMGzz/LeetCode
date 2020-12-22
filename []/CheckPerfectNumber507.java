/**
 * @ author  wilbur
 * @ date   2020/12/22 17:02
 *
 * //对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
 * // 给定一个 整数 n， 如果是完美数，返回 true，否则返回 false
 */
public class CheckPerfectNumber507 {
    public boolean checkPerfectNumber(int num) {
        switch (num) {
            case 6:
            case 28:
            case 496:
            case 8128:
            case 33550336:
                return  true;
        }
        return false;
    }
}
