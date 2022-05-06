package algorithms.other.map;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2021/3/14.
 *
 * 705. 设计哈希集合
 *
 * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。

 实现 MyHashSet 类：

 void add(key) 向哈希集合中插入值 key 。
 bool contains(key) 返回哈希集合中是否存在这个值 key 。
 void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。

 */
public class MyHashSet {
    int N = 19997;
    List<Integer>[] d ;

    /** Initialize your data structure here. */
    public MyHashSet() {
        d = new List[N];
    }

    private int find(List<Integer> list, Integer key){
        if (list == null) return -1;
        for (int i = 0; i < list.size(); i++){
            if (list.get(i) == key.intValue()){
                return i;
            }
        }
        return -1;
    }

    public void add(int key) {
        int t = key%N;
        int k = find(d[t] ,key);
        if (k < 0) {
            if (d[t] == null){
                d[t] = new ArrayList();
            }
            d[t].add(key);
        }
    }

    public void remove(int key) {
        int t = key%N;
        int k = find(d[t], key);
        if (k >= 0){
            d[t].remove(k);
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int t = key%N;
        int k = find(d[t], key);
        return k >= 0;
    }
}
