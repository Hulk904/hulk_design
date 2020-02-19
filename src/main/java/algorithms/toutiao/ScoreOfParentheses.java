package algorithms.toutiao;

import java.util.Stack;

/**
 * Created by yangyuan on 2020/2/18.
 * 856
 *
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：

 () 得 1 分。
 AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 (A) 得 2 * A 分，其中 A 是平衡括号字符串。
  

 示例 1：

 输入： "()"
 输出： 1
 示例 2：

 输入： "(())"
 输出： 2


 https://leetcode-cn.com/problems/score-of-parentheses/solution/ctu-jie-zhan-by-zao-shang-7dian-qi/
 这个比较好理解些
 */
public class ScoreOfParentheses {

    public static void main(String[] args) {
        String data = "()()";
        System.out.println(scoreOfParentheses(data));
    }

    public static  int scoreOfParentheses(String S) {
       Stack<Integer> stack = new Stack<>();
        for ( int i = 0; i < S.length(); i++){
            if (S.charAt(i) == '('){
                stack.push(0);
            }else {
                if (stack.peek() == 0){
                    stack.pop();
                    stack.push(1);
                } else {
                    int temp = 0;
                    while (!stack.isEmpty() && stack.peek() != 0) {
                        temp += stack.pop();
                    }
                    stack.pop();
                    stack.push(temp * 2);
                }
            }
        }
        int result = 0;
        while (!stack.isEmpty()){
            result += stack.pop();
        }
        return result;//stack.pop(); 像 ()() 最后栈中会存在 1、1两个值，所以需要累加下
    }
}
