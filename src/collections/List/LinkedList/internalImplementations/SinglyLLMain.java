package collections.List.LinkedList.internalImplementations;

public class SinglyLLMain {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertFirst(5);
        list.insertFirst(3);
        list.insertFirst(2);
        list.display();
//        list.insertUsingRecursion(5, 2);
//        list.display();
//        list.adjacentUniqueElements();
        list.display();
        System.out.println("size : " + list.size());
    }
}
