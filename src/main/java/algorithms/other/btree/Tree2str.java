package algorithms.other.btree;

import algorithms.TreeNode;

/**
 * Created by yangyuan on 2020/12/14.
 * 606. 根据二叉树创建字符串
 *
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。

 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。

 */
public class Tree2str {

    StringBuilder sb = new StringBuilder();

    /**
     * 如果左为空，右不为空则 括号是不能省略的。因为这样就不确定括号里的数据是属于左子树还是右子树
     * 左不为空右为空则是可以省略 括号的
     * @param t
     * @return
     */
    public String tree2str(TreeNode t) {
        dfs(t);
        return sb.toString();
    }

    void dfs(TreeNode t){
        if (t == null) return ;
        sb.append(t.val);
        if (t.left != null || t.right != null){
            sb.append("(");
            dfs(t.left);
            sb.append(")");
        }
        if (t.right != null){
            sb.append("(");
            dfs(t.right);
            sb.append(")");
        }
    }
}
