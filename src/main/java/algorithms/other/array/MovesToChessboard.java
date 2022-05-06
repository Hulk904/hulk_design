package algorithms.other.array;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by yangyuan on 2021/4/15.
 * 782. 变为棋盘
 *
 * 一个 N x N的 board 仅由 0 和 1 组成 。每次移动，你能任意交换两列或是两行的位置。

 输出将这个矩阵变为 “棋盘” 所需的最小移动次数。“棋盘” 是指任意一格的上下左右四个方向的值均与本身不同的矩阵。如果不存在可行的变换，输出 -1。
 思维题
 */
public class MovesToChessboard {
    int MAX = (int)1e8;

    //返回一个数里面1的个数
    int getCount(int x){
        int res = 0;
        while(x > 0) {
            res += x&1;
            x>>=1;
        }
        return res;
    }

    //a 变为 b的代价
    int get(int a, int b){
        if (getCount(a) != getCount(b)) return MAX;
        return getCount(a^b)/2;
    }
    public int movesToChessboard(int[][] board) {
        //行列操作独立
        Set<Integer> row = new HashSet();//所有行的状态
        Set<Integer> col = new HashSet();//所有列状态
        int n = board.length;
        for (int i = 0; i < n; i++){
            int r = 0, c= 0;
            for (int j = 0; j < n; j++){
                r = r << 1 | board[i][j];
                c = c << 1 | board[j][i];
            }
            row.add(r);
            col.add(c);
        }
        if (row.size() != 2 || col.size() != 2) return -1;
        Iterator<Integer> ri = row.iterator();
        int r1 = ri.next() , r2 = ri.next();
        Iterator<Integer> ci = col.iterator();
        int c1 = ci.next(), c2 = ci.next();//取第一个和第二个元素
        if ((r1^r2) != (1<<n) - 1 || (c1^c2) != (1 << n) - 1) return -1;//是否互补  不互补
        int s1 = 0;
        for (int i = 0; i < n; i+= 2) s1 |= 1<<i;
        int s2 = ((1<<n) - 1)^s1;//s1的补集
        int rcost = Math.min(get(r1, s1), get(r1, s2));//行操作需要的代价
        int ccost = Math.min(get(c1, s1), get(c1, s2));//列操作需要的代价
        int res = rcost + ccost;
        if (res >= MAX) return  -1;
        return res;
    }
}
