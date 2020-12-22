/**
 * @ author  wilbur
 * @ date   2020/12/22 13:19
 *
 * //����һ�������� 0 �� 1 ��ɵ����� nums �Լ����� k��������� 1 ��������� k ��Ԫ�أ��򷵻� True �����򣬷��� False ��
 */
public class KLengthApart1437 {
    public boolean kLengthApart(int[] nums, int k) {
        int pre =-1,pro =-1;
        //�ҵ������е�һ��1��λ��
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==1){
                pre = i;
                break;
            }
        }

        //��һ��1λ��Ϊpre  ��һ��Ϊpro �������� pre =pro ��
        for (int j=pre+1;j<nums.length;j++){
            if (nums[j]==1){
                pro=j;
                if (pro-pre<k+1){
                    return false;
                }else{
                    pre=pro;
                }
            }
        }
        return true;
    }
}
