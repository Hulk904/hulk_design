package algorithms.top100;

/**
 * Created by yangyuan on 2020/1/1.
 */
public class ClimbStairs {


    public static void main(String[] args) {
        System.out.println(climbStairs(45));

    }

    private static int climbStairs(int n){
        if (n == 1) return 1;
        if (n == 2) return 2;
        int sum  = 0;
        int a = 1;
        int b = 2;
        for (int i = 2; i < n; i++){
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }


    //递归实现  比较慢
    private static int climbStairs2(int n){
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }
}
