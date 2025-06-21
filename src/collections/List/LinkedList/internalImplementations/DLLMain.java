package collections.List.LinkedList.internalImplementations;

public class DLLMain {
    public static void main(String[] args) {
        DoublyLinkedLIst dll = new DoublyLinkedLIst();
        dll.add(2);
        dll.add(6);
        dll.insertFirst(5);
        dll.insertFirst(9);
        dll.insertLast(10);
        dll.insertLast(19);
        dll.display();
        System.out.println(dll.size());
    }
}
