package algorithms.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yangyuan on 2020/3/3.
 * 756. 金字塔转换矩阵
 * 现在，我们用一些方块来堆砌一个金字塔。 每个方块用仅包含一个字母的字符串表示。

 使用三元组表示金字塔的堆砌规则如下：

 对于三元组(A, B, C) ，“C”为顶层方块，方块“A”、“B”分别作为方块“C”下一层的的左、右子块。当且仅当(A, B, C)是被允许的三元组，我们才可以将其堆砌上。

 初始时，给定金字塔的基层 bottom，用一个字符串表示。一个允许的三元组列表 allowed，每个三元组用一个长度为 3 的字符串表示。

 如果可以由基层一直堆到塔尖就返回 true，否则返回 false。

 */
public class PyramidTransition {

    public static void main(String[] args) {
        PyramidTransition p = new PyramidTransition();
        List<String> list = Arrays.asList("AAA","AAB","ABA","ABB","BAC");
        p.pyramidTransition("AABA", list);
    }

    List<Integer>[][] allows = new ArrayList[7][7];

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String s : allowed){
            int a = s.charAt(0) - 'A';
            int b = s.charAt(1) - 'A';
            int c = s.charAt(2);
            if (allows[a][b] == null) {
                allows[a][b] = new ArrayList<>();
            }
            allows[a][b].add(c);
        }
        return dfs(bottom, "");
    }

    /**
     *
     * @param last 下一层
     * @param now   当前这层方案 可以变为的串
     * @return
     */
    private boolean dfs(String last, String now){
        if (last.length() == 1) return true;//last长度为1时， 而不是now长度为1
        //往上走一层  缩短一个字符说明可以往上走一层了。
        if (now.length() + 1 == last.length()) return dfs(now, "");
        //需要合并的两个字符
        int a = last.charAt(now.length()) - 'A';
        int b = last.charAt(now.length() + 1) - 'A';

        if (allows[a][b] != null) {
            //所有可能的方案   遍历里面的每一个字符
            for (Integer item : allows[a][b]) {
                if (dfs(last, now + (char) item.intValue())) {
                    return true;
                }
            }
        }
        return false;
    }
}
