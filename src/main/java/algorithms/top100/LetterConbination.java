package algorithms.top100;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangyuan on 2019/12/28.
 * 思路：怎么找到递归的关系 ，怎么表达出来。 这里的退出条件 伴随着 数据的添加。 与之前逻辑不一样的地方
 */
public class LetterConbination {
    static Map<String, String>  phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    static List<String> result = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println(JSON.toJSON(letterConbination("23")));

    }

    private static  List<String> letterConbination(String digits){
        if (digits == null || digits == ""){
            return new ArrayList<>();
        }
        combin(digits, "");
        return result;
    }

    private static void combin(String digit, String current){
        if (digit.equals("")){
            result.add(current);
            return ;
        }
        String str = digit.substring(0,1);
        String target = phone.get(str);
        if (target == null){
            return;
        }
        for (int i = 0; i < target.length(); i++){
            combin(digit.substring(1,digit.length()), current + target.substring(i,i+1) );
        }
    }

}
