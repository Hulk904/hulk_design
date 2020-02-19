package algorithms.toutiao;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yangyuan on 2020/2/2.
 */
public class LexicalOrder {

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(lexicalOrder(134)));
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

}
