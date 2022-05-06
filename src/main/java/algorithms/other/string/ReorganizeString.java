package algorithms.other.string;

/**
 * Created by yangyuan on 2021/4/3.
 * 767. 重构字符串
 *
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。

 若可行，输出任意可行的结果。若不可行，返回空字符串。
 */
public class ReorganizeString {

    public String reorganizeString(String S) {
        int[] map = new int[26];
        int max = 0;
        for (char c:S.toCharArray()){
            map[c - 'a']++;
            max = Math.max(max, map[c - 'a']);
        }
        int n = S.length();
        if (max > (n + 1)/2)return "";// 大于n/2向上取整
        char[] res = new char[n];
        int i = 1, j = 0;
        for (char c = 'a'; c <= 'z'; c++){
            if (map[c - 'a'] <= n/2){//小于等于n/2下取整，放在奇数位
                while (map[c - 'a'] > 0 && i < n){
                    res[i] = c;
                    map[c - 'a']--;
                    i+=2;
                }
            }
            while (map[c - 'a'] > 0 && j < n){//存在某个字符大于n/2下取整数，放在偶数位置
                res[j] = c;
                map[c - 'a']--;
                j+=2;
            }
        }
        return new String(res);
    }
}
