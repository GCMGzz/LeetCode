/**
 * @ author  wilbur
 * @ date   2020/12/1 19:54
 *
 *
 *  //��һ������������nums�У����Ǵ���һ�����Ԫ�� ��
 * //
 * // ���������е����Ԫ���Ƿ�������������ÿ���������ֵ�������
 * //
 * // ����ǣ��򷵻����Ԫ�ص����������򷵻�-1��
 */
public class DominantIndex747 {
    public int dominantIndex(int[] nums) {

        if (nums.length<2)  return 0;
        int max=Integer.MIN_VALUE;
        int ans =0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>max) {
                max=nums[i];
                ans=i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[ans]<2*nums[i]&&i!=ans){
                return  -1;
            }
        }
        return ans;

    }
    //ֱ�ӱȽϵڶ��������������Ƿ���������
    public int dominantIndex2(int[] nums) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int firstIndex = -1;
        int secondIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > firstMax) {
                secondMax = firstMax;
                secondIndex = firstIndex;
                firstMax = nums[i];
                firstIndex = i;
            }else if(nums[i] > secondMax) {
                secondMax = nums[i];
                secondIndex = i;
            }
        }
        if(secondMax * 2 <= firstMax) {
            return firstIndex;
        }else {
            return -1;
        }
    }


}
