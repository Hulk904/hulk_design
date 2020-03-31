package algorithms.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2020/3/31.
 *51. N皇后
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 */
public class SolveNQueens {
    char[][] g;

    boolean[] row;
    boolean[] col;
    //记录对角是否有皇后 需要2n的大小空间
    boolean[] pie;
    boolean[] la;
    int n ;

    List<List<String>> res ;

    /**
     * 比较朴素的遍历方式
     * 每个点选择放或者不妨皇后 然后进行遍历。。。。
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        g = new char[n][n];
        row = new boolean[n];
        col = new boolean[n];
        pie = new boolean[2*n];
        la = new boolean[2*n];
        res = new ArrayList();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                g[i][j] = '.';
            }
        }
        dfs(0, 0, 0);
        return res;
    }
    /**
     * 一种更加原始的搜索顺序
     x、y 选择坐标点
     已选择s 皇后数
     **/
    private void dfs(int x, int y, int s){
        if (y == n){
            //超过边界 ，重置 下一行再开始
            y = 0;
            x++;
        }
        if (x == n){
            if (s ==n){
                List<String> item = new ArrayList();
                for (int i = 0; i<n; i++){
                    item.add(new String(g[i]));
                }
                res.add(item);
            }
            return ;
        }
        //选择放皇后
        dfs(x, y + 1, s);

        //选择放皇后
        if (!row[x] && !col[y] && !pie[x + y] && !la[x - y + n]){
            g[x][y] = 'Q';
            row[x] = col[y] = pie[x + y] = la[x-y+n] = true;
            dfs(x, y + 1, s + 1);
            row[x] = col[y] = pie[x + y] = la[x-y+n] = false;
            g[x][y] = '.';
        }
    }

    /**
     * 这种方式更快些啊
     * 遍历方式和全排列类似了
     * @param u
     */
    private void dfs(int u){
        if (u == n){
            List<String> item = new ArrayList<>();
            for (int i = 0; i < n; i++){
                item.add(new String(g[i]));
            }
            res.add(item);
            return;
        }
        //按行枚举 所以没有row了
        for (int i = 0; i < n; i++){
            if (!col[i] && !pie[u + i] && !la[i -u + n]){//可以选择
                g[u][i] = 'Q'; //作出选择
                col[i] = pie[u + i] = la[i - u + n] = true;
                dfs(u + 1);
                g[u][i] = '.';
                col[i] = pie[u + i] = la[i - u + n] = false;
            }
        }
    }

}
