package algorithms.other.string;

/**
 * Created by yangyuan on 2021/6/19.
 * 921. 使括号有效的最少添加
 *
 * 给定一个由 '(' 和 ')' 括号组成的字符串 S，我们需要添加最少的括号（ '(' 或是 ')'，可以在任何位置），以使得到的括号字符串有效。

 从形式上讲，只有满足下面几点之一，括号字符串才是有效的：
 它是一个空字符串，或者
 它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者
 它可以被写作 (A)，其中 A 是有效字符串。
 给定一个括号字符串，返回为使结果字符串有效而必须添加的最少括号数。

 */
public class MinAddToMakeValid {
    //左右括号相同 、 任意前缀左括号数量不小于右括号数量
    public int minAddToMakeValid(String s) {
        int l = 0, r = 0;
        for (char c : s.toCharArray()){
            if (c == '('){
                l++;
            } else {
                if (l == 0) r++;
                else l--;
            }
        }
        return l + r;
    }
    public int minAddToMakeValidself(String s) {

        int l = 0, r = 0, res = 0;
        for (char c:s.toCharArray()){
            if (c == '('){
                l++;
            } else {
                r++;
            }
            if (r > l){
                res += r - l;
                r = 0; l = 0;
            }
        }
        return res + l - r;
    }
}
