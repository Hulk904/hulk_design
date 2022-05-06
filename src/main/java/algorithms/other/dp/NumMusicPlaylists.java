package algorithms.other.dp;

/**
 * Created by yangyuan on 2021/6/14.
 * 920. 播放列表的数量
 * 你的音乐播放器里有 N 首不同的歌，在旅途中，你的旅伴想要听 L 首歌（不一定不同，即，允许歌曲重复）。请你为她按如下规则创建一个播放列表：

 每首歌至少播放一次。
 一首歌只有在其他 K 首歌播放完之后才能再次播放。
 返回可以满足要求的播放列表的数量。由于答案可能非常大，请返回它模 10^9 + 7 的结果

 */
public class NumMusicPlaylists {
    //dp[i][j] = dp[i-1, j - 1]*(n - (j-1)) + dp[i - 1, j-k]*(j-k)
    //前i首歌，共j种不同歌 的所有合法方案的集合

    public int numMusicPlaylists(int n, int goal, int k) {
        int N = 110, MOD = 1000000007;
        int dp[][] = new int[N][N];
        dp[0][0] = 1;
        for (int i = 1; i <= goal; i++){
            for (int j = 1; j <= n && j <= i; j++){
                //第i首歌为全新的歌，   +   第i首歌为重复的歌
                dp[i][j] = (int)((dp[i-1][j-1]*((long)n - j + 1) + dp[i-1][j]*(long)Math.max(j - k, 0))%MOD);
            }
        }
        return dp[goal][n];
    }
}
