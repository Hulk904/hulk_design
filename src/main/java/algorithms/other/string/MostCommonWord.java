package algorithms.other.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by yangyuan on 2021/5/9.
 * 819. 最常见的单词
 * 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。

 题目保证至少有一个词不在禁用列表中，而且答案唯一。

 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。

 */
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet();
        for (String i:banned){
            set.add(i);
        }
        Map<String, Integer> map = new HashMap();
        String word = "";
        for (char c:paragraph.toCharArray()){
            c = Character.toLowerCase(c);
            if (c >= 'a' && c <= 'z') word += c;
            else {
                if (word.length() > 0){
                    if (!set.contains(word)) map.put(word, map.getOrDefault(word, 0) + 1);
                    word = "";
                }
            }
        }
        if (word.length() > 0 && !set.contains(word)){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        String res = "";
        for (Map.Entry<String, Integer> en:map.entrySet()){
            if (map.getOrDefault(res, 0) < en.getValue()){
                res = en.getKey();
            }
        }
        return res;
    }
}
