package algorithms.toutiao;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2020/2/17.
 */
public class RestoreIpAddresses {

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("09"));
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
                                if (sb.toString().length() == s.length() + 3){//可以避免 0 开头的数字。 比如 124.03.2.4
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

    /**
     * dfs 实现
     */
    List<String> res = new ArrayList<>();
    public  List<String> restoreIpAddresses2(String s) {
        dfs(s, 0, 0, "");
        return res;
    }

    void dfs(String s, int u, int k, String path){
        if (u == s.length()){
            if (k == 4){
                res.add((path.substring(0, path.length() - 1)));
            }
            return;
        }
        if (k == 4) return;
        for (int i = u, t = 0; i < s.length(); i++){
            if (i > u && s.charAt(u) == '0') break;
            t = t*10 + (s.charAt(i) - '0');
            if (t < 256) dfs(s, i + 1, k + 1, path + t + ".");
            else break;
        }
    }

}
