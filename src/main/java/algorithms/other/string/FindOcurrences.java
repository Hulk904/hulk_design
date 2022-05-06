package algorithms.other.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yangyuan on 2021/12/26.
 * 1078. Bigram 分词
 * 给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，其中 second 紧随 first 出现，third 紧随 second 出现。

 对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。

 */
public class FindOcurrences {

    public String[] findOcurrences(String text, String first, String second) {
        String [] arr = text.split(" ");
        List<String> list = new ArrayList<>();
        for (int i = 0; i + 2 < arr.length; i++){
            if (arr[i].equals(first) &&  arr[i + 1].equals(second)){
                list.add(arr[i + 2]);
            }
        }
        return list.toArray(new String[list.size()]);
    }

}
