import java.util.Arrays;

/**
 * @ author  wilbur
 * @ date   2020/11/24 13:20
 *
 *                          //����һ������Ϊ n �ķǿ��������飬�ҵ�����������Ԫ����ȵ���С�ƶ�������ÿ���ƶ�����ʹ n - 1 ��Ԫ������ 1��
 *                          ÿ��ʹn-1��Ԫ��+1 ��ȫ = ÿ��ʹ1��Ԫ��-1Ȼ������Ԫ��+1
 *                          ����ֻ���ҳ���ÿ����1��Ԫ��-1�����ٴκ�����Ԫ�����
 */
public class MinMoves453 {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int  ans =0;
        for (int i = 0; i < nums.length; i++) {
            ans+=nums[i]-nums[0];
        }
        return  ans;

    }
}
