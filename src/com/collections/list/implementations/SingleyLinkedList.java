package com.collections.list.implementations;

public class SingleyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public SingleyLinkedList() {
        size = 0;
    }

    private class Node {
        private int value;
        private Node next;

        private Node(int value){
            this.value = value;
        }
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        size++;
    }

    public void insertLast(int val){
        if(tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;

    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value+ " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
}
