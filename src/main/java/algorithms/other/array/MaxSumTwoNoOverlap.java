package algorithms.other.array;

/**
 * Created by yangyuan on 2021/12/6.
 * 1031. 两个非重叠子数组的最大和
 *
 * 给出非负整数数组 A ，返回两个非重叠（连续）子数组中元素的最大和，子数组的长度分别为 L 和 M。
 * （这里需要澄清的是，长为 L 的子数组可以出现在长为 M 的子数组之前或之后。）

 */
public class MaxSumTwoNoOverlap {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        return Math.max(work(nums, firstLen, secondLen), work(nums, secondLen, firstLen));
    }

    int work(int[] nums, int a, int b){
        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++){
            s[i] = s[i - 1] + nums[i - 1];
        }
        int res= 0;
        for (int i = a + b, maxa = 0; i <= n; i++){
            maxa = Math.max(maxa, s[i - b] - s[i - b - a]);
            res = Math.max(res, s[i] - s[i - b] + maxa);
        }
        return res;
    }
}
