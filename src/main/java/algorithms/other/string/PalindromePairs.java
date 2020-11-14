package algorithms.other.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangyuan on 2020/9/19.
 * 336. 回文对
 * 给定一组 互不相同 的单词， 找出所有不同 的索引对(i, j)，
 * 使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
 */
public class PalindromePairs {

    public List<List<Integer>> palindromePairs(String[] words) {
        final Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++){
            map.put(new StringBuilder(words[i]).reverse().toString(), i);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++){
            String temp = words[i];
            for (int j = 0; j <= temp.length(); j++){
                String left = temp.substring(0, j);
                String right = temp.substring(j);
                if (check(right) && map.get(left) != null && map.get(left) != i){
                    final int x = i;
                    res.add(new ArrayList<Integer>(){{add(x);add(map.get(left));}});
                }
                if (check(left) && map.get(right) != null && map.get(right) != i && temp.length() != words[map.get(right)].length()){
                    final int x = i;
                    res.add(new ArrayList<Integer>(){{add(map.get(right));add(x);}});
                }
            }
        }
        return res;
    }

    private boolean check(String s){
        for (int i = 0, j = s.length() - 1; i < j; i++,j--){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
