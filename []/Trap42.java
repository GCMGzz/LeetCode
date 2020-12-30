/**
 * @ author  wilbur
 * @ date   2020/12/30 14:06
 * <p>
 * ���� n ���Ǹ�������ʾÿ�����Ϊ 1 �����ӵĸ߶�ͼ�����㰴�����е����ӣ�����֮���ܽӶ�����ˮ��
 */
public class Trap42 {
    //ľͰЧӦ�뵽  ��ÿһ���ҵ��� **���**  ��  **�ұ�** �����**��С**��һ�н����жϣ�
    //1���ȸ��иߣ�����֮�Ϊ�����ܽӵ���ˮ��
    //2���������Ȼ���С�ڸ��У����ܽ���ˮ��
    public int trap1(int[] height) {
        int n = height.length;
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            int maxL = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > maxL) maxL = height[j];
            }

            int maxR = 0;
            for (int j = i + 1; j <= n - 1; j++) {
                if (height[j] > maxR) maxR = height[j];
            }

            int max = Math.min(maxL, maxR);
            if (max > height[i]) {
                ans += (max - height[i]);
            }
        }
        return ans;
    }

    //���������� ÿһ�ж�Ҫ�����������ߡ��ұ���ߡ�ʵ���ϴ����ظ�����
    //ͨ��dp �Կռ任ʱ��
    public int trap2(int[] height) {
        int n = height.length;
        int[] maxL = new int[n];
        int[] maxR = new int[n];
        int ans = 0;
        for (int i = 1; i <= n - 1; i++) {
            maxL[i] = Math.max(maxL[i - 1], height[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            maxR[i]=Math.max(maxR[i+1],height[i+1] );
        }
        for (int i = 1; i < n-1; i++) {
            int min =Math.min(maxL[i],maxR[i]);
            if (min>height[i])
                ans+=(min-height[i]);
        }
        return ans;
    }
}
