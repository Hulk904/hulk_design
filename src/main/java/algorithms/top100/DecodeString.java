package algorithms.top100;

import java.util.Stack;

/**
 * Created by yangyuan on 2020/1/16.
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。

 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

 示例:

 s = "3[a]2[bc]", 返回 "aaabcbc".

 */
public class DecodeString {

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }



    public static String decodeString(String s) {
        Stack<Integer> multi = new Stack<>();
        Stack<String> result = new Stack<>();
        int curMulti = 0;
        StringBuilder sb = new StringBuilder();
        for (Character c:s.toCharArray()){
            if (c >= '0' && c <='9'){
                curMulti = curMulti*10 + (c - '0');
            } else if (c == '['){
                multi.push(curMulti);
                curMulti = 0;
                result.push(sb.toString());
                sb = new StringBuilder();
            } else if (c == ']'){
                StringBuilder temp = new StringBuilder();
                Integer mul = multi.pop();
                for(int i=0;i<mul;i++){
                    temp.append(sb);
                }
                sb = new StringBuilder(result.pop()).append(temp);
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
