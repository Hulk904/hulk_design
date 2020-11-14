package algorithms.other.string;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yangyuan on 2020/10/2.
 * 385. 迷你语法分析器
 *
 * 给定一个用字符串表示的整数的嵌套列表，实现一个解析它的语法分析器。

 列表中的每个元素只可能是整数或整数嵌套列表

 提示：你可以假定这些字符串都是格式良好的：

 字符串非空
 字符串不包含空格
 字符串只包含数字0-9、[、-、,、]

 */
public class NestedInteger {

    public NestedInteger deserialize(String s) {
        AtomicInteger u = new AtomicInteger(0);
        return dfs(s, u);
    }

    NestedInteger dfs(String s, AtomicInteger u){
        NestedInteger res = new NestedInteger();
        if (s.charAt(u.get()) == '['){
            u.getAndIncrement();// 跳过左括号
            while (s.charAt(u.get()) != ']') res.add(dfs(s, u));
            u.getAndIncrement();//跳过右括号
            if (u.get() < s.length() && s.charAt(u.get()) == ',') u.getAndIncrement();
        }else {
            int k = u.get();
            while (k < s.length() && s.charAt(k) != ',' && s.charAt(k) != ']') k++;
            res.setInteger(Integer.parseInt(s.substring(u.get(), k)));
            if (k < s.length() && s.charAt(k) == ',') k++;//跳过逗号
            u.set(k);
        }
        return res;
    }

    private void add(NestedInteger s){}

    private void setInteger(Integer i){};
}
