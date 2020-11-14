package algorithms.other.array;

/**
 * Created by yangyuan on 2020/11/14.
 *
 * 498. 对角线遍历
 *
 *
 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示
 */
public class FindDiagonalOrder {

    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return new int[0];
        int n = matrix[0].length;
        if (n == 0) return new int[0];
        int[] res = new int[m*n];
        int k = 0;
        for (int i = 0; i < m + n - 1; i++){
            if (i % 2 == 0){
                for (int j = Math.min(i, m - 1); j >= Math.max(0, 1 - n + i); j--){
                    res[k++] = matrix[j][i - j];
                }
            } else {
                for (int j = Math.max(0, 1 - n + i); j <= Math.min(i, m - 1); j++){
                    res[k++] = matrix[j][i - j ];
                }
            }
        }
        return res;
    }
}
