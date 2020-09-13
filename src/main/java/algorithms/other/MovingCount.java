package algorithms.other;

/**
 * Created by yangyuan on 2020/4/8.
 * 面试题13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格
 * （不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/solution/mian-shi-ti-13-ji-qi-ren-de-yun-dong-fan-wei-dfs-b/
 */
public class MovingCount {

    public static void main(String[] args) {

    }

    private int m;

    private int n;

    private int k;

    private boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        visited = new boolean[m][n];
        return dfs(0, 0);
    }

    /**
     * 刚开始想的比较简单以为直接计算数位和小于k就可以了
     * 当k比较小的时候，即便数位和满足了但是这些区域可能不是连续的
     * dfs遍历有返回值的，注意理解。 向右和向下递归就行了。
     * @param i
     * @param j
     * @return
     */
    private int dfs(int i, int j){
        if (i < 0 || i >= m || j < 0 || j >= n || sum(i, j) > k || visited[i][j]) return 0;
        visited[i][j] = true;
        return 1 + dfs(i + 1, j) + dfs(i, j + 1);
    }

    private int sum(int i, int j) {
        int res = 0;
        int a = i, b = j;
        while (i > 0) {
            res += i % 10;
            i = i / 10;
        }
        while (j > 0) {
            res += j % 10;
            j = j / 10;
        }
        return res;
    }

}
