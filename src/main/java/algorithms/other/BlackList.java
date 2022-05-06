package algorithms.other;

import java.util.*;

/**
 * Created by yangyuan on 2021/3/14.
 * 710. 黑名单中的随机数
 * 给定一个包含 [0，n ) 中独特的整数的黑名单 B，写一个函数从 [ 0，n ) 中返回一个不在 B 中的随机整数。

 对它进行优化使其尽量少调用系统方法 Math.random() 。

 */
public class BlackList {
    int n;
    int len;
    Map<Integer, Integer> map;

    public BlackList(int N, int[] blacklist) {
        n = N;
        len = blacklist.length;
        map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = n -len; i< n; i++) set.add(i);
        for (int i:blacklist){
            set.remove(i);
        }
        Iterator<Integer> itr =  set.iterator();
        for(int i:blacklist){
            if (i < n - len){
                map.put(i, itr.next());
            }
        }
    }

    public int pick() {
        int k = new Random().nextInt(n - len);
        if (map.get(k) != null) return map.get(k);
        return k;
    }
}
