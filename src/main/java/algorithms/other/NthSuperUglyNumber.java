package algorithms.other;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yangyuan on 2020/9/12.
 * 313. 超级丑数
 *
 * 编写一段程序来查找第 n 个超级丑数。

 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
 */
public class NthSuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Pair> heap = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.first - o2.first;
            }
        });
        for (int x:primes){
            heap.add(new Pair(x, 0));
        }
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n;){
            Pair t = heap.poll();
            if (t.first != ans[i - 1]) ans[i++] = t.first;
            int idx = t.secoond;
            int p = t.first/ans[idx];
            heap.add(new Pair(p*ans[idx + 1], idx + 1));
        }
        return ans[n - 1];
    }

    class Pair{
        public int first;
        public int secoond;
        public Pair(int first, int second){
            this.first = first;
            this.secoond = second;
        }
    }
}
