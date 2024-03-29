package algorithms.other.array;

/**
 * Created by yangyuan on 2021/3/20.
 * 717. 1比特与2比特字符
 *
 * 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。

 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。

 */
public class IsOneBitCharacter {

    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        for (; i < bits.length - 1; i++){
            if (bits[i] == 1){//1开头 的一定是两位，0开头的是一位
                if (i + 1 < bits.length - 1){
                    i++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
