package algorithms;



/**
 * Created by yangyuan on 2018/8/28.
 * 反向输出链表，直接的方式就是使用栈
 * 如果不能使用数据结构那就可以考虑用 递归了。
 * 如果可以改变结构，可以在第一次遍历的时候改变方向
 */
public class PrintLinkListReverse {

    public static void main(String[] args) {
        Node node2 = new Node(3, null);
        Node node1 = new Node(2, node2);
        Node node = new Node(1,node1);
        print(node);
    }
    private static void print(Node data){
        if(data.getNext() != null){
            print(data.next);
        }
        System.out.println(data.getValue());
    }

    private static class Node{
        private Integer value;
        private Node next;

        public Node(Integer value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
