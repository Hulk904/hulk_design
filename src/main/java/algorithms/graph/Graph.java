package algorithms.graph;

/**
 * Created by yangyuan on 2020/1/17.
 * 无向图
 */
public class Graph {

    /**
     * 顶点数目
     */
    private  int v;

    /**
     * 边的数目
     */
    private int e;

    /**
     * 领接表
     */
    private Bag<Integer>[] adj;

    public Graph (int v){
        this.v = v;
        this.e = 0;
        adj = (Bag<Integer>[]) new Bag[v];
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
        e++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public int getE() {
        return e;
    }

    public void setE(int e) {
        this.e = e;
    }
}
