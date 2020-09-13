package algorithms.other;

import java.util.Stack;

/**
 * Created by yangyuan on 2020/8/1.
 * 150. 逆波兰表达式求值
 *
 * 根据 逆波兰表示法，求表达式的值。

 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 */
public class EvalRPN {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for (String t:tokens){
            if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")){
                int b = stack.pop();
                int a = stack.pop();
                if (t.equals("+")) a+=b;
                if (t.equals("-")) a-=b;
                if (t.equals("*")) a*=b;
                if (t.equals("/")) a/=b;
                stack.push(a);
            } else {
                stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }
}
