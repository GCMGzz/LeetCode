/**
 * @ author  wilbur
 * @ date   2020/12/1 19:54
 *
 *
 *  //在一个给定的数组nums中，总是存在一个最大元素 。
 * //
 * // 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 * //
 * // 如果是，则返回最大元素的索引，否则返回-1。
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
    //直接比较第二大的数和最大数是否满足题意
}
