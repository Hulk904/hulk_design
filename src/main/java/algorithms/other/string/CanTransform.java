package algorithms.other.string;

/**
 * Created by yangyuan on 2021/4/4.
 * 777. 在LR字符串中交换相邻字符
 * 在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）
 * 中进行移动操作。一次移动操作指用一个"LX"替换一个"XL"，或者用一个"XR"替换一个
 * "RX"。现给定起始字符串start和结束字符串end，请编写代码，
 * 当且仅当存在一系列移动操作使得start可以转换成end时， 返回True。

 */
public class CanTransform {

    public boolean canTransform(String start, String end) {
        //L只能左移， R只能右移  只能跨过X
        //L与R相对顺序不变
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        for (char c:start.toCharArray()){
            if (c != 'X')sb1.append(c);
        }
        for (char c:end.toCharArray()){
            if (c != 'X')sb2.append(c);
        }
        if (!sb1.toString().equals(sb2.toString())) return false;
        //start 的L 在end L的右边
        for (int i = 0, j = 0; i < start.length(); i++, j++){
            while (i < start.length() && start.charAt(i) != 'L') i++;
            while (j < end.length() && end.charAt(j) != 'L') j++;
            if (i < j) return false;
        }
        for (int i = 0, j = 0; i < start.length(); i++, j++){
            while (i < start.length() && start.charAt(i) != 'R') i++;
            while (j < end.length() && end.charAt(j) != 'R') j++;
            if (i > j) return false;
        }
        return true;
    }
}
