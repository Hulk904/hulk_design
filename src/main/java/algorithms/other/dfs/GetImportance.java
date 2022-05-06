package algorithms.other.dfs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangyuan on 2021/3/10.
 * 690. 员工的重要性
 *
 * 给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。

 比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中。

 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。

 */
public class GetImportance {

    class Solution {
        Map<Integer, Employee> map = new HashMap();
        public int getImportance(List<Employee> employees, int id) {
            for(Employee e:employees) map.put(e.id, e);
            return dfs(id);
        }

        int dfs(int id){
            Employee e = map.get(id);
            int res = e.importance;
            for(int employee:e.subordinates){
                res += dfs(employee);
            }
            return res;
        }
        //  错误的dfs
        int dfs2(int id){
            Employee e = map.get(id);
            int res = e.importance;
            for (Integer t:e.subordinates){
                res += map.get(t).importance;// 这里没必要加， 应该是递归去取
                dfs2(t);
            }
            return res;
        }
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}
