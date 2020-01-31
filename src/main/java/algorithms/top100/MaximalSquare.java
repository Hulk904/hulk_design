package algorithms.top100;

/**
 * Created by yangyuan on 2020/1/12.
 *
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。

 示例:

 输入:

 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0

 输出: 4

 思路 递推公式：
 其实还没咋想明白

 处理特例  {{'1'}}, {{'0'},{'1'}}

 */
public class MaximalSquare {

    public static void main(String[] args) {
//        char[][] data = {{'1','0', '1','0','0'},
//                {'1','0','1','1','1'},
//                {'1','1','1','1','1'},
//                {'1','0','0','1','0'}};

        char[][] data ={{'1', '0'}};
        System.out.println(maximalSquare(data));

    }

    public static int maximalSquare(char[][] matrix) {
        if (matrix == null){
            return 0;
        }
        if (matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++){
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
            }
        }
        for (int j = 0; j < col; j++){
            if (matrix[0][j] == '1'){
                dp[0][j] = 1;
            }
        }
        int maxW = dp[0][0];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (i == 0 || j == 0){
                    maxW = Math.max(maxW, dp[i][j]);
                    continue;
                }
                if (matrix[i][j] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    maxW = Math.max(maxW, dp[i][j]);
                }
            }
        }
        return maxW * maxW;
    }
}
