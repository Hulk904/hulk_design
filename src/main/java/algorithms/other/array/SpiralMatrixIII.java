package algorithms.other.array;

/**
 * Created by yangyuan on 2021/5/30.
 * 885. 螺旋矩阵 III
 * 在 R 行 C 列的矩阵上，我们从 (r0, c0) 面朝东面开始

 这里，网格的西北角位于第一行第一列，网格的东南角位于最后一行最后一列。

 现在，我们以顺时针按螺旋状行走，访问此网格中的每个位置。

 每当我们移动到网格的边界之外时，我们会继续在网格之外行走（但稍后可能会返回到网格边界）。

 最终，我们到过网格的所有 R * C 个空间。

 按照访问顺序返回表示网格位置的坐标列表

 */
public class SpiralMatrixIII {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][]  res = new int[R*C][2];
        res[0] = new int[]{r0, c0};
        int d = 0, total = R*C, idx = 1;
        int[] dx = new int[]{0, 1, 0, -1}, dy = new int[] {1, 0, -1, 0};
        for (int k = 1; idx < total; k++){//k是步长
            for (int i = 0; i < 2 && idx < total; i++){//每个步长重复两次
                for (int j = 0; j < k && idx < total; j++){//遍历步长
                    int a = r0 + dx[d], b = c0 + dy[d];
                    if (a >= 0 && a < R && b >= 0 && b < C){
                        res[idx++] = new int[]{a, b};
                    }
                    r0 = a;
                    c0 = b;
                }
                d = (d + 1)%4;//每遍历一个步长换个方向
            }
        }
        return res;
    }
}
