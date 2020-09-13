package algorithms.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2020/4/20.
 * 6. Z 字形变换
 *
 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 */
public class  Convert {

    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        List<StringBuilder> sb = new ArrayList();
        for (int i = 0; i <numRows; i++){
            sb.add(new StringBuilder());
        }
        int flag = -1;//这里初始化为-1， 后面if的时候会反置。所以第一次不会有问题
        int index = 0;
        for (int i = 0; i <s.length(); i++){
            sb.get(index).append(s.charAt(i));
            if (index == 0 || index == numRows - 1) flag = -flag;
            index+=flag;
        }
        StringBuilder res = new StringBuilder();
        sb.forEach(res::append);
        return res.toString();
    }

    /**
     * 数学 解决  速度相对快点
     * @param s
     * @param numRows
     * @return
     */
    public String convert2(String s, int numRows) {
        StringBuilder res = new StringBuilder();
        if (numRows == 1) return s;
        for (int i = 0; i < numRows; i++){
            if (i == 0 || i == numRows - 1){
                for (int j = i; j < s.length(); j += 2*numRows -2){
                    res.append(s.charAt(j));
                }
            }else {
                for (int j = i, k = 2*numRows - 2 -i; j < s.length() || k < s.length(); j += 2*numRows - 2, k += 2*numRows - 2){
                    if (j < s.length()) res.append(s.charAt(j));
                    if (k < s.length()) res.append(s.charAt(k));
                }
            }
        }
        return res.toString();
    }
}
