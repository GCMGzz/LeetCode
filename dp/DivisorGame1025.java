/**
 * @ author  wilbur
 * @ date   2020/12/3 13:12
 *
 *
 *  ѡ����һ x������ 0 < x < N �� N % x == 0 ��
 *  �� N - x �滻�ڰ��ϵ����� N ��
 *  ����˿�ͱ���һ������Ϸ�����������ж�������˿���ֿ��֡�
 *  �������޷�ִ����Щ�������ͻ������Ϸ��
 * ֻ���ڰ���˿����Ϸ��ȡ��ʤ��ʱ�ŷ��� True�����򷵻� False��
 */
public class DivisorGame1025 {
    //��ѧ����
    public boolean divisorGame1(int N) {
        return N%2==0;
    }
    //dp
    public boolean divisorGame2(int N) {
        if (N == 1) {
            return false;
        }

        // Ϊ�˲������±�ƫ�ƣ������� 1 ��
        // dp[i]���ڰ��ϵ�����Ϊ i ʱ����ǰ����ѡ������Ƿ��Ӯ
        boolean[] dp = new boolean[N + 1];
        // ��������
        dp[1] = false;
        dp[2] = true;

        // �����Եķ�ʽ�𲽵��Ƶõ����
        for (int i = 3; i <= N; i++) {
            for (int j = 1; j <= i / 2; j++) {
                // ֻҪ������ѡ�������֮һ�����öԷ��䣬�ڵ�ǰ��һ�����ǾͿ���Ӯ
                if ((i % j == 0) && !dp[i - j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        // �������⣺����� dp[N]
        return dp[N];
    }

}
