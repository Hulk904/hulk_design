package algorithms.other.tanxin;

import java.util.Arrays;

/**
 * Created by yangyuan on 2021/5/30.
 * 881. 救生艇
 *
 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。

 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。

 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。


 */
public class NumRescueBoats {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int res = 0, l = 0, r = people.length - 1;
        while (l <= r){
            if (people[l] + people[r] <= limit){
                res++;
                l++;
                r--;
            } else {
                res ++;
                r--;
            }
        }
        return res;
    }
}
