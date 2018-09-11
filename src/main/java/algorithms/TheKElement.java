package algorithms;

/**
 * Created by yangyuan on 2018/9/2.
 * 获取倒数第k个节点
 *
 */
public class TheKElement {
    public static void main (String[] args){
        Node one = new Node(1, null);
        Node two = new Node(2, one);
        Node three = new Node(3,two);
        Node four = new Node(4, three);
        Node five = new Node(5, four);
        Node six = new Node(6, five);
        Node seve = new Node(7, six);
        Node eight = new Node(8, seve);
        getKElement(eight, 10);
    }

    private static void getKElement(Node node , int k){
        if(node == null || k < 1){
            throw new RuntimeException("illegal param.");
        }
        Node pre = node;
        Node sur = node;
        for(int i = 0 ; i < k; i++){
            sur = sur.next;
            if(sur == null){
                System.out.println("not exit");
                return;
            }
        }
        while(sur != null){
            pre = pre.next;
            sur = sur.next;
            if(sur == null){
                System.out.println(pre.getValue());
            }
        }
    }



    private static class Node {
        private Integer value;
        private Node next;

        public Node ( Integer value, Node next){
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
