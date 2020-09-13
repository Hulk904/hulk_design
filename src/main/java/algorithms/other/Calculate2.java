package algorithms.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by yangyuan on 2020/8/22.
 * 227. 基本计算器 II
 *
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。

 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 */
public class Calculate2 {

    Stack<Integer> num = new Stack<>();
    Stack<Character> op = new Stack<>();

    public int calculate(String s) {
        //定义操作符优先级
        Map<Character, Integer> pr = new HashMap<>();
        pr.put('+', 1);
        pr.put('-', 1);
        pr.put('*', 2);
        pr.put('/', 2);
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == ' ') continue;
            if(Character.isDigit(c)){
                int x = 0, j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))){
                    x = x*10 + (s.charAt(j++) - '0');
                }
                num.push(x);
                i = j - 1;
            } else {
                while (!op.isEmpty() && pr.get(c) <= pr.get(op.peek())) eval();//如果栈顶运算符优先级大于当前的 计算一次
                op.push(c);
            }
        }
        while (!op.isEmpty()) eval(); //最后可能还有剩余的
        return num.peek();
    }

    //操作栈一次 及计算相关数据
    private void eval(){
        int b = num.pop();
        int a = num.pop();
        char c = op.pop();
        int r ;
        if (c == '+') r = a + b;
        else if (c == '-') r = a -b;
        else if (c == '*') r = a*b;
        else r = a/b;
        num.push(r);
    }

}
