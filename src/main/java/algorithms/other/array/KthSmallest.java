package algorithms.other.array;

/**
 * Created by yangyuan on 2020/10/2.
 * 378. 有序矩阵中第K小的元素
 *
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 */
public class KthSmallest {

    /**
     * 二分
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        int l = Integer.MIN_VALUE, r = Integer.MAX_VALUE;
        while (l < r){
            int mid = (int)((long) l + r >> 1);
            int i = matrix[0].length - 1, count = 0;
            //下面的i并没有被重复赋值， 因为下面小于mid的数不会比上面多。总体上i是逐层减少的
            for (int j = 0; j < matrix.length; j++){
                while (i >= 0 && matrix[j][i] > mid) i--;
                count += i + 1;
            }
            if (count >= k) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
