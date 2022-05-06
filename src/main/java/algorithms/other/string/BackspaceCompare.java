package algorithms.other.string;

/**
 * Created by yangyuan on 2021/5/16.
 * 844. 比较含退格的字符串
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。

 注意：如果对空文本输入退格字符，文本继续为空。

 */
public class BackspaceCompare {
    public boolean backspaceCompare(String s, String t) {
        return get(s).equals(get(t));
    }

    private String get(String s){
        StringBuilder sb = new StringBuilder();
        for (char c:s.toCharArray()){
            if (c == '#'){
                if (sb.length() > 0){
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
