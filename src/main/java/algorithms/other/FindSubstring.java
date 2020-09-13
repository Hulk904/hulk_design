package algorithms.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangyuan on 2020/6/20
 *
 * 30. 串联所有单词的子串
 *
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。

 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。


 */
public class FindSubstring {

    public List<Integer> findSubstring(String s, String[] words) {
        if (s == "" || words.length == 0) return new ArrayList();
        int totalLength = words[0].length()*words.length;
        int oneLength = words[0].length();
        Map<String, Integer> need = new HashMap();
        for (String i:words){
            need.put(i, need.getOrDefault(i, 0) + 1);
        }
        List<Integer> res = new ArrayList();
        for (int i = 0; i <= s.length() - totalLength; i++){
            Map<String, Integer> temp = new HashMap();
            for(int j = i; j - i< totalLength; j += oneLength){
                String a = s.substring(j, j + oneLength);
                temp.put(a, temp.getOrDefault(a, 0) + 1);
            }
            if (need.equals(temp)) {
                res.add(i);
            }
        }
        return res;
    }
}
