package algorithms.graph;

/**
 * Created by yangyuan on 2020/1/17.
 */
public class DepthFirstSearch {
    private boolean[] marked;

    private int count;

    /**
     *
     * @param g
     * @param s 起点
     */
    public DepthFirstSearch(Graph g, int s){
        marked = new boolean[g.getV()];
        dfs(g, s);
    }

    private void dfs(Graph g, int s){
        marked[s] = true;
        count++;
        for (int w:g.adj(s)){
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }
 }
