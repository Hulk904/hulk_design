package algorithms.other.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yangyuan on 2021/3/28.
 * 757. 设置交集大小至少为2
 *
 * 一个整数区间 [a, b]  ( a < b ) 代表着从 a 到 b 的所有连续整数，包括 a 和 b。

 给你一组整数区间intervals，请找到一个最小的集合 S，使得 S 里的元素与区间intervals中的每一个整数区间都至少有2个元素相交。

 输出这个最小集合S的大小。

 */
public class IntersectionSizeTwo {

    /**
     * 要求的集合里面的元素并不是连续的
     * @param intervals
     * @return
     */
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[1] != o2[1]){//右端点升序
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];//左端点降序
        });
        int cnt = 0;//当前选择点集的最后一个数
        List<Integer> q = new ArrayList<Integer>(){{add(-1);}};// 加入一个最小值
        for (int[] r:intervals){
            if (r[0] > q.get(cnt)){//比最大值还大
                q.add(r[1] - 1);//补充最后两个点
                q.add(r[1]);
                cnt += 2;
            } else if (r[0] > q.get(cnt - 1)){//比第二大值还大
                q.add(r[1]);//缺一个点，补充最后一个点
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] inter = new int[][]{{1,2},{10,11}};
        new IntersectionSizeTwo().intersectionSizeTwo(inter);
    }
}
