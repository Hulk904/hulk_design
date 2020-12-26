package algorithms.other.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by yangyuan on 2020/11/22.
 *
 * 535. TinyURL 的加密与解密
 *
 * TinyURL是一种URL简化服务， 比如：当你输入一个URL https://leetcode.com/problems/design-tinyurl 时，
 * 它将返回一个简化的URL http://tinyurl.com/4e9iAk.

 要求：设计一个 TinyURL 的加密 encode 和解密 decode 的方法。你的加密和解密算法如何设计和运作是没有限制的，
 你只需要保证一个URL可以被加密成一个TinyURL，并且这个TinyURL可以用解密方法恢复成原本的URL。

 */
public class TinyURL {

    Map<String, String> map = new HashMap();

    String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    String randomStr(int k){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        while (k-- > 0){
            sb.append(chars.charAt(random.nextInt(62)));
        }
        return sb.toString();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        while (true){
            String s = randomStr(6);
            if (map.get(s) == null){
                map.put(s, longUrl);
                return "http://tinyurl.com/" + s;
            }
        }
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return  map.get(shortUrl.substring(19));
    }
}
