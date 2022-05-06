package algorithms.other.array;

/**
 * Created by yangyuan on 2021/12/6.
 * 1030. 距离顺序排列矩阵单元格
 * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。

 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。

 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和
 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）

 */
public class AllCellsDistOrder {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] res = new int[rows*cols][2];
        int[] dx = new int[]{1, 1, -1, -1}, dy = new int[]{1, -1, -1, 1};//方向注意： 需要跟下面的x=rcenter - d 一致  （首先斜下）
        res[0] = new int[]{rCenter, cCenter};
        int index = 1;
        for (int d = 1; ;d++){//枚举距离
            int x = rCenter - d, y = cCenter, cnt = 0;//cnt 这一层有多少数
            for (int i = 0; i < 4; i ++){
                for (int j = 0; j < d; j++){//枚举长度为d的一条边
                    if (x >= 0 && x < rows && y >=0 && y < cols){
                        res[index++] = new int[]{x, y};
                        cnt++;
                    }
                    x+= dx[i];
                    y+= dy[i];
                }
            }
            if (cnt == 0) break;
        }
        return res;
    }
}
