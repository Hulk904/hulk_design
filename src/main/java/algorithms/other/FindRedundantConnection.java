package algorithms.other;

/**
 * Created by yangyuan on 2021/3/7.
 *
 * 684. 冗余连接
 *
 * 在本问题中, 树指的是一个连通且无环的无向图。

 输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。

 结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。

 返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。

 */
public class FindRedundantConnection {

    static int[] p;

    //这种方式会把 路径压缩为离父节点一个距离的长度。
    static int  find(int x){
        if(p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    /**
     * 使用并查集  可以快速判断 两个点是不是在一个集合
     * @param edges
     * @return
     */
    public static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        p = new int[n + 1];
        for (int i = 1; i <= n; i++) p[i] = i;
        for (int[] i:edges){
            int a = find(i[0]);
            int b = find(i[1]);
            if (a != b) p[a] = b;//为啥 p[i[0]] = b 不行呢？
            else return i;
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int [][] edges = new int[][]{{1,2}, {1,3} ,{2,3}};
        System.out.println(findRedundantConnection(edges));
    }

}
