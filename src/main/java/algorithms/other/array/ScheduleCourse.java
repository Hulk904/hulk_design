package algorithms.other.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by yangyuan on 2020/12/20.
 * 630. 课程表 III
 *
 * 这里有 n 门不同的在线课程，他们按从 1 到 n 编号。每一门课程有一定的持续上课时间（课程时间）t 以及关闭时间第 d 天。一门课要持续学习 t 天直到第 d 天时要完成，你将会从第 1 天开始。

 给出 n 个在线课程用 (t, d) 对表示。你的任务是找出最多可以修几门课。

 */
public class ScheduleCourse {

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);//大根堆
        int total = 0;
        for (int[] c:courses){
            total += c[0];
            queue.add(c[0]);
            if (total > c[1]){//超过 deadline了
                total -= queue.poll();//出队一个最大的
            }
        }
        return queue.size();
    }
}
