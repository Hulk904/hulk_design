package algorithms.other.btree;

import algorithms.TreeNode;

/**
 * Created by yangyuan on 2021/7/18.
 * 988. 从叶结点开始的最小字符串
 * 给定一颗根结点为 root 的二叉树，树中的每一个结点都有一个从 0 到 25 的值，分别代表字母 'a' 到 'z'：值 0 代表 'a'，值 1 代表 'b'，依此类推。

 找出按字典序最小的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。

 （小贴士：字符串中任何较短的前缀在字典序上都是较小的：例如，在字典序上 "ab" 比 "aba" 要小。叶结点是指没有子结点的结点。）



 */
public class SmallestFromLeaf {
    String res = "~";
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return res;
    }

    void dfs(TreeNode root, StringBuilder sb){
        if (root == null){
            return;
        }
        sb.append((char)('a' + root.val));
        if (root.left == null && root.right == null){
            sb.reverse();
            String t = sb.toString();
            sb.reverse();
            if (res.compareTo(t) > 0){
                res = t;
            }
        }
        dfs(root.left, sb);
        dfs(root.right, sb);

        sb.deleteCharAt(sb.length() - 1);
    }
}
