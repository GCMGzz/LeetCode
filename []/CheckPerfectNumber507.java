/**
 * @ author  wilbur
 * @ date   2020/12/22 17:02
 *
 * //����һ�� ��������������ͳ������������������ ������ ֮����ȣ����ǳ���Ϊ ������������
 * // ����һ�� ���� n�� ����������������� true�����򷵻� false
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
