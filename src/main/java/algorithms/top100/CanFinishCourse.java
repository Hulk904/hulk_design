package algorithms.top100;

import java.util.LinkedList;

/**
 * Created by yangyuan on 2020/1/10.
 *
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。

 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]

 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？

 示例 1:

 输入: 2, [[1,0]]
 输出: true
 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。

 主要是判断是否存在循环有向图

 */
public class CanFinishCourse {

    public static void main(String[] args) {
        int[][] data = {{1,0}};
        System.out.println(canFinish(3, data));
    }


    /**
     * 广度优先
     * 先用一个数组记录所有元素的入度
     * 如果入度为0 则进队列， 队列元素出对的时候分别减去相关元素的入度，如果为0 则继续入队
     * 最后判断 numCourse是否为0
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        for (int[] item:prerequisites){
            indegree[item[1]]++;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i =0; i < indegree.length; i++){
            if (indegree[i] == 0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            Integer item = queue.pop();
            numCourses--;
            for (int[] course:prerequisites){
                if (course[0] == item){
                    indegree[course[1]]--;
                    if (indegree[course[1]] == 0){
                        queue.add(course[1]);
                    }
                }
            }
        }
        return numCourses == 0;
    }
}
