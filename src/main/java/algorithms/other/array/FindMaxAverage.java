package algorithms.other.array;

/**
 * Created by yangyuan on 2020/12/26.
 * 643. 子数组最大平均数 I
 *
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 */
public class FindMaxAverage {

    public double findMaxAverage(int[] nums, int k) {
        double avg = Integer.MIN_VALUE;
        double sum = 0;
        for (int i = 0; i < k ;i ++){
            sum += nums[i];
        }
        avg = Math.max(sum/k, avg);
        for (int i = k, j = 0; i < nums.length; i++, j++){
            sum += nums[i];
            sum -= nums[j];
            avg = Math.max(sum/k, avg);
        }
        return avg;
    }

    //闫学灿 写法
    // 专业的就是简单 啊。。
    public double findMaxAverage2(int[] nums, int k) {
        double res = Integer.MIN_VALUE;
        for (int i = 0, j = 0, s = 0; i < nums.length; i++){
            s += nums[i];
            if (i - j + 1 > k) s -= nums[j++];
            if (i > k) res = Math.max(res, s/(double)k);
        }
        return res;
    }
}
