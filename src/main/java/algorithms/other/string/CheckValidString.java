package algorithms.other.string;

/**
 * Created by yangyuan on 2021/3/7.
 * 678. 有效的括号字符串
 *
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：

 任何左括号 ( 必须有相应的右括号 )。
 任何右括号 ) 必须有相应的左括号 ( 。
 左括号 ( 必须在对应的右括号之前 )。
 * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 一个空字符串也被视为有效字符串。

 */
public class CheckValidString {
    public boolean checkValidString(String s) {
        int low = 0, high = 0;//low、high记录左括号的取值范围
        for (char c:s.toCharArray()){
            if (c == '('){
                low++;
                high++;
            } else if ( c == ')'){
                low--;
                high--;
            } else {// 为 * 号时有三种情况。 左 low ++, high++ , 右括号  low--, high ++, 空格  low、hight 都不变
                //取并集然后就是 low--， high++ 了
                low--;
                high++;
            }
            low = Math.max(0, low);
            if (low > high) return false;
        }
        return low == 0;
    }
}
