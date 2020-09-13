package algorithms.acwing;

import java.util.Arrays;

/**
 * Created by yangyuan on 2020/4/9.
 * 腾讯面试 求找到 文本中 关键字 出现的次数
 * 关键必须独立。 比如zookeeper 要找zoo关键字，那么zookeeper里面的zoo不算
 * 所以这个题目就是在kmp的基础上加些首位检查就行。。。
 */
public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.count("tencent ,tencent,", "tencent"));
        if (1 == 1){
            System.out.println(1);
        } else if (0 == 0){
            System.out.println(0);
        }

        System.out.println("  ni hao  ".trim());
    }


    public int count (String source, String target){
        if ("".equals(target)){
            return 0;
        }
        int[] next = next(target);
        int count = 0;
        for (int i = 0 , j = -1; i < source.length(); i++){
            while (j >= 0 && source.charAt(i) != target.charAt(j + 1)) j = next[j];
            if (source.charAt(i) == target.charAt(j + 1)){
                j++;
            }
            if (j == target.length() - 1){//found
                if (i + 1 == source.length() && !isLetter(source.charAt(i - j - 1))) {
                    count++;
                }
                if (i - j - 1 < 0 && !isLetter(source.charAt(i + 1))){
                    count++;
                }
                if (i + 1 < source.length() && !isLetter(source.charAt(i + 1))
                        && i - j - 1 >= 0 && !isLetter(source.charAt(i - j - 1))){
                    count++;
                }
                j = next[j];
            }
        }
        return count;
    }

    private boolean isLetter(char c){
        if ((c >= 'a' && c<='z') || (c>='A' && c <='Z')){
            return true;
        }
        return false;
    }


    int[] next (String target){
        int[] next = new int[target.length()];
        Arrays.fill(next, -1);
        for (int i = 1, j = -1; i < target.length(); i++){
            while (j >= 0 && target.charAt(i) != target.charAt(j + 1)){
                j = next[j];
            }
            if (target.charAt(i) == target.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
