/**
 * @ author  wilbur
 * @ date   2020/12/24 16:56
 *
 * //��������������n �� start ��
 * //
 * // ���� nums ����Ϊ��nums[i] = start + 2*i���±�� 0 ��ʼ���� n == nums.length ��
 * //
 * // �뷵�� nums ������Ԫ�ذ�λ���XOR����õ��Ľ����
 */

public class XorOperation1486 {
    public int xorOperation(int n, int start) {
        int temp[] = new int[n];
        int ans =0;
        for (int i=0;i<n;i++){
            temp[i]=start+2*i;
        }
        for (int i = 0; i < n; i++) {
            ans^=temp[i];
        }
        return ans;
    }
}
