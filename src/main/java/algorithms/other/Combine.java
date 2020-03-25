package algorithms.other;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * Created by yangyuan on 2020/3/3.
 * 77. 组合
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class Combine {

    public static void main(String[] args) {

        Combine combine = new Combine();
        combine.combine(4,2);
        System.out.println(JSON.toJSONString(combine.list));

    }

    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        Stack<Integer> path = new Stack<>();
        dfs(path, n, 1, k);
        return list;
    }

    void dfs(Stack<Integer> path, int n, int start, int k){
        if (k == 0){
            list.add(new LinkedList<>(path));
            return;
        }
        for (int i = start; i <= n; i++){
            path.add(i);
            dfs(path, n, i + 1, k - 1);//与39 不一样 ，不允许重复，所以传i + 1
            path.pop();
        }
    }


}
