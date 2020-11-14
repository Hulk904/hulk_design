package algorithms.other.string;

import java.util.*;

/**
 * Created by yangyuan on 2020/11/14.
 * 500. 键盘行
 *
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
 */
public class FindWords {
    public String[] findWords(String[] words) {
        String[] line = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 3; i++){
            for (char c:line[i].toCharArray()){
                map.put(c, i);
            }
        }
        List<String> res = new ArrayList<>();
        for (String s:words){
            HashSet<Integer> set = new HashSet();
            for (char c:s.toCharArray()){
                set.add(map.get(Character.toLowerCase(c)));
            }
            if (set.size() == 1){
                res.add(s);
            }
        }
        return res.toArray(new String[0]);
    }
}
