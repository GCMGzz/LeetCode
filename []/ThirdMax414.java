/**
 * @ author  wilbur
 * @ date   2020/12/24 21:00
 *
 * ����һ���ǿ����飬���ش������е������������������ڣ��򷵻���������������Ҫ���㷨ʱ�临�Ӷȱ�����O(n)��
 *
 *
 *
 * �ǿ����飬���Գ��ȴ���0��
 * ÿ�θ��µ�һ��ֵ�͵ڶ���ֵʱ�������ݸ�������ֵ
 * ע���ظ�������������жϵ�������û�и��¹�
 */
public class ThirdMax414 {
    public int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        //��СֵΪLong���͵���Сֵ����Ϊ����������ʹ��Integer���͵���Сֵ���³���
        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;
        for (int n : nums) {
            if (n > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = n;
            } else if (firstMax == n){
                continue;
            }else  if (n > secondMax) {
                thirdMax = secondMax;
                secondMax = n;
            } else if (n == secondMax) {
                continue;
            } else if (n > thirdMax) {
                thirdMax = n;
            }
        }
        return thirdMax == Long.MIN_VALUE ? (int)firstMax : (int)thirdMax;
    }
}
