package algorithms.other.array;

import java.util.List;

/**
 * Created by yangyuan on 2021/3/13.
 *
 * 699. 掉落的方块
 *
 * 在无限长的数轴（即 x 轴）上，我们根据给定的顺序放置对应的正方形方块。

 第 i 个掉落的方块（positions[i] = (left, side_length)）是正方形，其中 left 表示该方块最左边的点位置(positions[i][0])，side_length 表示该方块的边长(positions[i][1])。

 每个方块的底部边缘平行于数轴（即 x 轴），并且从一个比目前所有的落地方块更高的高度掉落而下。在上一个方块结束掉落，并保持静止后，才开始掉落新方块。

 方块的底边具有非常大的粘性，并将保持固定在它们所接触的任何长度表面上（无论是数轴还是其他方块）。邻接掉落的边不会过早地粘合在一起，因为只有底边才具有粘性。

  

 返回一个堆叠高度列表 ans 。每一个堆叠高度 ans[i] 表示在通过 positions[0], positions[1], ..., positions[i] 表示的方块掉落结束后，目前所有已经落稳的方块堆叠的最高高度。

 */
public class FallingSquares {

    //线段树模版题
    public List<Integer> fallingSquares(int[][] positions) {
        return null;
    }
}
