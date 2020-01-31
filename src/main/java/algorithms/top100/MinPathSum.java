package algorithms.top100;

/**
 * Created by yangyuan on 2020/1/2.
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 */
public class MinPathSum {

    public static void main(String[] args) {
        int [][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int[][] t = {{3, 8, 6, 0, 5, 9, 9, 6, 3, 4, 0, 5, 7, 3, 9, 3},
                {0, 9, 2, 5, 5, 4, 9, 1, 4, 6, 9, 5, 6, 7, 3, 2},
                {8, 2, 2, 3, 3, 3, 1, 6, 9, 1, 1, 6, 6, 2, 1, 9},
                {1, 3, 6, 9, 9, 5, 0, 3, 4, 9, 1, 0, 9, 6, 2, 7},
                {8, 6, 2, 2, 1, 3, 0, 0, 7, 2, 7, 5, 4, 8, 4, 8},
                {4, 1, 9, 5, 8, 9, 9, 2, 0, 2, 5, 1, 8, 7, 0, 9},
                {6, 2, 1, 7, 8, 1, 8, 5, 5, 7, 0, 2, 5, 7, 2, 1},
                {8, 1, 7, 6, 2, 8, 1, 2, 2, 6, 4, 0, 5, 4, 1, 3},
                {9, 2, 1, 7, 6, 1, 4, 3, 8, 6, 5, 5, 3, 9, 7, 3},
                {0, 6, 0, 2, 4, 3, 7, 6, 1, 3, 8, 6, 9, 0, 0, 8},
                {4, 3, 7, 2, 4, 3, 6, 4, 0, 3, 9, 5, 3, 6, 9, 3},
                {2, 1, 8, 8, 4, 5, 6, 5, 8, 7, 3, 7, 7, 5, 8, 3},
                {0, 7, 6, 6, 1, 2, 0, 3, 5, 0, 8, 0, 8, 7, 4, 3},
                {0, 4, 3, 4, 9, 0, 1, 9, 7, 7, 8, 6, 4, 6, 9, 5},
                {6, 5, 1, 9, 9, 2, 2, 7, 4, 2, 7, 2, 2, 3, 7, 2},
                {7, 1, 9, 6, 1, 2, 7, 0, 9, 6, 6, 4, 4, 5, 1, 0},
                {3, 4, 9, 2, 8, 3, 1, 2, 6, 9, 7, 0, 2, 4, 2, 0},
                {5, 1, 8, 8, 4, 6, 8, 5, 2, 4, 1, 6, 2, 2, 9, 7}};
        //System.out.println(sum(t, t.length - 1, t[0].length - 1));
        System.out.println(minPathSum(t));

    }

    /**
     * 动态规划  把所有的结果都记录在一个新数组里
     * 其他的方法 一是在原有的数组上修改 ，二是申请一个同宽的数组   其他步骤类似
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
       int[][]temp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j <grid[0].length; j++){
                if (i ==0 && j == 0 ){
                    temp[0][0] = grid[0][0];
                    continue;
                }
                if (i == 0 && j != 0){
                    temp[0][j] = grid[0][j] + temp[0][j - 1];
                    continue;
                }
                if (j == 0 && i != 0){
                    temp[i][0] = grid[i][0] + temp[i - 1][0];
                    continue;
                }
                temp[i][j] = Math.min(temp[i-1][ j], temp[i][ j - 1]) + grid[i][j];
            }
        }
        return temp[grid.length -1][grid[0].length -1];
    }


    /**
     * 递归  超时了。。。
     * return sum(grid, grid.length - 1, grid[0].length - 1);
     * @param grid
     * @param i
     * @param j
     * @return
     */
    public static int sum(int[][] grid, int i ,int j){
        if (i ==0 && j ==0){
            return grid[0][0];
        }
        if (i == 0 && j != 0){
            return sumOne(grid,0,j);
        }
        if (j == 0 && i != 0){
            return sumOne(grid,i,0);
        }
        return Math.min(sum(grid,i - 1,j), sum(grid,i,j - 1)) + grid[i][j];
    }

    private static int sumOne(int[][] grid, int i ,int j){
        int sum = 0;
        if (i == 0){
            for (int t = 0 ; t <= j ; t++){
                sum += grid[0][t];
            }
        }
        if (j == 0){
            for (int t=0; t <= i; t++){
                sum += grid[t][0];
            }
        }
        return sum;
    }
}
