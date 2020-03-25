package algorithms.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2020/3/6.
 */
public class SmallestFactorization {

    public static void main(String[] args) {
        smallestFactorization(18000000);
    }


    public static int smallestFactorization(int a) {
        if (a < 10){
            return a;
        }
        List<Integer> result = new ArrayList();
        int actor = 9;
        while (a != 1 && actor > 1){
            while (a%actor == 0){
                a = a/actor;
                result.add(actor);
            }
            actor--;
        }
        if (a > 9){
            return 0;
        }
        long temp = 0;
        for (int i = result.size() - 1; i >=0 ;i--){
            if (temp*10l + result.get(i) > Integer.MAX_VALUE){
                return 0;
            }
            temp = temp*10 + result.get(i);
        }
        return (int)temp;
    }
}
