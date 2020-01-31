package algorithms.top100;

import java.util.Stack;

/**
 * Created by yangyuan on 2020/1/30.
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

 示例 1:

 输入: "(()"
 输出: 2
 解释: 最长有效括号子串为 "()"

 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(longestValidParentheses2(s));
    }

    /**
     * 动态规划
     * dp[i] = dp[i-2] + 2  以 （)  结尾
     * dp[i] = dp[i - 1] + dp[i - dp[i-1] -2] + 2  以  )) 结尾  这是因为如果i-1 是 ）
     * 那么 dp[i-1] 处 一定是 ( 则对应的 长度为 dp[i-1] + 2  ,然后再加上前面可能的 dp[i - dp[i-1] -2]
     * @param s
     * @return
     */
    public static  int longestValidParentheses(String s) {
        if (s == null || s.length() == 1){
            return 0;
        }
        int result = 0;
        int[] dp = new int[s.length()];
        for (int i = 1 ;i < s.length(); i++){
            if (s.charAt(i) == ')'){
                if (s.charAt(i - 1) == '('){
                    if (i >= 2) {
                        dp[i] = dp[i - 2] + 2;
                    } else {
                        dp[i] = 2;
                    }
                }
                if (s.charAt(i - 1) == ')'){
                    if (i - dp[i-1] - 1 >=0 && s.charAt(i - dp[i-1] - 1) == '(' ) {
                        dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                    }//dp表示以i结尾的最长，而不是到i为止最长的 ，所以没有else  dp[i] = dp [i-1] 什么的。。
                }
                result = Math.max(result, dp[i]);
            }
        }
        return result;
    }

    /**
     * 栈实现
     * @param s
     * @return
     */
    public static  int longestValidParenthesesStack(String s) {
        if (s == null || "".equals(s)){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);//注意 计算长度的时候 不是i和对应的括号下标相减，而是stack.peek() 出栈之后的元素
        int result = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                    continue;
                }
                result = Math.max(result, i - stack.peek());
            }
        }
        return result;
    }

    public static  int longestValidParentheses2(String s){
        if (s == null || "".equals(s)){
            return 0;
        }
        int left = 0 ,right = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                left++;
            } else {
                right++;
            }
            if (left == right){
                result = Math.max(result, left*2);
            } else if (right > left){
                left = 0;
                right = 0;
            }
        }
        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0 ; i--){
            if (s.charAt(i) == '('){
                left++;
            } else {
                right++;
            }
            if (left == right){
                result = Math.max(result, left*2);
            } else if (left > right){
                left =0;
                right = 0;
            }
        }
        return result;
    }

}
