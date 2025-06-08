package collections.List.LinkedList.interalImpl;

import com.collections.list.implementations.SingleyLinkedList;

public class SinglyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList() {
        this.size = 0;
    }

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public void add(int value) {
        if(head == null) {
            head = new Node(value);
            tail = head;
            size++;
        }
        Node current = head;
        while(current != null) {
            current = current.next;
            tail = current;
            size++;
        }
        current.next = new Node(value);
        tail = current.next;
    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        if(tail == null) {
            tail = head;
        }
        size++;
    }

    public void display() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public int size() {
        return size;
    }

    public void insertLast(int value) {
        if(tail == null) {
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int value, int index) {
        if(index == 0) {
            insertFirst(value);
            return;
        }
        if(index == size) {
            insertLast(value);
            return;
        }
        Node temp = head;
        for(int i = 1;i< index;i++) {
            temp = temp.next;
        }
        Node node = new Node(value, temp.next);
        temp.next = node;
        size++;
    }

    public int deleteFirst() {
        int value = head.data;
        head = head.next;
        if(head == null) {
            tail = null;
        }
        size--;
        return value;
    }

    public int deleteLast() {
        if(size <= 1) {
            return deleteFirst();
        }
        Node secondLast = get(size-2);
        int value = tail.data;
        tail = secondLast;
        tail.next = null;
        return value;
    }

    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

//    public void insertAtIndex(int index, int value) {
//        int i = 0;
//        Node temp = head;
//        while(i <= index) {
//            if(i == index) {
//
//            }
//            temp = temp.next;
//            i++;
//        }
//    }

    public int deleteAtIndex(int index) {
        if(index == 0) {
            return deleteFirst();
        }
        if(index == size-1) {
            return deleteLast();
        }
        Node prev = get(index-1);
        int value = prev.next.data;
        prev.next = prev.next.next;
        return value;
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
