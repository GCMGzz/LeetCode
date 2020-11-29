/**
 * @ author  wilbur
 * @ date   2020/11/29 18:20
 *
 *
 *                                      给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 *
 */
public class Rotate189 {
    //暴力
    public void rotate(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }
    // 原本数组里下标为 ii 的我们把它放到 (i+k)\%数组长度(i+k)%数组长度 的位置。然后把新的数组拷贝到原数组中
    public  void  rotate1(int[]nums,int k){
        int[] temp =new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[(i+k)% nums.length]=nums[i];
        }
        for (int j=0;j< nums.length;j++){
            nums[j]=temp[j];
        }
    }
    //原地换位
}
