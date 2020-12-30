/**
 * @ author  wilbur
 * @ date   2020/12/30 14:06
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Trap42 {
    //木桶效应想到  对每一列找到其 **左边**  和  **右边** 最高中**较小**的一列进行判断，
    //1、比该列高，两者之差即为该列能接的雨水量
    //2、与该列相等或者小于该列，则不能接雨水。
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

    //上述方法中 每一列都要计算其左边最高、右边最高。实际上存在重复操作
    //通过dp 以空间换时间
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
