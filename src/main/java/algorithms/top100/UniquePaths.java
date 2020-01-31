package algorithms.top100;

/**
 * Created by yangyuan on 2020/1/2.
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

 问总共有多少条不同的路径？

 */
public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(10,10));
    }

    /**
     * 动态规划的 记录中间结果，其他的优化可能就是减少内存分配了。
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n){
        int[][] array = new int[m][n];
        for (int i = 0 ; i< m ; i++){
            array[i][0] = 1;
        }
        for (int j=0; j < n; j++){
            array[0][j] = 1;
        }
        for (int i = 1; i< m; i++){
            for (int j = 1; j < n; j++){
                array[i][j] = array[i - 1][j] + array[i][j - 1];
            }
        }
        return array[m-1][n-1];
    }


    //排列组合 计算阶乘的时候可能会超 long的范围
    public static int uniquePaths2(int m, int n) {
        if (m == 1 || n ==1){
            return 1;
        }
        return (int)(jiecheng(m -1 + n -1)/jiecheng(m -1)/jiecheng(n-1));
    }

    private static long jiecheng(int m){
        long a=1;
        for (int i =1 ; i <=m ; i ++){
            a*=i;
        }
        return a;
    }

}
