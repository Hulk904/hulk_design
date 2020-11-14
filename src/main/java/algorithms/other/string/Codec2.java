package algorithms.other.string;

import algorithms.TreeNode;

/**
 * Created by yangyuan on 2020/10/31.
 * 449. 序列化和反序列化二叉搜索树
 *
 *
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。

 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。

 编码的字符串应尽可能紧凑。

 普通的二叉树（但也要求没有重复元素） 需要前序和中序，或者后序和中序才能实现序列化和反序列化

 */
public class Codec2 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    void dfs(TreeNode root, StringBuilder sb){
        if (root == null) return;
        sb.append(root.val).append(",");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        String[] numstr = data.split(",");
        int[] nums = new int[numstr.length];
        for(int i = 0; i < numstr.length; i++){
            nums[i] = Integer.parseInt(numstr[i]);
        }
        return build(nums, 0, nums.length - 1);
    }

    /**
     *
     * @param nums
     * @param l 左边界
     * @param r 右边界
     * @return
     */
    private TreeNode build(int[] nums, int l, int r){
        if (l > r) return null;
        TreeNode root = new TreeNode(nums[l]);
        int index = r + 1;//这里 index 不能赋值 l ，应该为一个异常值。 如果赋值l， 在l==r时 ，下面root.right = build(nums, index, r)将会死循环
        for (int i = l + 1; i <= r; i++){
            if (nums[i] > nums[l]){
                index = i;
                break;
            }
        }
        root.left = build(nums, l + 1, index - 1);
        root.right = build(nums, index, r);
        return root;
    }
}
