package algorithms.other.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangyuan on 2021/7/4.
 * 952. 按公因数计算最大组件大小
 * 给定一个由不同正整数的组成的非空数组 A，考虑下面的图：
 有 A.length 个节点，按从 A[0] 到 A[A.length - 1] 标记；
 只有当 A[i] 和 A[j] 共用一个大于 1 的公因数时，A[i] 和 A[j] 之间才有一条边。
 返回图中最大连通组件的大小。
 */
public class LargestComponentSize {
    int[] p, s;//s 表示每个集合大小
    int find(int x){
        if (x != p[x]){
            p[x] = find(p[x]);
        }
        return p[x];
    }
    public int largestComponentSize(int[] nums) {
        int n = nums.length;
        p = new int[n];
        s = new int[n];
        for (int i = 0; i < n; i++){
            p[i] = i;
            s[i] = 1;
        }
        Map<Integer, List<Integer>> q = new HashMap();
        for (int i = 0; i < n; i++){
            int x = nums[i];
            for (int j = 1; j*j <= x; j++){
                if (x%j == 0){
                    if (j > 1) {
                        if (q.get(j) == null){
                            q.put(j, new ArrayList());
                        }
                        q.get(j).add(i);
                    }
                    if (q.get(x/j) == null){
                        q.put(x/j, new ArrayList());
                    }
                    q.get(x/j).add(i);
                }
            }
        }
        int res = 0;
        for (Map.Entry<Integer, List<Integer>> en:q.entrySet()){
            List<Integer> value = en.getValue();
            for (int i = 1; i < value.size(); i++){
                int a = value.get(0), b = value.get(i);
                if (find(a) != find(b)){
                    s[find(a)] += s[find(b)];
                    p[find(b)] = find(a);
                    res = Math.max(res, s[find(a)]);
                }
            }
        }
        return res;
    }
}
