package algorithms.top100;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yangyuan on 2020/1/7.
 *
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

 说明：

 拆分时可以重复使用字典中的单词。
 你可以假设字典中没有重复的单词。

 */
public class WordBreak {

    public static void main(String[] args) {
        String source = "leetodelee";
        List<String> dic = new ArrayList<>();
        dic.add("leet");
        dic.add("ode");
        dic.add("lee");
        System.out.println(wordBreak(source, dic));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] flag = new boolean[s.length() + 1];
        flag[0] = true;
        for (int i = 0; i <= s.length(); i++){
            for (int j = 0; j < i; j++){
                if (flag[j] && set.contains(s.substring(j, i))){
                    flag[i] = true;
                    break;
                }
            }
        }
        System.out.println(JSON.toJSONString(flag));
        return flag[s.length()];
    }
}
