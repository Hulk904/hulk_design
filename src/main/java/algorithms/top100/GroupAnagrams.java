package algorithms.top100;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * Created by yangyuan on 2020/1/1.
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 */
public class GroupAnagrams {

    public static void main(String[] args) {

        String[] array = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(JSON.toJSONString(groupAnagrams(array)));
    }


    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> rec = new HashMap<>();
        for(String s:strs){
            char[] t = s.toCharArray();
            Arrays.sort(t);
            String newStr = new String(t);
            if (rec.containsKey(newStr)){
                rec.get(newStr).add(s);
            }else {
                List<String> list = new ArrayList<>();
                list.add(s);
                rec.put(newStr, list);
            }
        }
        return  new ArrayList<>(rec.values());
    }

    //还有一个思路就是 每个字符对应一个不同的素数，然后相乘，结果一样的当然是异位词了
}
