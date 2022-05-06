package algorithms.other.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2021/5/9.
 * 816. 模糊坐标
 *
 * 我们有一些二维坐标，如 "(1, 3)" 或 "(2, 0.5)"，然后我们移除所有逗号，小数点和空格，
 * 得到一个字符串S。返回所有可能的原始字符串到一个列表中。

 原始的坐标表示法不会存在多余的零，所以不会出现类似于"00", "0.0", "0.00", "1.0",
 "001", "00.01"或一些其他更小的数来表示坐标。此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。

 最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。

 */
public class AmbiguousCoordinates {
    public List<String> ambiguousCoordinates(String s) {
        List<String> res = new ArrayList();
        s = s.substring(1, s.length() - 1);
        for (int i = 1; i < s.length(); i++){
            List<String> l = get(s.substring(0, i)), r= get(s.substring(i));
            for (String x:l){
                for (String y:r){
                    res.add("(" + x + ", " + y + ")");
                }
            }
        }
        return res;
    }
    //返回x或y的所有表现形式
    List<String> get(String s){
        List<String> res = new ArrayList();
        if (s.length() == 1 || s.charAt(0) != '0') res.add(s);//整数
        //小数情况
        for (int i = 1; i < s.length(); i++){
            String a = s.substring(0, i), b = s.substring(i);
            if (a.length() > 1 && a.charAt(0) == '0') continue;//有前导零
            if (b.charAt(b.length() - 1) == '0') continue;//末尾有多余零
            res.add(a + "." + b);
        }
        return res;
    }
}
