package algorithms.other.array;

import java.util.*;

/**
 * Created by yangyuan on 2021/6/27.
 * 947. 移除最多的同行或同列石头
 * n 块石头放置在二维平面中的一些整数坐标点上。每个坐标点上最多只能有一块石头。

 如果一块石头的 同行或者同列 上有其他石头存在，那么就可以移除这块石头。

 给你一个长度为 n 的数组 stones ，其中 stones[i] = [xi, yi] 表示第 i 块石头的位置，返回 可以移除的石子 的最大数量。

 */
public class RemoveStones {
    //并查集
    int [] p;
    int find(int x){
        if (x != p[x]){
            p[x] = find(p[x]);
        }
        return p[x];
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;
        p = new int[n];
        for (int i = 0; i < n; i++) p[i] = i;
        Map<Integer, List<Integer>> row = new HashMap(), col = new HashMap();
        for (int i = 0; i < n; i++){
            if (row.get(stones[i][0]) == null){
                row.put(stones[i][0], new ArrayList());
            }
            row.get(stones[i][0]).add(i);
            if (col.get(stones[i][1]) == null){
                col.put(stones[i][1], new ArrayList());
            }
            col.get(stones[i][1]).add(i);
        }
        for (Map.Entry<Integer, List<Integer>> en:row.entrySet()){
            for (int i = 1; i < en.getValue().size(); i++){
                p[find(en.getValue().get(0))] = find(en.getValue().get(i));
            }
        }
        for (Map.Entry<Integer, List<Integer>> en:col.entrySet()){
            for (int i = 1; i < en.getValue().size(); i++){
                p[find(en.getValue().get(0))] = find(en.getValue().get(i));
            }
        }
        Set<Integer> s = new HashSet();//最终可以保留多少点
        for (int i= 0; i < n; i++) s.add(find(i));
        return n - s.size();
    }
}
