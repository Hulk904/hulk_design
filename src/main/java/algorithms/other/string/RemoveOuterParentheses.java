package algorithms.other.string;

/**
 * Created by yangyuan on 2021/11/28.
 * 1021. 删除最外层的括号
 */
public class RemoveOuterParentheses {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, cnt = 0, j = 0; i < s.length(); i++){
            if (s.charAt(i) == '(') {
                cnt++;
            } else if (--cnt == 0){
                sb.append(s.substring(j + 1, i));
                j = i + 1;
            }
        }
        return sb.toString();
    }
}
