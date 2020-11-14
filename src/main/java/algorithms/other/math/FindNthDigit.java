package algorithms.other.math;

/**
 * Created by yangyuan on 2020/10/17.
 */
public class FindNthDigit {

    public int findNthDigit(int n) {
        long m = n;
        long k = 1 /*位数*/, t = 9 /*当前位的个数*/, s = 1 /*k位的第一个数*/;
        while (m > k*t){
            m -= k*t;
            k++;
            t*=10;
            s*=10;
        }
        //
        s += (m + k - 1)/k -1;  //  n/k 上取整  -->  (n + k - 1)/k
        //
        m = (m % k) > 0  ? (m%k) : k;//是第几位
        return (int)((s + "").charAt((int)m - 1) - '0');
    }
}
