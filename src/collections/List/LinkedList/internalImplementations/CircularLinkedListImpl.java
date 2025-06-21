package collections.List.LinkedList.internalImplementations;

public class CircularLinkedListImpl {
    private Node head;
    private Node tail;

    public CircularLinkedListImpl() {
        this.head = null;
        this.tail = null;
    }

    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public void insert(int value) {
        Node node = new Node(value);
        if(head == null) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void display() {
        Node temp = head;
        if(head != null) {
            do {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            } while(temp != head);
        }
        System.out.println("HEAD");
    }

    public void delete(int value) {
        if (head == null) {
            System.out.println("no data available to delete");
            return;
        }
        if (head.data == value) {
            if (head == tail) {  // Only one node
                head = null;
                tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            return;
        }
        Node prev = head;
        Node curr = head.next;
        while (curr != head) {
            if (curr.data == value) {
                prev.next = curr.next;
                if (curr == tail) {
                    tail = prev;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        System.out.println("Value " + value + " not found");
    }

}
