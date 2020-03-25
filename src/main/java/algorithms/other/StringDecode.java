package algorithms.other;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Created by yangyuan on 2020/3/24.
 * A3B，处理后的结果为 AAAB
 (AB)2C，处理后的结果为 ABABC
 ((AB)2C)2D， 处理后的结果为 ABABCABABCD

 字符后的数字代表重复次数，带括号的表示括号内的都是重复的。
 */
public class StringDecode {

    public static void main(String[] args) {
        System.out.println(decode("3"));
    }

    static String decode(String source){
        Deque<String> deque = new ArrayDeque<>();
        for (int i = 0; i < source.length();){
            if (source.charAt(i) == '(' || source.charAt(i) == ')'){
                if(source.charAt(i) == '('){
                    deque.addLast("(");
                }
                i++;
                continue;
            } else if (source.charAt(i) >= 'A' && source.charAt(i) <= 'Z'){
                StringBuilder sb = new StringBuilder();
                while (i < source.length() && source.charAt(i) >= 'A' && source.charAt(i) <= 'Z') {
                    sb.append(source.charAt(i++));
                }
                deque.addLast(sb.toString());
            } else {//数字
                boolean needDel = false;
                if (i - 1 > 0 && source.charAt(i - 1) == ')'){
                    needDel = true;
                }
                int times = 0;
                while (i < source.length() && source.charAt(i) >= '0' && source.charAt(i) <= '9'){
                    times = times * 10 + (source.charAt(i++) - '0');
                }
                if (deque.isEmpty()) return "";
                String temp = deque.removeLast();
                while (!deque.isEmpty() && !"(".equals(deque.peekLast())){
                    temp = deque.removeLast() + temp;
                }
                if (needDel) {
                    deque.removeLast();
                }
                StringBuilder sb = new StringBuilder();
                while ( times-- > 0){
                    sb.append(temp);
                }
                deque.addLast(sb.toString());
            }
        }
        String res = "";
        while (!deque.isEmpty()){
            res += deque.removeFirst();
        }
        return res;
    }
}
