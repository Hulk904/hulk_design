package algorithms.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 2020/4/22.
 * 409. 最长回文串
 *
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 */
public class LongestPalindrome {

    /**
     *
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        int[] cnt = new int[58];
        for (char c : s.toCharArray()) {
            cnt[c - 'A'] += 1;
        }
        int ans = 0;
        for (int x: cnt) {
            // 字符出现的次数最多用偶数次。
            ans += x - (x & 1);
        }
        // 如果最终的长度小于原字符串的长度，说明里面某个字符出现了奇数次，那么那个字符可以放在回文串的中间，所以额外再加一。
        return ans < s.length() ? ans + 1 : ans;//不像下面还需要单独通过一个变量标识，这多简洁。。
    }

    /**
     * 自己基于hashmap写的，跟上面比起来差距很明显啊
     * @param s
     * @return
     */
    public int longestPalindrome2(String s) {
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int count = 0 , carry = 0;
        for (Map.Entry<Character, Integer> entry:map.entrySet()){
            if (entry.getValue()%2 == 1){
                carry = 1;
                count += entry.getValue() - 1;
            } else {
                count += entry.getValue();
            }
        }
        count += carry;
        return count;
    }

}
