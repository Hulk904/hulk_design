package algorithms.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 2020/8/30.
 * 299. 猜数字游戏
 *
 */
public class GetHint {

    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap();
        for (char c:secret.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int total = 0;
        for (char c:guess.toCharArray()){
            if (map.get(c) != null && map.get(c) > 0){
                total++;
                map.put(c, map.get(c) - 1);
            }
        }
        int bulls = 0;
        for (int i = 0; i < secret.length(); i++){
            if (secret.charAt(i) == guess.charAt(i)){
                bulls++;
            }
        }
        return bulls + "A" + (total - bulls) + "B";
    }
}
