package algorithms.other;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yangyuan on 2020/8/2.
 * 151. 翻转字符串里的单词
 */
public class ReverseWords {

    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        List<String> list = Arrays.stream(arr).filter(t -> !t.equals("")).collect(Collectors.toList());
        Collections.reverse(list);
        return String.join(" ", list);
    }

}
