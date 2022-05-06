package algorithms.other;

/**
 * Created by yangyuan on 2021/4/12.
 * 780. 到达终点
 * 从点 (x, y) 可以转换到 (x, x+y)  或者 (x+y, y)。

 给定一个起点 (sx, sy) 和一个终点 (tx, ty)，如果通过一系列的转换可以从起点到达终点，则返回 True ，否则返回 False。

 */
public class ReachingPoints {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        //逆向（路径唯一）  x > y ==>  x - y, y  变来
        //     y > x  ==>  x, y -  x 变来
        while (tx >= sx && ty >= sy){
            if (tx == ty) break;
            if (tx > ty){
                if (ty > sy) tx %= ty;
                else return (tx -sx) % ty == 0;
            } else {
                if (tx > sx) ty %= tx;
                else return (ty - sy) % tx == 0;
            }
        }
        return sx == tx && sy == ty;
    }
}
