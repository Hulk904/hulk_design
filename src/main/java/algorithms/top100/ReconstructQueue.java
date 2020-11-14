package algorithms.top100;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by yangyuan on 2020/1/16.
 * 406. 根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。

 注意：
 总人数少于1100人。

 示例

 输入:
 [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

 输出:
 [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class ReconstructQueue {
    public static void main(String[] args) {
        int[][] data = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        System.out.println(JSON.toJSONString(reconstructQueue(data)));
    }

    public static int[][] reconstructQueue(int[][] people) {
        //身高降序、人数升序排列
        Arrays.sort(people, (o1,o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        //排序之后的数据  [[7,0],[7,1],[6,1],[5,0],[5,2],[4,4]]
        LinkedList<int[]> linkedList = new LinkedList<>();
        for(int[] i : people){
            //排序后按k插入
            linkedList.add(i[1], i);
        }
        return linkedList.toArray(new int[people.length][2]);//注意使用方法。（int[][]）linkedList.toArray(),会抛异常
    }
}
