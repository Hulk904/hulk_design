package algorithms.other;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangyuan on 2020/2/24.
 *
 * 290. 单词规律
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。

 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。

 示例1:

 输入: pattern = "abba", str = "dog cat cat dog"
 输出: true

 */
public class WordPattern {

    public static void main(String[] args) {
        wordPattern("abba", "dog dog dog dog");
    }

    /**
     * 一种方式是通过两个hashMap 做映射。
     * 这里通过一个hashMap来实现。需要一个指针来指向比较的对象。
     * @param pattern
     * @param str
     * @return
     */
    public static  boolean wordPattern(String pattern, String str) {
        String[] word = str.split(" ");
        if (pattern.length() != word.length){
            return false;
        }
        Map<Character, String>  map = new HashMap<>();
        int i = 0;
        for (char c:pattern.toCharArray()){
            if (map.containsKey(c)){
                if (!map.get(c).equals(word[i])){
                    return false;
                }
            } else {
                if (map.containsValue(word[i])){
                    return false;
                }
                map.put(c, word[i]);
            }
            i++;
        }
        return true;
    }

}
