package algorithms.other.graph;

import java.util.List;

/**
 * Created by yangyuan on 2021/5/16.
 * 841. 钥匙和房间
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。

 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。

 最初，除 0 号房间外的其余所有房间都被锁住。

 你可以自由地在房间之间来回走动。

 如果能进入每个房间返回 true，否则返回 false。

 */
public class CanVisitAllRooms {
    boolean[] st;
    List<List<Integer>> g;
    //图的遍历问题
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        g = rooms;
        st = new boolean[n];
        dfs(0);
        for (int i = 0; i < n; i++){
            if (!st[i]){
                return false;
            }
        }
        return true;
    }

    void dfs(int u){
        if (st[u]) return;
        st[u] = true;
        for(int i:g.get(u)){
            if(!st[i]){
                dfs(i);
            }
        }
    }
}
