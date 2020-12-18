/**
 * @ author  wilbur
 * @ date   2020/12/18 19:38
 *
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 *
 * 先记录第一行第一列是否有0，然后利用第一行第一列作为标记，先清除非第一行或非第一列的数据，最后根据第一列第一列是否有0来清除第一行第一列。
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
