package algorithms.other;

import java.util.*;

/**
 * Created by yangyuan on 2020/10/17.
 *
 * 399. 除法求值
 *
 * 给出方程式 A / B = k, 其中 A 和 B 均为用字符串表示的变量， k 是一个浮点型数字。根据已知方程式求解问题，并返回计算结果。如果结果不存在，则返回 -1.0。

 输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。



 */
public class CalcEquation {

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(new ArrayList<String>(){{add("a");add("b");}});
        equations.add(new ArrayList<String>(){{add("b");add("c");}});
        equations.add(new ArrayList<String>(){{add("c");add("d");}});
        double[] values = new double[]{2.0, 2.0, 2.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(new ArrayList<String>(){{add("a");add("d");}});
        CalcEquation calcEquation = new CalcEquation();
        calcEquation.calcEquation(equations, values, queries);

    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Set<String> vers = new HashSet();
        Map<String, Map<String, Double>> d = new HashMap();
        //遍历 equations
        for (int i = 0; i < equations.size(); i++){
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double c = values[i];
            if (d.get(a) == null) d.put(a, new HashMap());
            if (d.get(b) == null) d.put(b, new HashMap());
            d.get(a).put(b, c);
            d.get(b).put(a, 1/c);
            vers.add(a);
            vers.add(b);
        }
        //floyd
        for (String k:vers){
            for (String i:vers){
                for (String j:vers){
                    if (d.get(i).get(k) != null && d.get(j).get(k) != null){
                        d.get(i).put(j, d.get(i).get(k)*d.get(k).get(j));
                    }
                }
            }
        }
        double[] res = new double[queries.size()];
        //计算结果
        for (int i = 0; i < queries.size(); i++){

            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            if (d.get(a) != null && d.get(a).get(b) != null) res[i] = d.get(a).get(b);
            else res[i] = -1.0;
        }
        return res;
    }
}
