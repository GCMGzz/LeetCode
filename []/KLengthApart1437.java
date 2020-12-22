/**
 * @ author  wilbur
 * @ date   2020/12/22 13:19
 *
 * //给你一个由若干 0 和 1 组成的数组 nums 以及整数 k。如果所有 1 都至少相隔 k 个元素，则返回 True ；否则，返回 False 。
 */
public class KLengthApart1437 {
    public boolean kLengthApart(int[] nums, int k) {
        int pre =-1,pro =-1;
        //找到数组中第一个1的位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==1){
                pre = i;
                break;
            }
        }

        //第一个1位置为pre  后一个为pro 满足条件 pre =pro ；
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
