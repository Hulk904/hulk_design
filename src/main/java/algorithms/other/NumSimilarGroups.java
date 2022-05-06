package algorithms.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2021/5/15.
 * 839. 相似字符串组
 * 如果交换字符串 X 中的两个不同位置的字母，使得它和字符串 Y 相等，那么称 X 和 Y 两个字符串相似。如果这两个字符串本身是相等的，那它们也是相似的。

 例如，"tars" 和 "rats" 是相似的 (交换 0 与 2 的位置)； "rats" 和 "arts" 也是相似的，但是 "star" 不与 "tars"，"rats"，或 "arts" 相似。

 总之，它们通过相似性形成了两个关联组：{"tars", "rats", "arts"} 和 {"star"}。注意，"tars" 和 "arts" 是在同一组中，即使它们并不相似。形式上，对每个组而言，要确定一个单词在组中，只需要这个词和该组中至少一个单词相似。

 给你一个字符串列表 strs。列表中的每个字符串都是 strs 中其它所有字符串的一个字母异位词。请问 strs 中有多少个相似字符串组？

 */
public class NumSimilarGroups {
    int n;
    int[] p;
    int find (int x){
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
    //判断交换两个就可以变得一样
    boolean check(String a, String b){
        if (a.equals(b)) return true;
        List<Integer> list = new ArrayList();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) continue;
            list.add(i);
            if (list.size() > 2) return false;
        }
        if (list.size() != 2) return false;
        return a.charAt(list.get(0)) == b.charAt(list.get(1)) && a.charAt(list.get(1)) == b.charAt(list.get(0));
    }
    public int numSimilarGroups(String[] strs) {
        //并查集 经典
        n = strs.length;
        p = new int[n];
        for (int i = 0; i < n; i++) p[i] = i;
        int res = n;
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                if (check(strs[i], strs[j])){
                    if (find(i) != find(j)){
                        p[find(i)] = find(j);
                        res--;
                    }
                }
            }
        }
        return res;
    }
}
