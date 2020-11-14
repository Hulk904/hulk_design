package algorithms.other;

/**
 * Created by yangyuan on 2020/10/18.
 * 414. 第三大的数
 *
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 */
public class ThirdMax {

    /**
     * 画图理解
     * c, b, a 分别存放第三大，第二大，最大的数
     * 如果 x > a  （c < b < a < x）那么  c, b, a  整体往右移动一位
     * 如果 x在 a和b之间， 那么  c, b都往右移动一位
     * 如果 x在 c和b之间，那么 c往后移动一位
     * 这样可以避免漏掉各种情况。
     * 实现时使用long 避免边界情况
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        long a = Integer.MIN_VALUE - 1L;
        long b = a, c = a, sum = 0;//sum记录不同数个数
        for (int i:nums){
            if (i > a ) {
                sum++;
                c = b;
                b= a;
                a = i;
            } else if ( i < a &&  i > b){
                sum++;
                c = b;
                b = i;
            } else if (i < b && i > c){
                sum++;
                c = i;
            }
        }
        if (sum < 3) return (int)a;
        return (int)c;
    }

    public int thirdMaxError(int[] nums) {
        int max = Integer.MIN_VALUE;
        int mid = Integer.MIN_VALUE;
        int min = Integer.MIN_VALUE;
        for (int i : nums){
            if (i > max && i > mid && i > min){
                max = i;
                mid = max;
                continue;
            }
            if (i > mid && i >min){
                mid = i;
                min = mid;
                continue;
            }
            min = i;
        }
        System.out.println(min + " " + max);
        return min == Integer.MIN_VALUE ? max : min;
    }
}
