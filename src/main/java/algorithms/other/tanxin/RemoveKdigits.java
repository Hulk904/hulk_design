package algorithms.other.tanxin;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by yangyuan on 2020/10/17.
 *
 * 402. 移掉K位数字
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 */
public class RemoveKdigits {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c:num.toCharArray()){
            //对首比当前大则被剔除
            while (k > 0 && deque.size() > 0 && deque.peek() > c){
                k--;
                deque.pop();
            }
            deque.push(c);
        }
        while (k-- > 0) deque.pop();
        while (deque.size() > 0 && deque.getLast() == '0') deque.removeLast();
        if (deque.isEmpty()) return "0";
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()){
            sb.append(deque.removeLast());
        }
        return sb.toString();
    }
}
