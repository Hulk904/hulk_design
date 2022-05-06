package algorithms.other.string;

/**
 * Created by yangyuan on 2021/5/9.
 * 820. 单词的压缩编码
 *
 * 单词数组 words 的 有效编码 由任意助记字符串 s 和下标数组 indices 组成，且满足：

 words.length == indices.length
 助记字符串 s 以 '#' 字符结尾
 对于每个下标 indices[i] ，s 的一个从 indices[i] 开始、到下一个 '#' 字符结束（但不包括 '#'）的 子字符串 恰好与 words[i] 相等
 给你一个单词数组 words ，返回成功对 words 进行编码的最小助记字符串 s 的长度 。

 */
public class MinimumLengthEncoding {
    int N = 14010;
    int son[][] = new int[N][26];
    int cnt[] = new int[N];//有多少个子节点
    int len[] = new int[N];//字符串长度
    int idx = 0;
    void insert(String s){
        int p = 0;
        for (int i = s.length() - 1; i >= 0; i--){
            int u = s.charAt(i) - 'a';
            if (son[p][u] == 0) son[p][u] = ++idx;
            cnt[p]++;
            p = son[p][u];
        }
        len[p] = s.length();
    }
    public int minimumLengthEncoding(String[] words) {
        for (String s:words){
            insert(s);
        }
        int res = 0;
        for (int i = 1; i <= idx; i++){
            if (cnt[i] == 0){
                res += len[i] + 1;
            }
        }
        return res;
    }
}
