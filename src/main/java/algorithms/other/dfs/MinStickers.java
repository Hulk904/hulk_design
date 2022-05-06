package algorithms.other.dfs;

import java.util.Arrays;

/**
 * Created by yangyuan on 2021/3/13.
 * 691. 贴纸拼词
 *
 * 我们给出了 N 种不同类型的贴纸。每个贴纸上都有一个小写的英文单词。
 你希望从自己的贴纸集合中裁剪单个字母并重新排列它们，从而拼写出给定的目标字符串 target。
 如果你愿意的话，你可以不止一次地使用每一张贴纸，而且每一张贴纸的数量都是无限的。
 拼出目标 target 所需的最小贴纸数量是多少？如果任务不可能，则返回 -1。
 */
public class MinStickers {

    int MAX = 20;
    int n;
    String target;
    String[] stickers;
    int[][] g;
    int[] f;

    /**
     *  爆搜 + 剪枝（记忆化）
     * @param stickers
     * @param target
     * @return
     */
    public int minStickers(String[] stickers, String target) {
        this.stickers = stickers;
        this.target = target;
        n = target.length();
        g = new int[1 << n][26];
        f = new int[1 << n];
        Arrays.fill(f, -1);
        for(int i = 0; i < g.length; i++){
            Arrays.fill(g[i], -1);
        }
        int res = dfs(0);
        if (res == MAX) return -1;
        return res;
    }

    int dfs(int state){
        int v = f[state];
        if (v > 0) return v;//以计算过
        if (state == (1<<n) - 1) return v = 0;//全1
        v = MAX;
        for (String str:stickers){
            int cur = state;
            for (char c:str.toCharArray()){
                cur = fill(cur, c);
            }
            if (cur != state){
                v = Math.min(v, dfs(cur) + 1);
            }
        }
        f[state] = v;
        return v;
    }

    //在state 下填充 字符 c
    int fill (int state, char c){
        int v = g[state][c - 'a'];
        if (v != -1) return v;
        v = state;
        for (int i = 0; i < n; i++){// 找到目标单词里面每一个没有出现过的字符
            if ((state >> i & 1 ) == 0 && target.charAt(i) == c){
                v += 1<<i;
                break;
            }
        }
        g[state][c - 'a'] = v;
        return v;
    }

}



















