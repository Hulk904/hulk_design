package algorithms.other.string;

/**
 * Created by yangyuan on 2021/5/18.
 * 854. 相似度为 K 的字符串
 *
 * 如果可以通过将 A 中的两个小写字母精确地交换位置 K 次得到与 B 相等的字符串，我们称字符串 A 和 B 的相似度为 K（K 为非负整数）。

 给定两个字母异位词 A 和 B ，返回 A 和 B 的相似度 K 的最小值。

 */
public class KSimilarity {
    public int kSimilarity(String s1, String s2) {
        //环内部交换相当于拆成两个环， 环之间交换相当于合成一个环
        //例如abc,  bac  会有 a->b, b->a, c->c 这样的图
        //ida* 算法
        if (s1.equals(s2)) return 0;
        int depth = 1;
        while (!dfs(s1, s2, depth)) depth++;
        return depth;
    }

    boolean dfs(String s1, String s2, int depth){
        if (depth == 0) return s1.equals(s2);
        if (h(s1, s2) > depth) return false;//预估最小步数大于需要步数
        //枚举所有方案
        for (int i = 0; i < s1.length(); i++){
            if (s1.charAt(i) != s2.charAt(i)){
                for (int j = i + 1; j < s1.length(); j++){
                    if (s2.charAt(i) == s1.charAt(j)) {
                        //交换i，j字符
                        char[] c1 = s1.toCharArray();
                        char temp = c1[i];
                        c1[i] = c1[j];
                        c1[j] = temp;
                        if (dfs(new String(c1), s2, depth - 1)) return true;
                    }
                }
                break;
            }
        }
        return false;
    }

    //启发函数
    int h(String s1, String s2){
        int res = 0;
        for (int i = 0; i < s1.length(); i++){
            if (s1.charAt(i) != s2.charAt(i)){
                res++;
            }
        }
        return (res + 1)/2;
    }
}
