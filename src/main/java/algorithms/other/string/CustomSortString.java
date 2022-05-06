package algorithms.other.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 2021/4/25.
 * 791. 自定义字符串排序
 *
 * 字符串S和 T 只包含小写字符。在S中，所有字符只会出现一次。

 S 已经根据某种规则进行了排序。我们要根据S中的字符顺序对T进行排序。更具体地说，如果S中x在y之前出现，那么返回的字符串中x也应出现在y之前。

 返回任意一种符合条件的字符串T。

 */
public class CustomSortString {
    //acwing 排序 。java api支持不是很好
    public String customSortString(String S, String T) {
        Map<Integer, Integer> map = new HashMap();
//        for (int i = 0; i < S.length(); i++){
//            map.put(S.charAt(i) + 0, i);
//        }
//        char[] c = T.toCharArray();
//        Arrays.stream(c)
//        Arrays.sort(c, (a, b) -> map.getOrDefault(b, 26) - map.getOrDefault(a, 26));
//        return new String(c);
        return null;
    }

    /**
     * leetcode 官方解答
     * @param S
     * @param T
     * @return
     */
    public String customSortString2(String S, String T) {
        int[] count = new int[26];
        for (char c:T.toCharArray()){
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (char c:S.toCharArray()){
            while (count[c - 'a']-- > 0) {
                sb.append(c);
            }
        }
        for (char i = 'a'; i <= 'z'; i++){
            while(count[i - 'a']-- > 0){
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
