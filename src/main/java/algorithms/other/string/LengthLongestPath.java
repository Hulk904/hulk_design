package algorithms.other.string;

import java.util.Stack;

/**
 * Created by yangyuan on 2020/10/5.
 *
 * 388. 文件的最长绝对路径
 *
 * 假设我们以下述方式将我们的文件系统抽象成一个字符串:

 字符串 "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" 表示:

 dir
    subdir1
    subdir2
        file.ext
 目录 dir 包含一个空的子目录 subdir1 和一个包含一个文件 file.ext 的子目录 subdir2 。



 */
public class LengthLongestPath {

    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack();
        int res = 0;
        for (int i = 0, sum = 0; i < input.length(); i++){
            int k = 0;//当前点在第几层
            while (i < input.length() && input.charAt(i) == '\t') {
                i++;
                k++;
            }
            while (stack.size() > k) {
                sum -= stack.pop();//sum 当前栈所有串长度之和
            }
            int j = i;
            while (j < input.length() && input.charAt(j) != '\n') j++;
            int len = j - i;
            stack.push(len);
            sum += len;
            if (input.substring(i, j).contains(".")){
                res = Math.max(res, sum + stack.size() - 1);
            }
            i = j;
        }
        return res;
    }
}
