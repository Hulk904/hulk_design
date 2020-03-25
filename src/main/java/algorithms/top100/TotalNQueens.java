package algorithms.top100;

import java.util.List;

/**
 * Created by yangyuan on 2020/2/20.
 * 52
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 * 这里的解法是 覃超视频里介绍的
 * 解题里面的第二种方法也是这样实现的
 */
public class TotalNQueens {

    private int total = 0;

    public static void main(String[] args) {
        System.out.println(new TotalNQueens().totalNQueens(4));
    }

    public int totalNQueens(int n) {
        dfs2(n, 0, 0, 0, 0);
        return total;
    }


    private  void dfs2(int n, int row, int col, int pie, int na){
        if (row >= n){
            total++;
            return;
        }
        int pick = ~(col | pie | na )& ((1 << n) -1);
        while (pick > 0){
            int useBit = pick & -pick;
            dfs2(n, row + 1, col | useBit, (pie | useBit) <<1, (na | useBit) >> 1);
            pick = pick & (pick - 1);
        }

    }

    private void dfs(int n, int row, int col, int pie ,int na){
        if (row >= n){
            total++;
            return;
        }
        //得到当前有效空位  就是可以放皇后的地方 col、pie、na 里面记录的是占有的情况
        int bits = (~(col | pie | na))&((1<<n) - 1);//& (1<<n) - 1   的目的是去掉高位的1
        while (bits > 0){
            //获取最低位的1
            //得到一个空位
            int p = bits & -bits;
            //下一层
            dfs(n, row + 1, col | p, (pie | p) << 1, (na | p) >> 1);
            //去掉最低位的1
            bits = bits & (bits - 1);
        }
    }


}
