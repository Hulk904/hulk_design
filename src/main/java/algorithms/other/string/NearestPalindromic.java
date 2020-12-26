package algorithms.other.string;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by yangyuan on 2020/11/28.
 * 564. 寻找最近的回文数
 *
 * 给定一个整数 n ，你需要找到与它最近的回文数（不包括自身）。

 “最近的”定义为两个整数差的绝对值最小。
 */
public class NearestPalindromic {

    /**
     * 有五种情况 比如 12345 那么 会在123**  和 122** 和 124**  和 特殊情况 （1000001， 9999） 中选择
     * @param n
     * @return
     */
    public String nearestPalindromic(String n) {
        int len = n.length();
        Set<Long> set = new TreeSet<>();// 如果有多个结果，返回最小的那个。
        set.add((long)Math.pow(10, len - 1) - 1);
        set.add((long)Math.pow(10, len) + 1);
        long m = Long.parseLong(n.substring(0, (n.length() + 1)/2));
        for (long i = m - 1; i <= m + 1; i++){
             String b = new StringBuilder(i + "").reverse().toString();
            if (len%2 == 1) set.add(Long.parseLong(i + b.substring(1)));
            else set.add(Long.parseLong(i + b));
        }
        set.remove(Long.parseLong(n));
        long res = (long)1e19;
        long k = Long.parseLong(n);
        for (long i:set){
            if (Math.abs(i - k) < Math.abs(res - k)){//没有等号，因为从小开始试，如果相同了就不会再用相等的了。
                res = i;
            }
        }
        return res + "";
    }
}
