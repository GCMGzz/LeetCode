import java.util.Arrays;

/**
 * @ author  wilbur
 * @ date   2020/11/29 13:19
 *
 *              //������һЩ�����������ȣ���ɵ����� A����������������������ɵġ������Ϊ��������ε�����ܳ���
 * //
 * //          ��������γ��κ������Ϊ��������Σ����� 0��
 */
public class LargestPerimeter976 {
    public int largestPerimeter(int[] A) {

        Arrays.sort(A);
        int ans =0;
        for (int i = A.length-1; i >1;i--) {
            //����֮�ʹ��ڵ����ߣ�����֮��С�ڵ�����
            if (A[i]-A[i-2]<A[i-1]&&A[i-2]+A[i-1]>A[i]){
                ans= A[i]+A[i-1]+A[i-2];
                break;
            }
        }
        return  ans;
    }
}
