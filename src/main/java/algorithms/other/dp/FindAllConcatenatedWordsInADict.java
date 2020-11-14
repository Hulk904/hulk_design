package algorithms.other.dp;

import java.util.*;

/**
 * Created by yangyuan on 2020/11/7.
 * 472. 连接词
 *
 * 给定一个不含重复单词的列表，编写一个程序，返回给定单词列表中所有的连接词。

 连接词的定义为：一个字符串完全是由至少两个给定数组中的单词组成的。
 */
public class FindAllConcatenatedWordsInADict {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        System.out.println(set.contains("a".substring(1, 1)));
    }


    Set<String> set = new HashSet();

    /**
     * 动态规划
     * @param words
     * @return
     */
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        for (String s:words) set.add(s);
        List<String> res = new ArrayList();
        for (String s:words){
            if(check(s)){
                res.add(s);
            }
        }
        return res;
    }

    boolean check(String word){
        int n = word.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= n; i++){
            if (dp[i] < 0) continue;
            for (int j = n - i; j > 0; j--){//不能写为 j >= 0  因为测试用例中可能会有空串 ""
                //j从小往大 主要是为了 减少 常数  （leetcode 可能会超时）
                if (set.contains(word.substring(i, i + j))){
                    dp[i + j] = Math.max(dp[i + j], dp[i]  + 1);
                    if (dp[n] > 1) return true;
                }
            }
        }
        return false;
    }

    //trie 树。。。
}
