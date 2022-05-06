package algorithms.other.string;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yangyuan on 2021/3/20.
 * 726. 原子的数量
 * 给定一个化学式formula（作为字符串），返回每种原子的数量。

 原子总是以一个大写字母开始，接着跟随0个或任意个小写字母，表示原子的名字。

 如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。例如，H2O 和 H2O2 是可行的，但 H1O2 这个表达是不可行的。

 两个化学式连在一起是新的化学式。例如 H2O2He3Mg4 也是化学式。

 一个括号中的化学式和数字（可选择性添加）也是化学式。例如 (H2O2) 和 (H2O2)3 是化学式。

 给定一个化学式，输出所有原子的数量。格式为：第一个（按字典序）原子的名子，跟着它的数量（如果数量大于 1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于 1），以此类推。

 */
public class CountOfAtoms {

    public String countOfAtoms(String formula) {
        Map<String, Integer> map = dfs(formula, new AtomicInteger(0));
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> e:map.entrySet()){
            sb.append(e.getKey());
            if (e.getValue() > 1) sb.append(e.getValue());
        }
        return sb.toString();
    }

    /**
     *
     * @param str
     * @param u 需要传递一个引用
     * @return
     */
    Map<String, Integer> dfs(String str, AtomicInteger u){
        Map<String, Integer> map = new TreeMap();
        while (u.get() < str.length()){
            if (str.charAt(u.get()) == '('){
                u.getAndIncrement();
                Map<String,Integer> t = dfs(str, u);
                u.getAndIncrement();
                int cnt = 1, k = u.get();
                while (k < str.length() && Character.isDigit(str.charAt(k))) k++;
                if (k > u.get()){
                    cnt = Integer.parseInt(str.substring(u.get(), k));
                    u.set(k);
                }
                for (Map.Entry<String, Integer> ent:t.entrySet()){
                    map.put(ent.getKey(), map.getOrDefault(ent.getKey(), 0) + ent.getValue()*cnt);
                }
            } else if (str.charAt(u.get()) == ')') break;
            else {
                int k = u.get() + 1;
                while (k < str.length() && str.charAt(k) >= 'a' && str.charAt(k) <= 'z') k++;
                String key = str.substring(u.get(), k);
                u.set(k);
                int cnt = 1;
                while (k < str.length() && Character.isDigit(str.charAt(k))) k++;
                if (k > u.get()){
                    cnt = Integer.parseInt(str.substring(u.get(), k));
                    u.set(k);
                }
                map.put(key, map.getOrDefault(key, 0) + cnt);
            }
        }
        return map;
    }
}
