package algorithms.top100;

import java.util.Arrays;

/**
 * Created by yangyuan on 2020/1/20.
 */
public class LeastInterval {

    public static void main(String[] args) {
        char[] data = {'A','A','A','B','B','B'};
        System.out.println(leastInterval2(data, 50));
    }

    /**
     * 思路不一样
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
            idel -= Math.min(max, map[i]);
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
