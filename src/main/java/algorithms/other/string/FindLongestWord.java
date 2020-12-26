package algorithms.other.string;

import java.util.List;

/**
 * Created by yangyuan on 2020/11/21.
 *
 * 524. 通过删除字母匹配到字典里最长单词
 *
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。
 * \如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。

 */
public class FindLongestWord {

    public String findLongestWord(String s, List<String> d) {
        String res = "";
        for (String str:d){
            if (check(str, s)){
                if ("".equals(res) || res.length() < str.length() || (res.length() == str.length() && res.compareTo(str) > 0)){
                    res = str;
                }
            }
        }
        return res;
    }

    private boolean check(String a, String b){
        int k = 0;
        for (char c:b.toCharArray()){
            if (k < a.length() && a.charAt(k) == c){
                k++;
            }
        }
        return k == a.length();
    }
}
