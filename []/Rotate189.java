/**
 * @ author  wilbur
 * @ date   2020/11/29 18:20
 *
 *
 *                                      ����һ�����飬�������е�Ԫ�������ƶ� k ��λ�ã����� k �ǷǸ�����
 *
 *
 */
public class Rotate189 {
    //����
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
    // ԭ���������±�Ϊ ii �����ǰ����ŵ� (i+k)\%���鳤��(i+k)%���鳤�� ��λ�á�Ȼ����µ����鿽����ԭ������
    public  void  rotate1(int[]nums,int k){
        int[] temp =new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[(i+k)% nums.length]=nums[i];
        }
        for (int j=0;j< nums.length;j++){
            nums[j]=temp[j];
        }
    }
    //ԭ�ػ�λ
}
