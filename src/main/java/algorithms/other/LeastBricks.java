package algorithms.other;

import com.sun.tools.corba.se.idl.InterfaceGen;

import java.util.*;

/**
 * Created by yangyuan on 2020/2/24.
 * 554. 砖墙
 *
 * 你的面前有一堵方形的、由多行砖块组成的砖墙。 这些砖块高度相同但是宽度不同。你现在要画一条自顶向下的、穿过最少砖块的垂线。

 砖墙由行的列表表示。 每一行都是一个代表从左至右每块砖的宽度的整数列表。

 如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你需要找出怎样画才能使这条线穿过的砖块数量最少，并且返回穿过的砖块数量。

 你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
 */
public class LeastBricks {

    public static void main(String[] args) {
        List<List<Integer>> data = new ArrayList<>();
        List<Integer>  list = Arrays.asList(1,2,2,1);
        data.add(list);
        List<Integer> list1 = Arrays.asList(3,1,2);
        data.add(list1);
        List<Integer> list2 = Arrays.asList(1,3,2);
        data.add(list2);
        List<Integer> list3 = Arrays.asList(2,4);
        data.add(list3);
        List<Integer> list4 = Arrays.asList(3,1,2);
        data.add(list4);
        List<Integer> list5 = Arrays.asList(1,3,1,1);
        data.add(list5);
        System.out.println(leastBricks(data));
    }

    public static int leastBricks(List<List<Integer>> wall) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < wall.size(); i++){
            int temp = 0;
            for (int j = 0; j < wall.get(i).size() - 1; j++){
                temp += wall.get(i).get(j);
//                if (map.containsKey(temp)){
//                    map.put(temp, map.get(temp) + 1);
//                    result = Math.max(result, map.get(temp));
//                } else {
//                    map.put(temp, 1);
//                    result = Math.max(result, 1);
//                }
                /*
                相对上面更加简洁的表达
                 */
                map.put(temp, map.getOrDefault(temp, 0) + 1);
                result = Math.max(result, map.get(temp));
            }
        }
        return wall.size() - result;
    }

}
