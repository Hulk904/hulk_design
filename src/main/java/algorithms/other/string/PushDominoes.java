package algorithms.other.string;

import java.util.Arrays;

/**
 * Created by yangyuan on 2021/5/15.
 * 838. 推多米诺
 * 一行中有 N 张多米诺骨牌，我们将每张多米诺骨牌垂直竖立。

 在开始时，我们同时把一些多米诺骨牌向左或向右推
 */
public class PushDominoes {
    public String pushDominoes(String s) {
        s = "L" + s + "R";
        int n = s.length();
        int[] l = new int[n], r = new int[n];
        for (int i = 0, j = 0; i < n; i++){
            if (s.charAt(i) != '.') j = i;
            l[i] = j;
        }
        for (int i = n - 1, j = 0; i >= 0; i--){
            if (s.charAt(i) != '.') j = i;
            r[i] = j;
        }
        char[] res = new char[n];
        for (int i = 0; i < n; i++){
            char L = s.charAt(l[i]), R = s.charAt(r[i]);
            if (L == 'L' && R == 'R') res[i] = '.';
            else if (L == 'L' && R == 'L') res[i] = 'L';
            else if (L == 'R' && R == 'R') res[i] = 'R';
            else {
                if (i - l[i] < r[i] - i) res[i] = 'R';
                else if (r[i] -i < i - l[i]) res[i] = 'L';
                else res[i] = '.';
            }
        }
        return new String(Arrays.copyOfRange(res, 1, n - 1));
    }
}
