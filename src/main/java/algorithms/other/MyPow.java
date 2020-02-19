package algorithms.other;

/**
 * Created by yangyuan on 2020/2/12.
 */
public class MyPow {

    public static void main(String[] args) {
        System.out.println(myPow(2, -2147483648));

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
        double temp = pow(x*x, n/2);
        double ext = n%2 == 0 ? 1 : x;
        return temp*ext;
    }
}
