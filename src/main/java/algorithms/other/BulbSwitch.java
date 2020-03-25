package algorithms.other;

/**
 * Created by yangyuan on 2020/3/1.
 * 319. 灯泡开关
 * 初始时有 n 个灯泡关闭。 第 1 轮，你打开所有的灯泡。 第 2 轮，每两个灯泡你关闭一次。 第 3 轮，每三个灯泡切换一次开关（如果关闭则开启，如果开启则关闭）。第 i 轮，每 i 个灯泡切换一次开关。 对于第 n 轮，你只切换最后一个灯泡的开关。 找出 n 轮后有多少个亮着的灯泡。

 * 1、一个灯是否亮还是灭取决于它被按的次数（奇数次亮，偶数次灭）
 * 2、而被按的次数 取决于约数个数 。。
 *  所以相当于求1 -- n 个灯泡中被按次数是奇数的 个数
 *  什么样的数的约数是奇数呢？ ===》 平方数
 */
public class BulbSwitch {

    /**
     *
     * n即是灯泡个数也是开关轮数
     * @param n
     * @return
     */
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n+ 0.0);
    }
}
