package algorithms.other;

import java.util.*;

/**
 * Created by yangyuan on 2021/3/20.
 * 721. 账户合并
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 
 * 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。

 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。
 请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按字符 ASCII
 顺序排列的邮箱地址。账户本身可以以任意顺序返回。

 */
public class AccountsMerge {
    int p [];

    int find(int x){
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        p = new int[n];
        for (int i =0; i < n; i ++) p[i] = i;
        Map<String, List<Integer>> map = new HashMap();
        for (int i = 0; i < n; i++){
            for (int j = 1; j < accounts.get(i).size(); j++){
                if (map.get(accounts.get(i).get(j)) == null){
                    map.put(accounts.get(i).get(j), new ArrayList());
                }
                map.get(accounts.get(i).get(j)).add(i);
            }
        }
        for(Map.Entry<String, List<Integer>> en:map.entrySet()){
            for(int i = 1; i < en.getValue().size(); i++){
                p[find(en.getValue().get(i))] = find(en.getValue().get(0));
            }
        }
        Set<String>[] res = new Set[n];
        for (int i = 0; i < n; i++){
            for (int j = 1; j < accounts.get(i).size(); j++){
                int idx = find(i);
                if (res[idx] == null){
                    res[idx] = new TreeSet();
                }
                res[idx].add(accounts.get(i).get(j));
            }
        }
        List<List<String>> ans = new ArrayList();
        for (int i = 0; i < n; i++){
            if (res[i] != null && res[i].size() > 0){
                List<String> t = new ArrayList();
                t.add(accounts.get(i).get(0));
                for (String m:res[i]) t.add(m);
                ans.add(t);
            }
        }
        return ans;
    }
}
