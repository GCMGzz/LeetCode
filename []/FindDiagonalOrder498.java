/**
 * @ author  wilbur
 * @ date   2020/11/28 19:37
 *
 *
 *              给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素
 */
public class FindDiagonalOrder498 {
    public  static  int[]findDiagonalOrder(int[][]matrix){
        int rowL= matrix.length;
        int columnL = matrix[0].length;
        int count = rowL+columnL-1;
        int [] ans = new int[count];
        int m =0;// 行坐标
        int n=0;//列坐标
        int  index =0;

        if (matrix.length==0){
            return new int[0];
        }

        for (int i=0;i<count;i++){
            //右上
            if (i%2==0){
                while (m<=0&&n<columnL){
                    ans[index]=matrix[m][n];
                    m--;
                    n++;
                }
                //越界情况 ，右上转左下的两种情况
                //   1      2       3
                //   4      5       6
                //   7      8       9
                //1、1 -->2  右上转左下
                if (n<columnL){
                    m++;
                }else {
                    //3-->6 右上转左下
                    m=m+2;
                    n--;
                }
            }else{ //左下
                while(m<rowL&&n>=0){
                    ans[index]=matrix[m][n];
                    index++;
                    m++;
                    n--;
                }
                if(m<rowL){
                    n++;
                }else{
                    m--;
                    n=n+2;
                }
            }
        }
        return ans;

    }
}
