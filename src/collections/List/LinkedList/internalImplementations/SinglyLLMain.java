package collections.List.LinkedList.interalImpl;

public class SinglyLLMain {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertFirst(5);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(9);
        list.insertLast(12);
        list.insertLast(8);
        list.insert(15, 2);
        list.display();
        System.out.println("size : " + list.size());
    }
}
