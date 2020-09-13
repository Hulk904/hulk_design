package algorithms.other;

/**
 * Created by yangyuan on 2020/2/12.
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
public class MyPow {

    public static void main(String[] args) {
        System.out.println(Math.abs( Integer.MIN_VALUE));
       // System.out.println(myPow(2, -2147483648));

    }

    public static double myPow(double x, int n){
        if (n == 0){
            return 1;
        }
        if (n < 0){
            return 1/pow(x, -n);
        }
        return pow(x,n);
    }

    public static  double pow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double temp = pow(x*x, n/2);
        double ext = n%2 == 0 ? 1 : x;
        return temp*ext;
    }

    public static double myPow2(double x, int n){
        int temp = n;
        if (n < 0) n = -n;
        double res = 1;
        for (int k = n; k > 0; k = k/2){
            if ((k & 1) != 0) res *= x;
            x *=x;
        }
        if (temp < 0) res = 1/res;
        return res;
    }

}
