package algorithms.other;

/**
 * Created by yangyuan on 2020/2/26.
 * 576. 出界的路径数
 * 给定一个 m × n 的网格和一个球。球的起始坐标为 (i,j) ，你可以将球移到相邻的单元格内，或者往上、下、左、右四个方向上移动使球穿过网格边界。但是，你最多可以移动 N 次。找出可以将球移出边界的路径数量。答案可能非常大，返回 结果 mod 109 + 7 的值。

  

 示例 1：

 输入: m = 2, n = 2, N = 2, i = 0, j = 0
 输出: 6

 与329类似
 */
public class FindPaths {

    int[][][] dp ;

    int [][] direction = {{-1, 0},{0, 1},{1, 0},{0, -1}};

    public static void main(String[] args) {
        System.out.println(new FindPaths().findPaths(7,8,16,1,5));
    }

    public int findPaths(int m, int n, int N, int i, int j) {
        dp = new int[m][n][N + 1];
        return bfs(m, n, N, i ,j);
    }

    //超时了。。。 方法是正确的
    int bfs (int m, int n, int k, int x, int y){
        if (k == 0){
            return 0;
        }
        if (dp[x][y][k] != 0){
            return dp[x][y][k];
        }
        int v = 0;
        for (int i = 0; i < 4; i++){
            int a = direction[i][0] + x;
            int b = direction[i][1] + y;
            if (a < 0 | a >= m | b < 0 | b >= n){
                v++;
            } else {
                v += bfs(m, n, k - 1, a, b);
            }
            v %= 1000000007;
        }
        return v;
    }


}
