/**
 * @ author  wilbur
 * @ date   2020/12/13 21:43
 *
 * 本题与931 的区别是 选出来的数字中，相邻数字不在原数组的同一列
 */
public class MinFallingPathSum1289 {
    public int minFallingPathSum(int[][] arr) {
        int  n= arr.length;
        int [][]dp =new int[n][n];
        for (int  j=0;j<n ;j++){
            dp[0][j]=arr[0][j];
        }
        int []preRowMin =getPreRowMin(dp,0);
        for (int i = 1; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                int preRow =preRowMin[j];
                dp[i][j]=preRow+arr[i][j];
            }
            preRowMin =getPreRowMin(dp,i);
        }
        int ans =Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans= Math.min(dp[n-1][j],ans);
        }
        return  ans;
    }
    public  static int[] getPreRowMin(int [][]dp,int i  ) {
        int  n= dp.length;
        int []minArr = new int [n];
        int min = Integer.MAX_VALUE;
        int minIndex =-1;
        for (int j = 0; j < n; j++) {
            if (dp[i][j]<min){
                min= dp[i][j];
                minIndex= j;
            }
        }
        int secMin =Integer.MAX_VALUE;
        for (int j =0;j<n;j++){
            if (j!=minIndex&&dp[i][j]<secMin){
                secMin=dp[i][j];
            }
        }
        for (int j = 0; j < n; j++) {
            if(j==minIndex){
                minArr[j]=secMin;
            }else{
                minArr[j]=min;
            }
        }
        return  minArr;
    }
}
