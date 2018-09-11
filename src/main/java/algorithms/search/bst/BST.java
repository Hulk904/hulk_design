package algorithms.search.bst;

/**
 * Created by yangyuan on 2018/4/19.
 * 二叉查找树只是定义了每个节点的key大于他的左子树，小于它的右子树
 */
public class BST  <K extends Comparable<K>, V>{

    private Node root;

    private class Node{
        private K key;
        private V value;
        private Node lefe, right;
        private int N;
        public Node(K key, V value, int N){
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }
    public int size(){
        return size(root);
    }

    private int size(Node x){
        if(x == null) return 0;
        else return x.N;
    }
    public V get(K key){
        return get(root, key);
    }
    private V get(Node x, K key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            return get(x.lefe,key);
        }else  if(cmp > 0){
            return get(x.right,key);
        }else {
            return x.value;
        }
    }

    public void put(K key,V value){
        root = put(root, key, value);
    }
    private Node put(Node x,K key, V value){
        if(x == null) return new Node(key, value, 1);
        int cmp = key.compareTo(x.key);
        if(cmp > 0){
            x.right = put(x.right, key, value);
        }else if(cmp < 0){
            x.lefe = put(x.lefe, key, value);
        }else {
            x.value = value;
        }
        x.N = size(x.lefe) + size(x.right) + 1;
        return x;
    }
}
