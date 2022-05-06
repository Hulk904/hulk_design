package algorithms.other.array;

/**
 * Created by yangyuan on 2021/5/6.
 * 807. 保持城市天际线
 *
 * 在二维数组grid中，grid[i][j]代表位于某处的建筑物的高度。 我们被允许增加任何数量（不同建筑物的数量可能不同）的建筑物的高度。 高度 0 也被认为是建筑物。

 最后，从新数组的所有四个方向（即顶部，底部，左侧和右侧）观看的“天际线”必须与原始数组的天际线相同。 城市的天际线是从远处观看时，由所有建筑物形成的矩形的外部轮廓。 请看下面的例子。

 建筑物高度可以增加的最大总和是多少？

 */
public class MaxIncreaseKeepingSkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] r = new int[m], c = new int[n];
        //计算每行和每列的最大值
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                r[i] = Math.max(r[i], grid[i][j]);
                c[j] = Math.max(c[j], grid[i][j]);
            }
        }
        int res = 0;
        //遍历每个元素 求差值
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                res += Math.min(r[i], c[j]) - grid[i][j];
            }
        }
        return res;
    }
}
