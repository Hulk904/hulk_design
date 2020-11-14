package algorithms.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2020/9/19.
 * 341. 扁平化嵌套列表迭代器
 *
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。

 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。

 */
public class NestedIterator {

    List<Integer> q;

    int k;

    public NestedIterator(List<NestedInteger> nestedList) {
        //构造函数里遍历获取所有的数据
        int k = 0;
        q = new ArrayList();
        for (NestedInteger v:nestedList){
            dfs(v);
        }
    }

    void dfs(NestedInteger l){
        if (l.isInteger()) {
            q.add(l.getInteger());
        } else {
            for (NestedInteger v : l.getList()){
                dfs(v);
            }
        }
    }

    public Integer next() {
        return q.get(k++);
    }

    public boolean hasNext() {
        return k < q.size();
    }

    class NestedInteger{
        boolean isInteger(){
            return true;
        }
        Integer getInteger(){return 1;}

        List<NestedInteger> getList(){
            return new ArrayList<>();
        }
    }
}
