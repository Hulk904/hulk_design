package algorithms.other.string;

/**
 * Created by yangyuan on 2021/12/18.
 * 1047. 删除字符串中的所有相邻重复项
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。

 在 S 上反复执行重复项删除操作，直到无法继续删除。

 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。

 */
public class RemoveDuplicates {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c:s.toCharArray()){
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c){
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
