package algorithms.other.string;

/**
 * Created by yangyuan on 2021/3/27.
 * 745. 前缀和后缀搜索
 *
 * 给定多个 words，words[i] 的权重为 i 。

 设计一个类 WordFilter 实现函数WordFilter.f(String prefix, String suffix)。
 这个函数将返回具有前缀 prefix 和后缀suffix 的词的最大权重。如果没有这样的词，返回 -1。

 trie 树
 对于每个单词 abcde
 会插入
   #abcde
   e#abcde
   de#abcde
   cde#abcde
   bcde#abcde
   abcde#abcde

    查询的时候  surfix+ '#' + prefix 的方式查询
 */
public class WordFilter {
    int N = 200000;//尝试值，如果不行，再换大点
    int son[][] = new int[N][27];
    int []w = new int[N];
    int idx = 0;

    void insert(String s,int id){
        int p = 0;
        for (char c:s.toCharArray()){
            int t = c == '#' ? 26 : c - 'a';
            if (son[p][t] == 0) son[p][t] = ++ idx;
            p = son[p][t];
            w[p] = id;//为什么放在里面，而不是外面呢  路径上的每个节点值相同。 并且值都是递增的，所以可以直接覆盖
        }
    }

    int query(String s){
        int p = 0;
        for (char c:s.toCharArray()){
            int t = c == '#' ? 26 : c - 'a';
            if (son[p][t] == 0) return -1;
            p = son[p][t];
        }
        return w[p];
    }

    public WordFilter(String[] words) {
        for (int i = 0; i < words.length; i++){
            String s = "#" + words[i]; //#为不存在的字符
            insert(s, i);
            for (int j = words[i].length() - 1; j >= 0; j--){
                s = words[i].charAt(j) + s;
                insert(s, i);
            }
        }
    }

    public int f(String prefix, String suffix) {
        return query(suffix + "#" + prefix);
    }
}































