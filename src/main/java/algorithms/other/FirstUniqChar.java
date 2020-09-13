package algorithms.other;

/**
 * Created by yangyuan on 2020/4/15.
 * 面试题50. 第一个只出现一次的字符
 *
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
 */
public class FirstUniqChar {

    public char firstUniqChar(String s) {
        //遍历两次
        int[] count = new int[26];
        for (char c:s.toCharArray()){
            count[c - 'a']++;
        }
        for (char c:s.toCharArray()){
            if (count[c - 'a'] == 1){
                return c;
            }
        }
        return ' ';
    }
}
