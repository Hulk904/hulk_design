package algorithms.other.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yangyuan on 2021/5/16.
 * 842. 将数组拆分成斐波那契序列
 * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。

 形式上，斐波那契式序列是一个非负整数列表 F，且满足：

 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
 F.length >= 3；
 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。

 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。

 */
public class SplitIntoFibonacci {
    public List<Integer> splitIntoFibonacci(String num) {
        //前两个数确定了，整个序列都确定了
        //枚举前两个数。。
        //官方是dfs
        for(int i = 1; i <= 10 && i < num.length(); i++){
            for (int j = i + 1; j <= i +10 && j < num.length(); j++){
                long a = Long.parseLong(num.substring(0, i));
                long b = Long.parseLong(num.substring(i, j));
                List<Integer> res = get(num, a, b);
                if (res != null) return res;
            }
        }
        return Collections.EMPTY_LIST;
    }

    List<Integer> get(String s, long a, long b){
        List<Integer> res = new ArrayList();
        res.add((int)a);
        res.add((int)b);
        String t = a + "" + b;
        while (t.length() < s.length()){
            long c = a + b;
            if (c > Integer.MAX_VALUE) return null;
            res.add((int)c);
            t += c;
            a = b;
            b = c;
        }
        if (!t.equals(s)) return null;
        return res;
    }
}
