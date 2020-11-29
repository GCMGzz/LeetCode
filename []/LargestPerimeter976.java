import java.util.Arrays;

/**
 * @ author  wilbur
 * @ date   2020/11/29 13:19
 *
 *              //给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 * //
 * //          如果不能形成任何面积不为零的三角形，返回 0。
 */
public class LargestPerimeter976 {
    public int largestPerimeter(int[] A) {

        Arrays.sort(A);
        int ans =0;
        for (int i = A.length-1; i >1;i--) {
            //两边之和大于第三边，两边之差小于第三边
            if (A[i]-A[i-2]<A[i-1]&&A[i-2]+A[i-1]>A[i]){
                ans= A[i]+A[i-1]+A[i-2];
                break;
            }
        }
        return  ans;
    }
}
