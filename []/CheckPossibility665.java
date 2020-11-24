/**
 * @ author  wilbur
 * @ date   2020/11/24 13:27
 *
 *                                      //����һ������Ϊ n ���������飬�����ж��� ��� �ı� 1 ��Ԫ�ص�����£��������ܷ���һ���ǵݼ����С�
 * //
 *                                  // ��������������һ���ǵݼ����еģ� �������������е� i (0 <= i <= n-2)�������� nums[i] <= nums[i + 1]��
 *
 *                                     X   Y    Z
 *                                    �����鳤��С��3ʱ�������Ҫ����һ�ξ�����������
 *                                   �����鳤�ȴ��ڵ���3ʱ������ǰһ��Ԫ��y���ں�һ��Ԫ��zʱ��
 *                                  ���y��ǰԪ��x�����ڣ���y=z���ɣ���x���ڣ������������
 *
 *
 *                                  Ҫ������������Ҫ���µ�����
 *                                1����x<z,��y=z
 *                               2����x>z,��z=y
 *                              3 , ��x=z,��y=z
 *                            �ۺ����Ͽ��Եõ�����x������x>z������z=y��������y=z
 *                          ���������2�ξͲ�����������
 *
 *
 *

 */
public class CheckPossibility665 {
    public boolean checkPossibility(int[] nums) {
        if (nums.length<3)
            return true;

        int count = 0;
        for (int i = 0; i < nums.length - 1 && count <= 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                if (i - 1 >= 0 && nums[i - 1] > nums[i + 1]) {
                    nums[i + 1] = nums[i];
                } else {
                    nums[i] = nums[i + 1];
                }
            }
        }
        return count <= 1;

    }
}
