package algorithms.other.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 2020/8/12.
 * 205. 同构字符串
 *
 * 给定两个字符串 s 和 t，判断它们是否是同构的。

 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。

 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。

 */
public class IsIsomorphic {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> st = new HashMap<>();
        Map<Character, Character> ts = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            char a = s.charAt(i), b = t.charAt(i);
            if (st.get(a) != null && st.get(a) != b) return false;
            st.put(a, b);
            if (ts.get(b) != null && ts.get(b) != a) return false;
            ts.put(b, a);
        }
        return true;
    }
}
