package algorithms.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yangyuan on 2020/2/16.给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

 例如，给定三角形：

 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

 */
public class MinimumTotal {

    private int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        List<List<Integer>> data = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(2);
        data.add(list1);
        List<Integer> list2 = Arrays.asList(3,4);
        data.add(list2);
        List<Integer> list3 = Arrays.asList(6,5,7);
        data.add(list3);
        List<Integer> list4 = Arrays.asList(4,1,8,3);
        data.add(list4);
//        MinimumTotal min = new MinimumTotal();
//        System.out.println(min.minimumTotal(data));
        System.out.println(minimumTotalDp(data));
    }

    public static  int minimumTotalDp(List<List<Integer>> triangle) {
        if (triangle == null ){
            return 0;
        }
        if (triangle.size() == 1){
            return triangle.get(0).get(0);
        }
        for (int i = triangle.size() - 2 ; i >= 0; i--){
            for (int j = 0 ; j < triangle.get(i).size(); j++){
                triangle.get(i).set(j, triangle.get(i).get(j)
                        + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }


    //暴力求解
    //超时了
    public  int minimumTotal(List<List<Integer>> triangle) {
        recursion(triangle, 0, 0, 0);
        return  result;
    }

    private  void recursion(List<List<Integer>> triangle, int i, int j, int  sum){
        if (i == triangle.size() - 1){
            sum += triangle.get(i).get(j);
            result = Math.min(sum, result);
            return;
        }
        sum += triangle.get(i).get(j);
        recursion(triangle, i + 1, j, sum);
        recursion(triangle, i + 1, j + 1, sum);
    }


    //dp
}
