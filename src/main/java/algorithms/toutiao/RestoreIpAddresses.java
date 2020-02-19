package algorithms.toutiao;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2020/2/17.
 */
public class RestoreIpAddresses {

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(restoreIpAddresses("25525511135")));

    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        for (int i = 1; i < 4; i++){
            for (int j = 1; j < 4; j++){
                for (int m = 1; m < 4; m++){
                    for (int n = 1; n < 4; n++){
                            if (i + j + m + n == s.length()){
                            if (((Integer.parseInt(s.substring(0, i)) < 256 &&
                                    Integer.parseInt(s.substring(i, i + j)) < 256 &&
                                    Integer.parseInt(s.substring(i + j, i + j + m))< 256 ))&&
                                    Integer.parseInt(s.substring(i + j + m)) < 256){

                                sb.append(Integer.parseInt(s.substring(0,i))).append(".")
                                        .append(Integer.parseInt(s.substring(i, i + j)))
                                        .append(".").append(Integer.parseInt(s.substring(i + j, i + j + m)))
                                        .append(".").append(Integer.parseInt(s.substring(i + j + m)));
                                if (sb.toString().length() == s.length() + 3){
                                    result.add(sb.toString());
                                }
                                sb.delete(0, sb.length());
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

}
