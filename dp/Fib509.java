/**
 * @author wilbur
 * @date 2020/9/22 14:24
 * @题目描述   斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *                                                                                                    / F(0) = 0,F(1)= 1
 *                                                                                               //F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * @解题思路  递归
 */
public class Fib509 {
    //递归
    public int fib1(int N) {
        if (N <=1) {
            return N;
        } else {
            return  fib1(N - 1) + fib1(N - 2);
        }
    }
    //dp
    public int fib2(int n){
        int []dp =new int[n+1];
        dp[2]=1;
        dp[1]=1;
        for (int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];

    }
}
