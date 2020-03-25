package algorithms.other;

/**
 * Created by yangyuan on 2020/2/27.
 *
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

 每行中的整数从左到右按升序排列。
 每行的第一个整数大于前一行的最后一个整数。
 跟240 类似
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int i = matrix.length, j = matrix[0].length;
        int l = 0, r = i*j - 1;
        /* 这样写也可以
        while (l < r){
            int mid = (l + r + 1) >> 1;
            if (matrix[mid/j][mid%j] > target) r = mid - 1; // 既然是大于所以r只能是mid - 1 （不包括目标）
            else l = mid;
        }
        return matrix[l/j][l%j] == target;
         */
        while (l < r){
            int mid = (l + r) >> 1;
            if (matrix[mid/j][mid%j] >= target) r = mid;//包括目标 所以可以 r = mid
            else l = mid + 1;
        }
        return matrix[r/j][r%j] == target;
    }
}
