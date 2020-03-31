package algorithms.other;


/**
 * Created by yangyuan on 2020/3/30.
 * 421. 数组中两个数的最大异或值
 *
 * 给定一个非空数组，数组中元素为 a0, a1, a2, … , an-1，其中 0 ≤ ai < 231 。

 找到 ai 和aj 最大的异或 (XOR) 运算结果，其中0 ≤ i,  j < n 。

 你能在O(n)的时间解决这个问题吗？

 */
public class FindMaximumXOR {

    public static void main(String[] args) {
        int[] data = {3, 10, 5, 25, 2, 8};
        FindMaximumXOR f = new FindMaximumXOR();
        System.out.println(f.findMaximumXOR(data));
    }

    public static class TrieNode{
        TrieNode[] path = new TrieNode[2];
    }
    public static class Trie{
        private TrieNode root;
        Trie(){
            root = new TrieNode();
        }

        public void insert(int value){
            TrieNode cur = root;
            for(int i=31;i>=0;i--){
                int v = value>>i&1;
                if(cur.path[v]==null){
                    cur.path[v] = new TrieNode();
                }
                cur = cur.path[v];
            }
        }
        public int getMaxXorNum(int value){
            TrieNode cur = root;
            int sum = 0;
            for(int i=31; i>=0;i--){
                int bit = (value>>i)&1;
                int xorBit = bit ^ 1;
                /*
                 * 1. 异或位为空，则该位没有可以异或的值，则从原位置继续下一次循环；
                 * 2. 异或位不为空，说明该位置可以进行异或操作，则从异或后的位置继续循环，
                 * 并将 num 对应的异或值之和 sum 相应位置加上 1；
                 */
                TrieNode next = cur.path[xorBit];
                if (next == null) {
                    cur = cur.path[bit];
                } else {
                    sum += (1 << i);
                    cur = next;
                }

            }
            System.out.println(value + "  == >" + sum);
            return sum;
        }
    }
    public int findMaximumXOR(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Trie tree = new Trie();
        int result = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            tree.insert(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            result= Math.max(result, tree.getMaxXorNum(nums[i]));
        }
        return result;
    }


}
