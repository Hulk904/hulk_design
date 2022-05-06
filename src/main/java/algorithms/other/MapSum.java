package algorithms.other;

/**
 * Created by yangyuan on 2021/3/6.
 * 677. 键值映射
 *
 * 实现一个 MapSum 类，支持两个方法，insert 和 sum：

 MapSum() 初始化 MapSum 对象
 void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。

 */
public class MapSum {

    int n = 2500;
    int son[][];
    int v[];//
    int s[];//子树的和
    int idx;

    /** Initialize your data structure here. */
    public MapSum() {
        son = new int[n][26];
        v = new int[n];
        s = new int[n];
        idx = 0;
    }


    public void insert(String key, int val) {
        insert(key, val, v[query(key)]);
    }

    void insert (String t, int value, int old){
        int p = 0;
        for (char c:t.toCharArray()){
            int u = c - 'a';
            if (son[p][u] == 0) son[p][u] = ++idx;;
            p = son[p][u];
            s[p] += value - old;
        }
        v[p] = value;
    }

    int query(String s){
        int p = 0;
        for (char c:s.toCharArray()){
            int u = c - 'a';
            if (son[p][u] == 0) return 0;
            p = son[p][u];
        }
        return p;
    }

    public int sum(String prefix) {
        return s[query(prefix)];
    }
}
