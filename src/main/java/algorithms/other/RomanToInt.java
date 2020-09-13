package algorithms.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 2020/6/14.
 * 13. 罗马数字转整数
 */
public class RomanToInt {

    private static Map<Character, Integer> map = new HashMap<Character, Integer>(){
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
    }};

    /**
     * 如果前面的字符对应的数字小于后面的则减去它，如果大于则加上它
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++){
            if (i + 1 < s.length() && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))){
                res -= map.get(s.charAt(i));
            } else {
                res += map.get(s.charAt(i));
            }
        }
        return res;
    }
}
