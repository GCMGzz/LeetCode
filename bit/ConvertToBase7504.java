/**
 * @ author  wilbur
 * @ date   2020/12/23 15:05
 *
 * //给定一个整数，将其转化为7进制，并以字符串形式输出。
 *
 */
public class ConvertToBase7504 {
    public String convertToBase7(int num) {
        String ans = "";
        if (num < 0) {
            num = 0 - num;
            ans += "-";
        }
        StringBuilder sb = new StringBuilder();
        //除基取余
        do {
            int temp = num % 7;
            //将int型转为char型
            sb.append((char) ('0' + temp));
            num /= 7;
        } while (num != 0);
        //反转输出
        ans += sb.reverse().toString();
        return ans;
    }
}
