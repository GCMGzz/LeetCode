/**
 * @ author  wilbur
 * @ date   2020/12/5 20:10
 *
 * ����һ�������Ǹ������� m x n ���� grid �����ҳ�һ�������Ͻǵ����½ǵ�·����ʹ��·���ϵ������ܺ�Ϊ��С��
 *  ˵����ÿ��ֻ�����»��������ƶ�һ����
 *
 *  ע��߽�
 *  �����·����dpֵ = ��ǰ�ڵ�� ������dp�ڵ� + ��ǰ�ڵ��ֵ
 *  ���ϱ�·����dpֵ = ��ǰ�ڵ�� ������dp�ڵ� + ��ǰ�ڵ��ֵ
 */
public class MinPathSum64 {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //0 0 ��㣬ѭ������
                if (i == 0 && j == 0) continue;
                else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];

    }
}
