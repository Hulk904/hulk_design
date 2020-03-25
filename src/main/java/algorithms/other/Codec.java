package algorithms.other;

import algorithms.TreeNode;
import algorithms.top100.TreeUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yangyuan on 2020/2/29.
 * 297. 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。

 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

 */
public class Codec {

    public static void main(String[] args) {
        TreeNode treeNode = TreeUtil.buildTree(new Integer[]{1});
        System.out.println(serialize(treeNode));
        //System.out.println(deserialize("1,2,#,#,3,#,#,"));
    }
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null){
            return "#,";
        }
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                sb.append(root.val).append(",");
                stack.push(root);
                root = root.left;
            }
            sb.append("#,");
            root = stack.pop();
            root = root.right;
            if (stack.isEmpty() && root == null){//和放在while外一样， 这就是退出条件。。
                sb.append("#,");
            }
        }
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        // 将序列化的结果转为字符串数组  split 最后一个，后没有数了，会忽视最后一个，
        String []temp=data.split(",");
        List<String> list=new LinkedList<>(Arrays.asList(temp)); // 字符串数组转为集合类 便于操作
        return myDeSeri(list);
    }

    public static TreeNode myDeSeri(List<String> list){
        TreeNode root;
        //节点为空的处理
        if(list.get(0).equals("#")){
            list.remove(0);
            return null;
        }
        root=new TreeNode(Integer.valueOf(list.get(0)));
        // 删除第一个元素 则第二个元素成为新的首部 便于递归
        list.remove(0);
        root.left= myDeSeri(list);
        root.right= myDeSeri(list);
        return root;
    }
}
