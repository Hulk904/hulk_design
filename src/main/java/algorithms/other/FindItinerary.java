package algorithms.other;


import java.util.*;

/**
 * Created by yangyuan on 2020/9/19.
 * 332. 重新安排行程
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，
 * 对该行程进行重新规划排序。所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从
 * JFK 开始。

 欧拉路径：遍历图的所有边，并且只遍历一次。。。
 */
public class FindItinerary {

    //todo 这里为啥用TreeSet 不行呢????
    Map<String, PriorityQueue<String>> map ;

    List ans;

    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null || tickets.size() == 0){
            return new LinkedList<>();
        }
        map = new HashMap<>();
        ans = new  LinkedList();
        for (List<String> t: tickets){
            if (map.get(t.get(0)) == null){
                map.put(t.get(0), new PriorityQueue<>());
            }
            map.get(t.get(0)).add(t.get(1));
        }
        dfs("JFK");
        return ans;
    }

    void dfs(String u){
        while (map.get(u) != null && map.get(u).size() > 0){
            String s = map.get(u).iterator().next();
            map.get(u).remove(s);
            dfs(s);
        }
        ans.add(0, u);
    }

    Map<String, TreeSet<String>> mset ;

    // error
    public List<String> findItinerary2(List<List<String>> tickets) {
        if (tickets == null || tickets.size() == 0){
            return new LinkedList<>();
        }
        mset = new HashMap<>();
        ans = new  LinkedList();
        for (List<String> t: tickets){
            if (mset.get(t.get(0)) == null){
                mset.put(t.get(0), new TreeSet<>());
            }
            mset.get(t.get(0)).add(t.get(1));
        }
        dfs2("JFK");
        return ans;
    }

    void dfs2(String u){
        while (mset.get(u) != null && mset.get(u).size() > 0){
            String s = mset.get(u).iterator().next();
            mset.get(u).remove(s);
            dfs2(s);
        }
        ans.add(0, u);
    }
}
