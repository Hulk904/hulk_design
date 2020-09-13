package algorithms.top100;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yangyuan on 2020/1/27.
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。

 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

 说明：

 字母异位词指字母相同，但排列不同的字符串。
 不考虑答案输出的顺序。
 示例 1:

 输入:
 s: "cbaebabacd" p: "abc"

 输出:
 [0, 6]

 */
public class FindAnagrams {

    public static void main(String[] args) {
        String s = "abaacbabc";
        String p = "abc";
        System.out.println(JSON.toJSONString(findAnagramsTest(s, p)));

    }

    /**
     * 滑动窗口  https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/hua-dong-chuang-kou-tong-yong-si-xiang-jie-jue-zi-/
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        if (s==null || "".equals(s) || p == null || "".equals(p)){
            return Collections.EMPTY_LIST;
        }
        int[] needs = new int[26];
        for (char c:p.toCharArray()){
            needs[c - 'a']++;
        }
        int[] window = new int[26];
        int left = 0, right = 0, total = p.length();//total 记录字符长度
        List<Integer> result = new ArrayList<>();
        while (right < s.length()){
            char c = s.charAt(right);
            if (needs[c - 'a'] > 0){//需要的元素
                window[c - 'a']++;
                if (window[c - 'a'] <= needs[c - 'a']){
                    total--;
                }
            }
            //right++ 不能放在这里，得放在最后哦
            while (total == 0){
                if (right - left + 1 == p.length()){
                    result.add(left);
                }
                char b = s.charAt(left);
                if (needs[b - 'a'] > 0){//关心的元素
                    window[b - 'a']--;
                    if (window[b - 'a'] < needs[b - 'a']){
                        total++;
                    }
                }
                left++;
            }
            right++;
        }
        return result;
    }

    /**
     * 错误的计算方式
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagramsTest(String s, String p) {
        int[] needs = new int[26];
        for (int i = 0; i < p.length(); i++){
            needs[p.charAt(i) - 'a']++;
        }
        int total = p.length();
        int left =0 ,right = 0;
        int[] windows = new int[26];
        List<Integer> res = new ArrayList();
        while (right < s.length()){
            char c = s.charAt(right);
            if (needs[c - 'a'] > 0){
                windows[c - 'a']++;
                if (windows[c - 'a'] <= needs[c - 'a']){
                    total--;
                }
            }
            right++;
            while(total == 0){
                char t = s.charAt(left);
                if (needs[t - 'a'] > 0){
                    windows[t - 'a']--;
                    if (windows[t - 'a'] < needs[t - 'a']){
                        total++;
                        //"abaacbabc"  "abc" 会返回 1，3，4，6
                        //这里的问题是虽然b 虽然减少到极值了，但是不保证别的元素刚刚好了，所以放在这里不对
                        res.add(left);
                    }
                }
                left++;
            }
        }
        return res;
    }
}
