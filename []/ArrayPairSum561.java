import java.util.Arrays;

/**
 * @ author  wilbur
 * @ date   2020/12/22 19:15
 *
 * //��������Ϊ 2n ���������� nums ����������ǽ���Щ���ֳ� n ��, ���� (a1, b1), (a2, b2), ..., (an, bn) ��ʹ��
 * //�� 1 �� n �� min(ai, bi) �ܺ����
 */
public class ArrayPairSum561 {
    public int arrayPairSum(int[] nums) {
        int  ans =0;
        Arrays.sort(nums);
        for (int i=0;i< nums.length;i+=2){
            ans+=nums[i];
        }
        return ans;
    }
}
