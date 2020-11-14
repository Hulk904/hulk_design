package algorithms.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2020/10/17.
 * 401. 二进制手表
 *
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。

 每个 LED 代表一个 0 或 1，最低位在右侧。

 */
public class ReadBinaryWatch {

    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList();
        for (int i = 0; i < 1 << 10; i++){
            int s = 0;
            //计算亮灯个数
            for (int j = 0; j < 10; j++){
                if ((i >> j & 1) > 0){
                    s++;
                }
            }
            //灯数合法
            if (num == s){
                int a = i >> 6;
                int b = i & 63;
                //时间合法
                if (a < 12 && b < 60){
                    res.add(a + ":" + (b < 10 ? "0" + b : b));
                }
            }
        }
        return res;
    }
}
