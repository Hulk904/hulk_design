package algorithms.other;

import java.util.List;

/**
 * Created by yangyuan on 2020/4/17.
 * 面试题 08.06. 汉诺塔问题
 */
public class Hanota {

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A.size(), A, B, C) ;
    }

    private void move(int n, List<Integer> a, List<Integer> b, List<Integer> c){
        if (n == 1){
            c.add(a.remove(a.size() - 1));
            return;
        }
        move(n - 1, a, c, b);
        c.add(a.remove(a.size() - 1));
        move(n - 1, b, a, c);
    }

}
