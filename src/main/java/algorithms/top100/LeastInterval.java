package algorithms.top100;

import java.util.Arrays;

/**
 * Created by yangyuan on 2020/1/20.
 */
public class LeastInterval {

    public static void main(String[] args) {
        char[] data = {'A','A','A','B','B','B'};
        System.out.println(leastIntervalTimes2(data, 50));
    }

    /**
     * 和下面的思路类似。 是正向的思路。 extra主要是为了补额外还需要的
     * @param tasks
     * @param n
     * @return
     */
    public static int leastIntervalTimes2(char[] tasks, int n){
        if (tasks.length == 0){
            return 0;
        }
        int[] data = new int[26];
        for (char c:tasks){
            data[c - 'A']++;
        }
        Arrays.sort(data);
        int maxTask = data[25];
        int extra = 0;
        int other = tasks.length - maxTask;
        if (other > n*maxTask){
            return tasks.length;
        }
        for (int i = 0; i< n && i <= 24; i++){
            if (data[24 - i] == maxTask){
                extra++;
            }
        }
        return (n+1)*(maxTask - 1) + 1 + extra;
    }

    /**
     * 思路不一样  算出idel块，然后加上总的tasks就是最后的答案了。。
     * @param tasks
     * @param n
     * @return
     */
    public static int leastInterval2(char[] tasks, int n){
        int[] map = new int[26];
        for (int i = 0; i < tasks.length; i++){
            map[tasks[i] - 'A']++;
        }
        Arrays.sort(map);
        int idel = (map[25] - 1)*n;//最大可能浪费时间
        int max = map[25] - 1;
        for (int i = 24; i >=0 && map[i] > 0; i--){
            idel -= Math.min(max, map[i]);//map[i]有值说明是充分利用了
        }
        return idel <= 0 ? tasks.length : tasks.length + idel;//如果有浪费直接加上任务数量，如果没有最大也就是任务数量了。
    }

    /**
     * 最先执行任务多的
     * @param tasks
     * @param n
     * @return
     */
    public static int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (int i = 0; i < tasks.length; i++){
            map[tasks[i] - 'A']++;
        }
        Arrays.sort(map);
        int total = 0;
        while (map[25] > 0){
            for (int i = 0; i <= n; i++){
                if (map[25] == 0){
                    break;
                }
                if (25 - i >= 0 && map[25 - i] > 0){
                    map[25 - i]--;
                }
                total++;
            }
            Arrays.sort(map);
        }
        return total;
    }

}
