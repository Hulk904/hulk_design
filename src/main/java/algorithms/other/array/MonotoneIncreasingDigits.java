package algorithms.other.array;

/**
 * Created by yangyuan on 2021/3/21.
 * 738. 单调递增的数字
 *
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。

 （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 */
public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        char [] c = ("" + N).toCharArray();
        int max = -1, idx = -1;
        for (int i = 0; i < c.length; i++){
            if (c[i] - '0' > max){
                max = c[i] - '0';
                idx = i;
            }
            if (i + 1 < c.length && c[i] > c[i + 1]){ //第一个下降的点
                c[idx]--;
                for (int j = idx + 1; j < c.length; j++){
                    c[j] = '9';
                }
                break;
            }
        }
        return Integer.parseInt(new String(c));
    }
}
