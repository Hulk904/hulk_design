package algorithms.other.array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by yangyuan on 2021/7/5.
 * 957. N 天后的牢房
 * 8 间牢房排成一排，每间牢房不是有人住就是空着。

 每天，无论牢房是被占用或空置，都会根据以下规则进行更改：

 如果一间牢房的两个相邻的房间都被占用或都是空的，那么该牢房就会被占用。
 否则，它就会被空置。
 （请注意，由于监狱中的牢房排成一行，所以行中的第一个和最后一个房间无法有两个相邻的房间。）

 我们用以下方式描述监狱的当前状态：如果第 i 间牢房被占用，则 cell[i]==1，否则 cell[i]==0。

 根据监狱的初始状态，在 N 天后返回监狱的状况（和上述 N 种变化）。

 */
public class PrisonAfterNDays {

    public int[] prisonAfterNDays(int[] cells, int n) {
        int state = 0;
        for (int x:cells)  state = state*2 + x;//转为十进制
        int[] f = new int[256];
        Arrays.fill(f, -1);
        f[state] = 0;
        for (int i = 1; n > 0; i++){
            int next = get(state);
            n--;
            if (f[next] != -1) n%=i - f[next];
            else f[next] = i;
            state = next;
        }
        return output(state);
    }
    int get(int state){
        int res = 0;
        for (int i = 7; i >= 0; i--){
            res <<= 1;
            if (i < 7 && i > 0){
                if ((state >> i - 1 & 1) == (state >> i + 1 & 1)){
                    res++;
                }
            }
        }
        return res;
    }

    int [] output(int state){
        int[] res = new int[8];
        for (int i = 7; i >= 0; i--){
            res[7 - i] = state >> i & 1;
        }
        return res;
    }

}
