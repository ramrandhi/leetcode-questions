package collections.List.LinkedList.problems;


import collections.List.LinkedList.internalImplementations.SinglyLinkedList;

public class Sll {
    
    private Node head;
    private int size;
    private Node tail;
    
    private class Node {
        private Node next;
        private int data;
        
        public Node(int data) {
            this.data = data;
        }
        
        public Node(int data, Node next) {
            this.next = next;
            this.data = data;
        }
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

    public void insertUsingRecursion(int value, int index) {
        head = insertUsingRecursion(value, index, head);
    }

    public Node insertUsingRecursion(int value, int index, Node node) {
        if(index == 0) {
            Node newNode = new Node(value, node);
            size++;
            return newNode;
        }
        node.next = insertUsingRecursion(value, index-1, node.next);
        return node;
    }

    public void adjacentUniqueElements() {
        Node node = head;
        while(node.next != null) {
            if(node.data == node.next.data) {
                node.next = node.next.next;
                size--;
            } else {
                node = node.next;
            }
        }
    }
    // merge 2 sorted linked lists
    public Sll merge(Sll first, Sll second) {
        Node f = first.head;
        Node s = second.head;
        Sll result = new Sll();
        while(f != null && s != null) {
            if(f.data < s.data) {
                result.insertLast(f.data);
                f = f.next;
            } else {
                result.insertLast(s.data);
                s = s.next;
            }
        }
        while(f != null) {
            result.insertLast(f.data);
            f = f.next;
        }
        while(s != null) {
            result.insertLast(s.data);
            s = s.next;
        }
        return result;
    }
}
