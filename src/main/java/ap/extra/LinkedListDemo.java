package ap.extra;

/**
 * @author lei
 * @date 03/26/2022 7:38 PM
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = null;

        Node head = n1;

        while (head != null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
}

class Node {
    int val;
    Node next;
    public Node() {}
    public Node(int val) {
        this.val = val;
    }
}