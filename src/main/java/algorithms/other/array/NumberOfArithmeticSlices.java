package algorithms.other.array;

/**
 * Created by yangyuan on 2020/10/18.
 * 413. 等差数列划分
 *
 * 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 */
public class NumberOfArithmeticSlices {

    public int numberOfArithmeticSlices(int[] A) {
        int sum = 0;
        int count = 0;
        for (int i = 2; i < A.length; i++){
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]){
                count++;
            } else {
                sum += count*(count + 1)/2;//不能跟下面的交换位置
                count = 0;
            }
        }
        return sum + count*(count + 1)/2;
    }

    //比较直观的方式就是先计算 差值序列，然后统计区间，然后再累加和
    //上面的方式差不多，只是比较优雅点
}
