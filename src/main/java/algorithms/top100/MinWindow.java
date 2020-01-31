package algorithms.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 2020/1/3.
 */
public class MinWindow {

    public static void main(String[] args) {

        String a = "bbaac";
        String b = "aba";
        System.out.println(minWindow(a,b));

    }


    /**
     *  超出时间限制。。。。
     * @param s
     * @param t
     * @return
     */
    private static String minWindow(String s, String t) {
        int left =0, right = 0;
        int minLength = Integer.MAX_VALUE;
        String target = "";
        if (!stringContain(s, t)){
            return "";
        }
        Map<Character,Integer> targetMap  = targetMap(t);
        while (left < s.length() || right < s.length()){
            if (right > s.length()){
                right = s.length();
                left++;
            }
            if (stringContain(s.substring(left, right), targetMap)){
                if (right - left < minLength){
                    minLength = right - left;
                    target = s.substring(left, right);
                }
                while (stringContain(s.substring(++left, right), targetMap)){
                    if (right - left < minLength){
                        minLength = Math.min(minLength, right - left);
                        target = s.substring(left, right);
                    }
                }
            } else {
                right++;
            }
        }
        return target;
    }

    private static boolean stringContain (Map<Character, Integer> source, Map<Character, Integer> target){
        for (Map.Entry<Character, Integer> entry:target.entrySet()){
            if (source.get(entry.getKey()) == null || entry.getValue() > source.get(entry.getKey())){
                return false;
            }
        }
        return true;
    }

    private static Map<Character, Integer> targetMap (String target){
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length(); i++){
            int count = map.getOrDefault(target.charAt(i), 0);
            map.put(target.charAt(i), count + 1);
        }
        return map;
    }

    private static boolean stringContain (String ori, Map<Character, Integer> target){
        Map<Character, Integer> sour = targetMap(ori);
        for (Map.Entry<Character, Integer> entry:target.entrySet()){
            if (sour.get(entry.getKey()) == null || entry.getValue() > sour.get(entry.getKey())){
                return false;
            }
        }
        return true;
    }

    private static boolean stringContain(String ori, String target){
        for (int i = 0; i < target.length(); i++){
            if (!ori.contains(target.substring(i, i+1))){
                return false;
            } else {
                ori = ori.replaceFirst(target.substring(i, i+1), "");
            }
        }
        return true;
    }
}

