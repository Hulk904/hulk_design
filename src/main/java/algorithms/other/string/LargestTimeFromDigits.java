package algorithms.other.string;

/**
 * Created by yangyuan on 2021/6/27.
 * 949. 给定数字能组成的最大时间
 * 给定一个由 4 位数字组成的数组，返回可以设置的符合 24 小时制的最大时间。

 24 小时格式为 "HH:MM" ，其中 HH 在 00 到 23 之间，MM 在 00 到 59 之间。最小的 24 小时制时间是 00:00 ，而最大的是 23:59 。从 00:00 （午夜）开始算起，过得越久，时间越大。

 以长度为 5 的字符串，按 "HH:MM" 格式返回答案。如果不能确定有效时间，则返回空字符串。

 */
public class LargestTimeFromDigits {
    public String largestTimeFromDigits(int[] arr) {
        String res = "";
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                if (i != j){
                    for (int q = 0; q < 4; q++){
                        if (q != i && q != j){
                            int p = 6 - i - j - q;
                            String hour = arr[i] + "" + arr[j], min = arr[q] +""+ arr[p];
                            String time = hour + ":" + min;
                            if ( hour.compareTo("23") <= 0 && min.compareTo("59") <= 0){
                                if ("".equals(res) || res.compareTo(time) < 0 ) res = time;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
