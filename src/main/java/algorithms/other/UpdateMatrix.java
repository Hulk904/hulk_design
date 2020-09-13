package algorithms.other;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by yangyuan on 2020/4/16.
 * 542. 01 矩阵
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。

 两个相邻元素间的距离为 1
 */
public class UpdateMatrix {

    int[][] direction = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int[][] updateMatrix(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < res.length; i++){
            Arrays.fill(res[i], -1);
        }
        LinkedList<int[]> list = new LinkedList();
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    list.add(new int[]{i, j});
                    res[i][j] = 0;
                }
            }
        }
        int cur = 0;
        while (list.size() > 0){
            int size = list.size();
            cur++;
            while (size-- > 0){
                int[] item = list.removeFirst();
                for (int i = 0; i < direction.length; i++){
                    int x = direction[i][0] + item[0];
                    int y = direction[i][1] + item[1];
                    if (x >=0 && x <matrix.length && y >= 0 && y < matrix[0].length
                            && res[x][y] == -1){
                        res[x][y] = cur;
                        list.addLast(new int[]{x, y});
                    }
                }
            }

        }
        return res;
    }
}
