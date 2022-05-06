package algorithms.other;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by yangyuan on 2020/3/24.
 * 224. 基本计算器
 *
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。

 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格
 AcWing 151. 表达式计算4   模版题 包括 乘除操作
 */
public class Calculate {

    public static void main(String[] args) {
        System.out.println(calculate2("(1+(4+5+2)-3)+(6+8)"));
    }

    // 分为括号和其他两部分
    // 能算就算
    //数字压栈
    //左括号压人栈中
    //右括号将左括号之后的都算完
    //运算符
    //   当前运算符的优先级小于、等于栈顶优先级 则计算栈顶&压入栈顶
    //   否则直接加入压入栈中
    public int  calculateAcwing(String s){
        Stack<Integer> num = new Stack<>();
        Stack<Character> op = new Stack<>();//左括号和操作符号
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (Character.isDigit(c)){
                int x = 0, j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) x = x*10 + (s.charAt(j++) - '0');
                i = j - 1;
                num.push(x);
            } else if (c == '(') {
                op.push(c);
            }else if (c == ')') {
                while (op.peek() != '(') eval(num, op);
                op.pop();//左括号出栈
            }else {//操作符
                //栈中优先级比当前的高  计算栈顶 .
                //因为只有 + -  所以一定成立
                //需要排除 （ 的可能性
                //题目改了之后的补充 地方
                if (i == 0 || s.charAt(i - 1) == '(' || s.charAt(i-1) == '+' || s.charAt(i - 1) == '-'){// 判断 + 和 - 是不是一元运算符
                    num.push(0);
                }
                while (op.size() > 0 && op.peek() != '(') eval(num, op);
                op.push(c);
            }
        }
        while (op.size() > 0) eval(num,op);
        return num.peek();

    }

    /**
     * 进行一次计算
     * @param num
     * @param op
     */
    void eval(Stack<Integer> num, Stack<Character> op){
        Integer b = num.pop();
        Integer a = num.pop();
        Character o = op.pop();
        int r;
        if (o == '+') r = a + b;
        else r = a - b;
        num.push(r);
    }

    /**
     * 不是很好理解
     * @param s
     * @return
     */
    public static int calculate(String s) {

        Stack<Integer> stack = new Stack<>();
        int operand = 0;
        int result = 0; // For the on-going result
        int sign = 1;  // 1 means positive, -1 means negative

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                operand = 10 * operand + (int) (ch - '0');
            } else if (ch == '+') {
                result += sign * operand;
                sign = 1;
                operand = 0;
            } else if (ch == '-') {
                result += sign * operand;
                sign = -1;
                operand = 0;
            } else if (ch == '(') {//我们将迄今为止计算的结果和符号添加到栈上，然后重新开始进行计算，就像计算一个新的表达式一样
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if (ch == ')') {//首先计算左侧的表达式。则产生的结果就是刚刚结束的子表达式的结果。如果栈顶部有符号，则将此结果与符号相乘。
                result += sign * operand;
                result *= stack.pop();
                result += stack.pop();
                operand = 0;
            }
        }
        return result + (sign * operand);
    }



    public static int calculate2(String s) {
        LinkedList<Boolean> stack = new LinkedList<>();
        int result = 0, opr = 0; //result: 当前的结果值; opr: 当前的被加/被减数
        Character op = null; //当前要执行的运算符
        for (char c : s.toCharArray()) {
            if (c == '+' || c == '-') {
                if (op == null) {
                    //遇到第一个运算符时，将result置为opr（即第一个运算符左边的数字）
                    result = opr;
                } else {
                    //result = result +/- opr;
                    result = cal(op, result, opr);
                }
                //根据栈顶元素决定是否反转运算符
                op = swap(stack.peek() == null ? false : stack.peek(), c);
                opr = 0;
            } else if (c == '(') {
                stack.push(op != null && op == '-');
            } else if (c == ')') {
                stack.pop();
            } else if (c != ' ') {
                opr = opr * 10 + c - '0';
            }
        }
        if (op == null) {
            //算式中没有运算符时，opr就是最终结果
            return opr;
        } else {
            //否则将result与opr（即算式中最右边的数字）执行一次运算
            return cal(op, result, opr);
        }
    }

    static char swap(boolean swap, char c) {
        if (swap) {
            return c == '+' ? '-' : '+';
        } else {
            return c;
        }
    }

    static private int cal(char op, int opr1, int opr2) {
        switch (op) {
            case '+':
                return opr1 + opr2;
            case '-':
                return opr1 - opr2;
            default:
                return 0;
        }
    }

}
