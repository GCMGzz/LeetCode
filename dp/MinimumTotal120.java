import java.util.List;

/**
 * @ author  wilbur
 * @ date   2020/12/8 22:55
 * <p>
 * //����һ�������Σ��ҳ��Զ����µ���С·���͡�ÿһ��ֻ���ƶ�����һ�������ڵĽ���ϡ�
 * // ���ڵĽ�� ������ָ���� �±� �� ��һ�����±� ��ͬ���ߵ��� ��һ�����±� + 1 ��������㡣
 */
public class MinimumTotal120 {

    //dp[i][j] ��ʾ�ӵ� (i, j)(i,j) ���ױߵ���С·���͡�
    public int minimumTotal1(List<List<Integer>> triangle) {
        int n = triangle.size();

        //1�����ϵ���
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        if (triangle.size() == 0 || triangle == null) return 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    // ��������⴦��
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == i) {
                    // ���Ҷ����⴦��
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        // dp���һ�м�¼����С·��
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[n - 1][i]);
        }
        return res;
    }

    // dp ���µ���  ֱ�����dp[0][0]  ����ý��бȽ�
    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    //�Ż�
//�����������У����Ƕ�����һ�� N�� N �� �� dp ���飨N�������ε���������
//������ʵ�ʵ��������Ƿ��֣����� dp[i][j]dp[i][j] ʱ��ֻ�õ�����һ�е� dp[i + 1][j] dp[i+1][j] �� dp[i + 1][j + 1]dp[i+1][j+1]��
//��� dp���鲻��Ҫ���� N �У�ֻҪ���� 1 �о���������
//����������΢�޸�һ���������룬�� i���ڵ�ά��ȥ�������£����Ϳ��Խ� O(N^2)O(N2) �Ŀռ临�Ӷ��Ż��� O(N)O(N) ��

    public int minimumTotal3(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];

    }
}
