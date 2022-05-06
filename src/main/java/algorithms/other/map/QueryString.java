package algorithms.other.map;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yangyuan on 2021/11/27.
 * 1016. 子串能表示从 1 到 N 数字的二进制串
 *
 * 给定一个二进制字符串 S（一个仅由若干 '0' 和 '1' 构成的字符串）和一个正整数 N，如果对于从 1 到 N 的每个整数 X，
 * 其二进制表示都是 S 的子串，就返回 true，否则返回 false。

 */
public class QueryString {
    public boolean queryString(String s, int n) {
        Set<Integer> set = new HashSet();//存放每一个可能的数字
        for (int i = 0; i < s.length(); i++){
            int x = 0;
            for (int j = i; j < s.length(); j++){
                x = x*2 + (s.charAt(j) - '0');
                if (x > n) break;//如果数字大于n 则没有意义了
                if (x > 0) set.add(x);
            }
        }
        return set.size() == n;//判断集合大小是不是等于数字n的大小，不用去判断从1到n的每个数字都在set中
    }
}
