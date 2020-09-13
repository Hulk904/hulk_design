package algorithms.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yangyuan on 2020/8/9.
 * 204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 */
public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] flag = new boolean[n  + 1];
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < n; i++){
            if (!flag[i]) primes.add(i);//没有被标记为过
            for (int j = 0; i * primes.get(j) < n; j++){
                flag[i * primes.get(j)] = true;
                if (i % primes.get(j) == 0) break;;
            }
        }
        return primes.size();
    }

    public int countPrimes2(int n) {
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);
        for (int i = 2; i*i < n; i++){//处理sqrt(n)以下，因为是对称的另外一部分
            if (prime[i]){
                for (int j = i*i; j < n; j+=i){
                    prime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++){
            if (prime[i]) count++;
        }
        return count;
    }
}
