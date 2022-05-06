package algorithms.other.dp;

import java.util.Arrays;

/**
 * Created by yangyuan on 2021/2/16.
 *
 * AcWing 285. 没有上司的舞会
 *
 * 跟 打家劫舍III  类似
 *
 * 树形dp  的经典题
 *
 *
 */
public class DanceMeeting {

    int N = 6010;
    int[] h = new int[N];
    int[] e = new int[N];
    int[] ne = new int[N];
    int idx = 0;
    int[][] f = new int[N][2];
    boolean[] has_fa = new boolean[N];
    int[] happy ;


    int  danceMeeting(int[] happy, int u){
        this.happy = happy;
        Arrays.fill(h, -1);
        dfs(u);
        return Math.max(f[u][0], f[u][1]);
    }


    // 构图的过程 初始化  e， ne， h
     void add(int a,int b)
    {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx ++;
    }


    //业务逻辑核心
    //
     void dfs(int u)
    {
        f[u][1] = happy[u];
        for(int i = h[u]; i != -1;i = ne[i])
        {
            int j = e[i];
            dfs(j);

            f[u][1] += f[j][0];                    // f[u][0] 以u为跟的子树中选择，并且不选择u节点的方案
            f[u][0] += Math.max(f[j][1], f[j][0]); // f[u][1]表示以u为根的子树中选择，并且选择u节点的方案
        }
    }

}
