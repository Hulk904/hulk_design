package algorithms.top100;

import java.util.Stack;

/**
 * Created by yangyuan on 2019/12/29.
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

 有效字符串需满足：

 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 注意空字符串可被认为是有效字符串
 */
public class IsValidPair {
    public static void main(String[] args) {
        System.out.println(isValid("(]"));
    }

    private static boolean isValid(String s){
        if (s == null){
            return false;
        }
        if ("".equals(s)){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int cur = 0; cur < s.length(); ){
            if (stack.isEmpty()){
                stack.push(s.charAt(cur));
                cur++;
                continue;
            }
            if (isPair(stack.peek(),s.charAt(cur))){
                cur++;
                stack.pop();
            } else {
                stack.push(s.charAt(cur));
                cur++;
                continue;
            }
        }
        return stack.isEmpty();
    }

    private static boolean isPair(char a, char b){
        if (a == '(' && b == ')'){
            return true;
        }
        if (a == '[' && b == ']'){
            return true;
        }
        if (a =='{' && b =='}'){
            return true;
        }
        return false;
    }

    /**
     * 利用两个括号对的ascII码差小于2
     * @param s
     * @return
     */
    private static boolean isValid2(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i < s.length(); i++){
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') stack.push(s.charAt(i));
            else {
                if (!stack.isEmpty() && Math.abs(stack.peek() - s.charAt(i)) <= 2) stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
