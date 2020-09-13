package algorithms.other;

/**
 * Created by yangyuan on 2020/7/5.
 * 73. 矩阵置零
 *
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 */
public class SetZeroes {

    /**
     * 第一行和第一列 使用额外变量 记录
     * 然后用第一行和第一列去记录其他元素的情况
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) return;
        int r0 = 1;
        int c0 = 1;
        for (int i = 0; i < matrix.length; i++){
            if (matrix[i][0] == 0) {
                c0 = 0;
                break;
            }
        }
        for (int i = 0; i < matrix[0].length; i++){
            if (matrix[0][i] == 0){
                r0 = 0;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++){
            for (int j = 1; j < matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++){
            for (int j = 1; j < matrix[0].length; j++){
                if (matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if (r0 == 0) {
            for (int i = 0; i < matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }
        if (c0 == 0){
            for (int i  = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
