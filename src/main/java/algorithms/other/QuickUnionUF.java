package algorithms.other;

/**
 * Created by yangyuan on 2020/2/18.
 *
 * 并查集
 * 路径压缩
 */
public class QuickUnionUF {

    private int[] roots;

    public QuickUnionUF(int n){
        roots = new int[n];
        for (int i = 0; i < n; i++){
            roots[i] = i;
        }
    }

    private int findRoot(int i){
        int root = i;
        //找到真正的root
        while (root != roots[root]){
            root = roots[root];
        }
        //路径压缩
        while (i != roots[i]){
            int temp = roots[i];
            roots[i] = root;
            i = temp;
        }
        return root;
    }

    /**
     * 判断两个元素是不是在一个集合中
     * @param p
     * @param q
     * @return
     */
    public  boolean connected(int p, int q){
        return findRoot(p) == findRoot(q);
    }

    /**
     * 合并p q的集合
     * @param p
     * @param q
     */
    public void union(int p, int q){
        int proot = findRoot(p);
        int qroot = findRoot(q);
        roots[proot] =  qroot;
    }
}
