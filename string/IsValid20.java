import java.util.Stack;

/**
 * @ author  wilbur
 * @ date   2020/10/24 22:44
 *
 *                                  有效的括号  括号匹配
 *
 */
public class IsValid20 {
    public boolean isValid(String s) {
        if (s.isEmpty())
            return  true;
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()){
            if (c=='(')
                stack.push(')');
            else  if (c=='[')
                stack.push(']');
            else if (c=='{')
                stack.push('}');
            else if (stack.isEmpty()||c!=stack.pop())
                return  false;
        }
        return stack.isEmpty();
    }
}
