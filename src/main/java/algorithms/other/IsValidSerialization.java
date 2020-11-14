package algorithms.other;

import java.util.Stack;

/**
 * Created by yangyuan on 2020/3/8.
 * 331. 验证二叉树的前序序列化
 *
 * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 */
public class IsValidSerialization {

    public static void main(String[] args) {
        System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }

    /**
     * 通过栈来处理
       跟下面的差不多，但是相对简洁些，主要是下面处理不是很优美，对于最后一个元素
     * @param preorder
     * @return
     */
    public static  boolean isValidSerialization2(String preorder){
        if ("".equals(preorder) ) return false;
        if ("#".equals(preorder)) return true;
        String[] items = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < items.length; i++){
            stack.push(items[i]);
            while (stack.size() >= 3 &&
                    "#".equals(stack.get(stack.size() - 1)) &&
                    "#".equals(stack.get(stack.size() - 2))){
                stack.pop();
                stack.pop();
                if ("#".equals(stack.peek())) return false;
                stack.pop();
                stack.push("#");
            }
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }

    public static boolean isValidSerialization(String preorder) {
        if ("".equals(preorder) ) return false;
        if ("#".equals(preorder)) return true;
        String[] items = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i <= items.length; i++){
            while (stack.size() >= 3 &&
                    "#".equals(stack.get(stack.size() - 1)) &&
                    "#".equals(stack.get(stack.size() - 2))){
                stack.pop();
                stack.pop();
                if ("#".equals(stack.peek())) return false;
                stack.pop();
                stack.push("#");
            }
            if (i < items.length) {
                stack.push(items[i]);
            }
        }
        return stack.size() == 1 && stack.peek().equals("#");

    }


    /**
     * 递归实现
     */

    int k;
    String s;

    public boolean isValidSerialization3(String preorder) {
        k = 0;//遍历时候的指针
        s = preorder + ",";
        if (!dfs()) return false;
        return k == s.length();//不能直接写true
    }

    boolean dfs(){
        if (k == s.length()) return false;
        if (s.charAt(k) == '#') {
            k+=2;
            return true;
        }
        while (s.charAt(k) != ',') k++;//找根节点
        k++;//把根节点跳过
        //根节点遍历完了
        //递归左子树，递归右子树。。。 不是很好理解啊。。
        return dfs() && dfs();
    }
}
