package algorithms.other.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangyuan on 2021/5/30.
 * 884. 两句话中的不常见单词
 *
 * 给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）

 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。

 返回所有不常用单词的列表。

 您可以按任何顺序返回列表。

 */
public class UncommonFromSentences {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap();
        for(String str:s1.split(" ")){
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (String str:s2.split(" ")){
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        List<String> res = new ArrayList();
        for (Map.Entry<String, Integer> entry:map.entrySet()){
            if (entry.getValue() == 1){
                res.add(entry.getKey());
            }
        }
        return res.toArray(new String[0]);
    }
}
