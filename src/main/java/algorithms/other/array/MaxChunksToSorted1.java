package algorithms.other.array;

/**
 * Created by yangyuan on 2021/4/4.
 * 769. 最多能完成排序的块
 *
 * 数组arr是[0, 1, ..., arr.length - 1]的一种排列，我们将这个数组分割成几个“块”，并将这些块分别进行排序。
 * 之后再连接起来，使得连接的结果和按升序排序后的原数组相同。

 我们最多能将数组分成多少块？

 */
public class MaxChunksToSorted1 {
    //相对2 方便划分区间
    public int maxChunksToSorted(int[] arr) {
        int res = 0;
        for (int i =0, x = 0; i < arr.length; i++){//x 前缀的最大值
            x = Math.max(x, arr[i]);
            if (x == i) res ++;
        }
        return res;
    }
}
