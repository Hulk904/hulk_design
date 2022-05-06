package algorithms.other.dfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yangyuan on 2021/3/28.
 * 753. 破解保险箱
 * 有一个需要密码才能打开的保险箱。密码是 n 位数, 密码的每一位是 k 位序列 0, 1, ..., k-1 中的一个 。

 你可以随意输入密码，保险箱会自动记住最后 n 位输入，如果匹配，则能够打开保险箱。

 举个例子，假设密码是 "345"，你可以输入 "012345" 来打开它，只是你输入了 6 个字符.

 请返回一个能打开保险箱的最短字符串。

 */
public class CrackSafe {

    Set<String> s = new HashSet();
    String ans = "";
    int k;
    // 欧拉回路
    public String crackSafe(int n, int k) {
        this.k = k;
        char[] c = new char[n - 1];
        Arrays.fill(c, '0');
        String start = new String(c);
        dfs(start);
        return ans + start;
    }
    void dfs(String u){
        for (int i = 0; i < k ;i++){
            String v = u + i;
            if (!s.contains(v)){
                s.add(v);
                dfs(v.substring(1));
                ans += i;
            }
        }
    }
}
