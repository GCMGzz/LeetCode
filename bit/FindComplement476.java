/**
 * @ author  wilbur
 * @ date   2020/12/24 21:06
 *
 *
 * ����һ����������������Ĳ����������ǶԸ����Ķ����Ʊ�ʾȡ����
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
