/**
 * @ author  wilbur
 * @ date   2020/12/11 19:56
 * <p>
 * <p>
 * ����һ��������������A��������Ҫ�õ�ͨ�� A ���½�·������С�͡�
 * <p>
 * �½�·�����Դӵ�һ���е��κ�Ԫ�ؿ�ʼ������ÿһ����ѡ��һ��Ԫ�ء�����һ��ѡ���Ԫ�غ͵�ǰ����ѡԪ��������һ�С�
 * <p>
 * dp[i][j] ������λ�õ���С��
 *
 * �������ѧ����
 * 1������ԭ�ش���
 * ֱ����ԭ���� A �ϼ��� dp(r, c)����Ϊ���һ�� A ��ֵ���� dp ��ֵ ��������Ǵӵ����ڶ��п�ʼ���������Ͻ��ж�̬�滮��״̬ת�Ʒ���Ϊ��
 *                                                  A[r][c] = A[r][c] + min{A[r + 1][c - 1], A[r + 1][c], A[r + 1][c + 1]}
 * ע����Ҫ�������߽����������ڵ�һ�к����һ��ֻ���½�������λ�á�
 * �����ǹٷ����� �߽紦��    ��c>0��  (c+1<N)
 *
 * 2��ֱ�Ӷ�ԭ���� �Ӷ�һ��0���������� MAX_VALUE��ֱ�ӽ���߽����⣨�ӿǣ�
 * ע��ӿǺ� ״̬ת�Ʒ��������ı�
 * dp[i][j]=min(dp[i?1][j?1],dp[i?1][j],dp[i?1][j+1])+A[i][j]  ---�� dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i - 1][j + 1]) + A[i-1][j-1]
 */
public class MinFallingPathSum931 {
    public int minFallingPathSum1(int[][] A) {
        //ԭ���޸�
        int N = A.length;
        //ע��--r  --c
        for (int r = N - 2; r >= 0; --r) {
            for (int c = 0; c < N; ++c) {
                // best = min(A[r+1][c-1], A[r+1][c], A[r+1][c+1])
                int best = A[r + 1][c];
                if (c > 0)
                    best = Math.min(best, A[r + 1][c - 1]);
                if (c + 1 < N)
                    best = Math.min(best, A[r + 1][c + 1]);
                A[r][c] += best;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int x : A[0])
            ans = Math.min(ans, x);
        return ans;
    }

    //�׿�
    public int minFallingPathSum2(int[][] A) {
        // ��dp[i][j]Ϊ��i, jλ�õ���С·����
        int len = A.length;
        int[][] dp = new int[len + 1][len + 2];

        // �׿Ǵ���
        for (int i = 0; i < len + 1; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][len + 1] = Integer.MAX_VALUE;
        }
        for (int j = 0; j < len + 2; j++) {
            dp[0][j] = 0;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < len + 1; i++) {
            for (int j = 1; j < len + 1; j++) {
                dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i - 1][j + 1]) + A[i - 1][j - 1];
            }
        }
        for (int i = 1; i < len + 1; i++) {
            ans = Math.min(ans, dp[len][i]);
        }
        return ans;
    }
}


