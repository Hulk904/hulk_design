package algorithms.other.string;

/**
 * Created by yangyuan on 2021/5/16.
 * 848. 字母移位
 有一个由小写字母组成的字符串 S，和一个整数数组 shifts。

 我们将字母表中的下一个字母称为原字母的 移位（由于字母表是环绕的， 'z' 将会变成 'a'）。

 例如·，shift('a') = 'b'， shift('t') = 'u',， 以及 shift('z') = 'a'。

 对于每个 shifts[i] = x ， 我们会将 S 中的前 i+1 个字母移位 x 次。

 返回将所有这些移位都应用到 S 后最终得到的字符串。

 */
public class ShiftingLetters {

    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1, sum = 0; i >= 0; i--){
            sum = (sum + shifts[i])%26;//这里也需要取摸
            sb.append((char)((s.charAt(i) - 'a' + sum)%26 + 'a'));
        }
        sb.reverse();
        return sb.toString();
    }
}
