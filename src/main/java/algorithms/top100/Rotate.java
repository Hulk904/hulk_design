package algorithms.top100;

import com.alibaba.fastjson.JSON;

/**
 * Created by yangyuan on 2020/1/1.
 * 给定一个 n × n 的二维矩阵表示一个图像。

 将图像顺时针旋转 90 度。

 说明：

 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

 从3*3的矩阵中找到规律，然后 再换

 */
public class Rotate {

    public static void main(String[] args) {
        //int[][] data = {{1,2,3},{4,5,6},{7,8,9}};//[[7,4,1],[8,5,2],[9,6,3]]
        int [][] data = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate2(data);
        System.out.println(JSON.toJSONString(data));
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length ;
        for(int i = 0; i < (n + 1) / 2; i++){
            for (int j = 0; j< n / 2 ; j++){
                int temp = matrix[i][j]; //注意i ，j 的坐标 不都是i在前j在后， 找到他们的规律
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i]= matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }
    }

    //分圈处理  这个比较好理解 ，相对上面的
    public static void rotate2(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int ti = 0, tj = 0;
        int dm = m - 1, dn = n - 1;
        while (ti < dm && tj < n){
            dealOneCircle(matrix, ti++, tj++, dm--, dn--);
        }
    }

    private static void dealOneCircle(int[][] matrix, int ti, int tj, int dm, int dn){
        for (int i = 0; i + tj < dn; i++){
            int temp = matrix[ti][tj + i];
            matrix[ti][tj + i] = matrix[dm - i][tj];
            matrix[dm - i][tj] = matrix[dm][dn - i];
            matrix[dm][dn - i] = matrix[ti + i][dn];
            matrix[ti + i][dn] = temp;
        }
    }

    // 方法2   1、 先对换矩阵  2、 翻转每一行。。。


}
