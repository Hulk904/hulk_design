package algorithms.toutiao;

/**
 * Created by yangyuan on 2020/1/29.
 * 440. 字典序的第K小数字
 * 给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。

 注意：1 ≤ k ≤ n ≤ 109。

 示例 :

 输入:
 n: 13   k: 2

 输出:
 10

 解释:
 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。

 */
public class  FindKthNumber {

    public static void main(String[] args) {
        //System.out.println(findKthNumber(681692778, 351251360));
        //System.out.println(findKthNumber2(10000,10000));
        findKthNumber(13, 4);
    }

    public static int findKthNumber2(int n, int k){
        int prefix = 1;
        int p = 1;
        while (p < k){
            int count = getCount2(prefix, n);
            if (count + p > k){
                prefix *= 10;
                p++;
            } else {
                prefix++;
                p+=count;
            }
        }
        return prefix;
    }

    /**
     * 以prefix为前缀小于 n 的 数个数
     * @param prefix
     * @param n
     * @return
     */
    private static int getCount2(long prefix, int n){
        int count = 0;
        long cur = prefix;
        long next = prefix + 1;
        while (cur <= n){
            count += Math.min(n + 1,next) - cur;
            next *= 10;
            cur *= 10;
        }
        return count;
    }

    public static int findKthNumber(int n, int k) {
        int p = 1;//累计数
        int prefix = 1;//前缀  ，也是最后返回结果
        while (p < k){
            int count = getCount(prefix, n);
            //第k个数在当前前缀下
            if (p + count > k){
                prefix *= 10;
                p++;
            } else {
                //第k个数不在当前前缀下
                prefix++;
                p += count;
            }
        }
        return prefix;
    }

    /** 确定一个前缀下所有子节点的个数
     * 以prefix为前缀的数 ，在n之前有几个数
     * @param prefix
     * @param n
     * @return
     */
    private static int getCount(long prefix, int n){
        int count = 0;
        long cur = prefix;
        long next = prefix + 1;
        while (cur <= n){
            count += (Math.min(n + 1,next) - cur);//注意是 n + 1
            cur *= 10;
            next *= 10;
        }
        return count;
    }
}
