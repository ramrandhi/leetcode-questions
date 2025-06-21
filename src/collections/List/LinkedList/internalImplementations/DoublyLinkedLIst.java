package collections.List.LinkedList.internalImplementations;

public class DoublyLinkedLIst {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        private Node next;
        private Node prev;
        private int data;

        public Node(int data) {
            this.data = data;
        }
        public Node(Node next, Node prev, int data) {
            this.next = next;
            this.prev = prev;
            this.data = data;
        }
    }

    public void add(int value) {
        if(head == null) {
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        node.data = value;
        node.prev = tail;
        tail.next = node;
        tail = node;
        tail.next = null;
        size++;
    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        node.prev = null;
        if(head != null) {
            head.prev = node;
        }
        head = node;
        if(tail == null) {
            tail = head;
        }
        size++;
    }

    public void insertLast(int value) {
        Node node = new Node(value);
        Node last = head;
        if(head == null) {
            node.prev = null;
            head = node;
            return;
        }
        while(last.next != null) {
            last = last.next;
        }
        last.next = node;
        node.prev = last;
        size++;

    }

    public void display() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public int size() {
        return size;
    }

    public void insertAfter(int after, int value) throws Exception {
        Node p = find(after);
        if(p == null) {
            throw new Exception("node is null");
        }
        Node node = new Node(value);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if(node.next != null) {
            node.next.prev = node;
        }
    }


    public Node find(int value) {
        Node temp = head;
        while(temp != null) {
            if(temp.data == value) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
