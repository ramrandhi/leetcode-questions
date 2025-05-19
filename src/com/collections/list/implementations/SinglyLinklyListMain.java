package com.collections.list.implementations;

public class SinglyLinklyListMain {
    public static void main(String[] args) {
        SingleyLinkedList ll = new SingleyLinkedList();
        ll.insertFirst(2);
        ll.insertFirst(3);
        ll.insertFirst(5);
        ll.insertFirst(6);
        ll.insertLast(9);
        ll.display();
    }
}
