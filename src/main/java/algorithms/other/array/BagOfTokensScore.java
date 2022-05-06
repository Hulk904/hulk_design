package algorithms.other.array;

import java.util.Arrays;

/**
 * Created by yangyuan on 2021/6/27.
 * 948. 令牌放置
 * 你的初始 能量 为 P，初始 分数 为 0，只有一包令牌 tokens 。其中 tokens[i] 是第 i 个令牌的值（下标从 0 开始）。

 令牌可能的两种使用方法如下：

 如果你至少有 token[i] 点 能量 ，可以将令牌 i 置为正面朝上，失去 token[i] 点 能量 ，并得到 1 分 。
 如果我们至少有 1 分 ，可以将令牌 i 置为反面朝上，获得 token[i] 点 能量 ，并失去 1 分 。
 每个令牌 最多 只能使用一次，使用 顺序不限 ，不需 使用所有令牌。

 在使用任意数量的令牌后，返回我们可以得到的最大 分数 。

 */
public class BagOfTokensScore {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int l = 0;
        while (l < tokens.length && power >= tokens[l]) power -= tokens[l++];
        int res = l;
        for (int r = tokens.length - 1; r > l; r--){
            if (l < tokens.length - r) break;
            power += tokens[r];
            while (l < r && power >= tokens[l]) power -= tokens[l++];
            res = Math.max(res, l - (tokens.length - r));
        }
        return res;
    }
}
