/**
 * @ author  wilbur
 * @ date   2020/11/28 19:37
 *
 *
 *              ����һ������ M x N ��Ԫ�صľ���M �У�N �У������ԶԽ��߱�����˳�򷵻���������е�����Ԫ��
 */
public class FindDiagonalOrder498 {
    public  static  int[]findDiagonalOrder(int[][]matrix){
        int rowL= matrix.length;
        int columnL = matrix[0].length;
        int count = rowL+columnL-1;
        int [] ans = new int[count];
        int m =0;// ������
        int n=0;//������
        int  index =0;

        if (matrix.length==0){
            return new int[0];
        }

        for (int i=0;i<count;i++){
            //����
            if (i%2==0){
                while (m<=0&&n<columnL){
                    ans[index]=matrix[m][n];
                    m--;
                    n++;
                }
                //Խ����� ������ת���µ��������
                //   1      2       3
                //   4      5       6
                //   7      8       9
                //1��1 -->2  ����ת����
                if (n<columnL){
                    m++;
                }else {
                    //3-->6 ����ת����
                    m=m+2;
                    n--;
                }
            }else{ //����
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
