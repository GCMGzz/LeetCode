/**
 * @ author  wilbur
 * @ date   2020/12/24 21:06
 *
 *
 * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 *
 *
 */
public class FindComplement476 {
    public int findComplement(int num) {
        int temp = num, c = 0;
        while(temp > 0){
            temp >>= 1;
            c =  (c << 1) + 1;
        }
        return num ^ c;
    }
}
