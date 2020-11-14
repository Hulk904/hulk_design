package algorithms.other.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by yangyuan on 2020/9/13.
 * 316. 去除重复字母
 *
 * 给你一个仅包含小写字母的字符串，
 * 请你去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 */
public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack();
        Map<Character, Boolean> ins = new HashMap<>();//栈里字母是否存在过
        Map<Character, Integer> last = new HashMap<>();//最后一次出现位置
        for (int i = 0; i < s.length(); i++) last.put(s.charAt(i), i);
        for (int i = 0; i < s.length(); i++){
            if (ins.getOrDefault(s.charAt(i), false)) continue;//already exist
            //跟栈顶比较 ，如果比栈顶小则把栈顶的删掉
            while (!stack.isEmpty() && stack.peek() > s.charAt(i) && last.getOrDefault(stack.peek(), -1) > i){//后面还有
                ins.put(stack.pop(), false);//从栈里删除，并标记不存在
            }
            stack.push(s.charAt(i));
            ins.put(s.charAt(i), true);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++){
            sb.append(stack.get(i));
        }
        return sb.toString();
    }
}
