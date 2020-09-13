package algorithms.toutiao;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yangyuan on 2020/2/2.
 * 386. 字典序排数
 * 给定一个整数 n, 返回从 1 到 n 的字典顺序。

 例如，

 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 */
public class LexicalOrder {

    public static void main(String[] args) {
        LexicalOrder lexicalOrder = new LexicalOrder();
        lexicalOrder.lexicalOrder2(13);
    }

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<Integer> tree = new Stack<Integer>();
        if(n < 10) {
            for(int i = n;i > 0;i--) tree.push(i);
        }else for(int i = 9;i > 0;i--) tree.push(i);
        int t,m;
        while(!tree.empty()){
            t = tree.peek();
            tree.pop();
            res.add(t);
            if(t*10>n) continue;
            else {
                m = n - t * 10;
                if(m >9) m = 9;
            }
            for(int i = m;i >= 0;i--)
                if(t*10+i<=n)
                    tree.push(t*10+i);
        }
        return res;
    }

    private List<Integer> res = new ArrayList<>();

    private int n;

    /**
     * 递归实现
     * @param n
     * @return
     */
    public List<Integer> lexicalOrder2(int n){
        this.n = n;
        dfs(0);
        return res;
    }

    private void dfs(int k){
        if (k > n) return;
        if (k != 0) res.add(k);
        for (int i = 0; i <= 9; i++){
            if (k*10 + i > 0){
                dfs(10*k + i);
            }
        }
    }

}
