package algorithms.top100;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * Created by yangyuan on 2020/1/28.
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。

 示例:

 输入:
 [
 ["1","0","0","0","0"],
 ["1","0","1","1","1"],
 ["1","1","1","1","1"],
 ["1","0","0","1","0"]
 ]
 输出: 6

 看了答案之后手敲的，还是没有明白里面的含义啊啊啊 尤其是left 和right的计算
 */
public class MaximalRectangle {

    public static void main(String[] args) {
        //char[][] data = {{'1'}};
        char[][] data ={{'1','0','0','0','0'},
                        {'1','0','1','1','1'},
                        {'1','1','1','1','1'},
                        {'1','0','0','1','0'}};
        System.out.println(maximalRectangle(data));

    }

    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0){
            return 0;
        }
        int result = 0;
        int n = matrix[0].length;
        int[] height = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        for (int i = 0; i < matrix.length; i++){
            int nextLeft = 0;
            int nextRight = n;
            //height
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == '1'){
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }
            //left
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == '1'){
                    left[j] = Math.max(nextLeft, left[j]);
                } else {
                    left[j] = 0;
                    nextLeft = j + 1;
                }
            }
            System.out.println(JSON.toJSONString(left));
            //right
            for (int j = n - 1; j >= 0; j--){
                if (matrix[i][j] == '1'){
                    right[j] = Math.min(nextRight, right[j]);
                } else {
                    right[j] = n;
                    nextRight = j;
                }
            }
            for (int j = 0; j < n; j ++){
                result = Math.max(result, (right[j] - left[j])*height[j]);
            }
        }
        return result;
    }
}
