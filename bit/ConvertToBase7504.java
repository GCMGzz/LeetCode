/**
 * @ author  wilbur
 * @ date   2020/12/23 15:05
 *
 * //����һ������������ת��Ϊ7���ƣ������ַ�����ʽ�����
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
        //����ȡ��
        do {
            int temp = num % 7;
            //��int��תΪchar��
            sb.append((char) ('0' + temp));
            num /= 7;
        } while (num != 0);
        //��ת���
        ans += sb.reverse().toString();
        return ans;
    }
}
