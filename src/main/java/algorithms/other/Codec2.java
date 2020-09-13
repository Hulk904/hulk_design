package algorithms.other;

import algorithms.TreeNode;

/**
 * Created by yangyuan on 2020/8/30.
 * 二叉树的反序列化
 *  错误的方式
 */
public class Codec2 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfs(root);
        String res = sb.toString();
        return res;
    }

    private StringBuilder sb = new StringBuilder();

    void dfs (TreeNode root){
        if (root == null)  sb.append("#,");
        else {
            sb.append(root.val).append(",");
            dfs(root.left);
            dfs(root.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return dfsDes(data, 0);
    }
    //这里的 u 应该是个引用类型。。。 不知道怎么改。
    TreeNode dfsDes(String data, int u){
        if (data.charAt(u) == '#'){
            u+=2;
            return null;
        } else {
            int k = u;
            while (data.charAt(u) != ',') u++;
            TreeNode root = new TreeNode(Integer.parseInt(data.substring(k, u)));
            u++;
            root.left = dfsDes(data, u);
            root.right = dfsDes(data, u);
            return root;
        }
    }
}
