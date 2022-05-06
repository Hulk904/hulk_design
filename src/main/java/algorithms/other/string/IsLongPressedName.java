package algorithms.other.string;

/**
 * Created by yangyuan on 2021/6/19.
 * 925. 长按键入
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，
 * 而字符可能被输入 1 次或多次。
 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），
 那么就返回 True。

 */
public class IsLongPressedName {


    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (i < name.length() && j < typed.length()){
            if (name.charAt(i) != typed.charAt(j)) return false;
            int x = i + 1, y = j + 1;
            while (x < name.length() && name.charAt(x) == name.charAt(i)) x++;
            while (y < typed.length() && typed.charAt(y) == typed.charAt(j)) y++;
            if (x - i > y - j) return false;
            i = x ; j = y;
        }
        return i == name.length() && j == typed.length();
    }

    public boolean isLongPressedNameSelf(String name, String typed) {
        int i = 0, j = 0;
        for (; i < name.length() && j < typed.length(); i++, j++){
            if (name.charAt(i) == typed.charAt(j)){
                continue;
            }
            while (i > 0 && j < typed.length() && typed.charAt(j) == name.charAt(i - 1)){
                j++;
            }
            if (j < typed.length() && name.charAt(i) != typed.charAt(j)){
                return false;
            }
        }
        if (i == name.length() && j < typed.length()){
            while (j < typed.length() &&  typed.charAt(j) == name.charAt(i - 1)){
                j++;
            }
        }
        return i == name.length() && j == typed.length();
    }
}
