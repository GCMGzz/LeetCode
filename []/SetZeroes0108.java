/**
 * @ author  wilbur
 * @ date   2020/12/18 19:38
 *
 * ��дһ���㷨����M �� N������ĳ��Ԫ��Ϊ0���������ڵ����������㡣
 *
 *
 * �ȼ�¼��һ�е�һ���Ƿ���0��Ȼ�����õ�һ�е�һ����Ϊ��ǣ�������ǵ�һ�л�ǵ�һ�е����ݣ������ݵ�һ�е�һ���Ƿ���0�������һ�е�һ�С�
 */
public class SetZeroes0108 {
    public void setZeroes(int[][] matrix) {
        if (matrix==null||matrix.length==0) return;
        boolean rowFlag =  false ;
        boolean colFlag =  false ;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0]== 0) {
                colFlag = true ;
            }
        }

        for (int i = 0; i < matrix[0].length ; i++) {
            if (matrix[0][i] == 0 ){
                rowFlag=true;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0  || matrix[i][0] == 0){
                    matrix[i][j]=0;
                }
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (rowFlag){
                matrix[0][i]=0;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (colFlag){
                matrix[i][0]=0;
            }
        }

    }
}
