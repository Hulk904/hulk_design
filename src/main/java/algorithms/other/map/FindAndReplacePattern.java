package algorithms.other.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangyuan on 2021/5/31.
 * 890. 查找和替换模式
 *
 * 你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。

 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。

 （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）

 返回 words 中与给定模式匹配的单词列表。

 你可以按任何顺序返回答案。



 */
public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList();
        for (String s:words){
            if(check(s, pattern)) res.add(s);
        }
        return res;
    }

    private boolean check(String s1, String s2){
        Map<Character, Character> m1 = new HashMap(), m2 = new HashMap();
        for (int i = 0; i < s1.length(); i++){
            if (m1.get(s1.charAt(i)) != null && m1.get(s1.charAt(i)) != s2.charAt(i)) return false;
            if (m2.get(s2.charAt(i)) != null && m2.get(s2.charAt(i)) != s1.charAt(i)) return false;
            m1.put(s1.charAt(i), s2.charAt(i));
            m2.put(s2.charAt(i), s1.charAt(i));
        }
        return true;
    }
}
