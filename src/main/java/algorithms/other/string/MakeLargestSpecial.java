package algorithms.other.string;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yangyuan on 2021/3/28.
 * 761. 特殊的二进制序列
 * 特殊的二进制序列是具有以下两个性质的二进制序列：

 0 的数量与 1 的数量相等。
 二进制序列的每一个前缀码中 1 的数量要大于等于 0 的数量。
 给定一个特殊的二进制序列 S，以字符串形式表示。定义一个操作 为首先选择 S 的两个连续且非空的特殊的子串，然后将它们交换。（两个子串为连续的当且仅当第一个子串的最后一个字符恰好为第二个子串的第一个字符的前一个字符。)

 在任意次数的操作之后，交换后的字符串按照字典序排列的最大的结果是什么？

 */
public class MakeLargestSpecial {
    public String makeLargestSpecial(String S) {
        if (S.length() <= 2) return S;
        List<String> q = new ArrayList();
        String s = "";
        int cnt = 0;
        for (char c:S.toCharArray()){
            s += c;
            if (c == '1') cnt++;
            else {
                cnt--;
                if (cnt == 0){
                    q.add("1" +  makeLargestSpecial(s.substring(1, s.length() - 1)) + "0");//递归添加同级元素， （先要去掉首尾）
                    s = "";
                }
            }
        }
        q = q.stream().sorted((a, b) -> (b+a).compareTo(a+b)).collect(Collectors.toList());//从大到小排序
        StringBuilder sb = new StringBuilder();
        for (String t:q) {
            sb.append(t);
        }
        return sb.toString();
    }
}
