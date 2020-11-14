package algorithms.other.array;

/**
 * Created by yangyuan on 2020/9/12.
 *
 * 304. 二维区域和检索 - 矩阵不可变
 *
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
 */
public class NumMatrix {

    int [][] sum;
    /**
     * 二维矩阵前缀和
     * 前缀和下标一般从1开始避免边界处理
     */
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0) return;
        sum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i <= matrix.length; i++){
            for (int j = 1; j <= matrix[0].length; j++){
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1]  - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;col1++;row2++;col2++;
        //注意这里是包含 row1 这一行和col1这一列的。 注意减去1。。。
        return sum[row2][col2] - sum[row1 - 1][col2] - sum[row2][col1 - 1] + sum[row1 - 1][col1 - 1];
    }
}
