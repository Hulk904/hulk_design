package algorithms.other.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2021/6/14.
 * 916. 单词子集
 * 我们给出两个单词数组 A 和 B。每个单词都是一串小写字母。

 现在，如果 b 中的每个字母都出现在 a 中，包括重复出现的字母，那么称单词 b 是单词 a 的子集。 例如，“wrr” 是 “warrior” 的子集，但不是 “world” 的子集。

 如果对 B 中的每一个单词 b，b 都是 a 的子集，那么我们称 A 中的单词 a 是通用的。

 你可以按任意顺序以列表形式返回 A 中所有的通用单词。

 */
public class WordSubsets {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        //预处理words2 每个单词字母出现最大值
        int[] cnt = new int[26];
        for (String s:words2){
            int[] c = new int[26];
            for (char t:s.toCharArray()){
                c[t - 'a']++;
            }
            for (int i = 0; i < 26; i++){
                cnt[i] = Math.max(cnt[i], c[i]);
            }
        }
        List<String> res = new ArrayList();
        for (String s:words1){
            int[] c = new int[26];
            for (char t:s.toCharArray()){
                c[t - 'a']++;
            }
            boolean flag = true;
            for (int i = 0; i < 26; i++){
                if (c[i] < cnt[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag)res.add(s);
        }
        return res;
    }
}
