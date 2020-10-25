import java.util.Stack;

/**
 * @ author  wilbur
 * @ date   2020/10/25 15:45
 *
 *                              给定一个列表temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是[1, 1, 4, 2, 1, 1, 0, 0]
 *                                 递减栈 ，利用数组下标
 *
 */
public class DailyTemperatures739 {

    //1
    public int[] dailyTemperatures1(int[] T) {
        int[] ans = new int[T.length];
        ans[T.length - 1] = 0;
        for (int i = 0; i < T.length - 1; i++) {
            for (int j = i + 1; j <= T.length - 1; j++) {
                if (T[j] > T[i]) {
                    ans[i] = j - i;
                    break;
                }
            }
        }
        return ans;
    }

    //2 、递减栈
    public int[] dailyTemperatures2(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int length = T.length;
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            //数组元素比栈顶元素大时，得到栈顶元素的数组下标
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int pre = stack.pop();
                //result[0]=1-0;
                result[pre] = i - pre;
            }
            //下标入栈
            stack.add(i);

        }
        return result;
    }
}
