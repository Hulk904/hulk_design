package algorithms.other.array;

import javafx.util.Pair;

import java.util.Arrays;

/**
 * Created by yangyuan on 2021/5/18.
 * 853. 车队
 *
 * N  辆车沿着一条车道驶向位于 target 英里之外的共同目的地。

 每辆车 i 以恒定的速度 speed[i] （英里/小时），从初始位置 position[i] （英里） 沿车道驶向目的地。

 一辆车永远不会超过前面的另一辆车，但它可以追上去，并与前车以相同的速度紧接着行驶。

 此时，我们会忽略这两辆车之间的距离，也就是说，它们被假定处于相同的位置。

 车队 是一些由行驶在相同位置、具有相同速度的车组成的非空集合。注意，一辆车也可以是一个车队。

 即便一辆车在目的地才赶上了一个车队，它们仍然会被视作是同一个车队。


 会有多少车队到达目的地?

 */
public class CarFleet {
    //每辆车不会被前面的车影响，所以从后往前推
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++){
            pairs[i] = new Pair(position[i], speed[i]);
        }
        Arrays.sort(pairs, (a, b) -> a.position - b.position);
        int res = n;
        double last = 0;
        for (int i = n - 1; i >= 0; i--){
            double time = (target - pairs[i].position)/(double)pairs[i].speed;
            if (time <= last + 0.000001) res--;//用Math.abs(time -last) < 0.000001 好像不行
            else last = time;
        }
        return res;
    }

    class Pair{
        int position;
        int speed;

        public Pair(int position, int speed){
            this.position = position;
            this.speed = speed;
        }
    }
}
