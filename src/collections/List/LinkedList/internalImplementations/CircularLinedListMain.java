package collections.List.LinkedList.internalImplementations;

public class CircularLinedListMain {
    public static void main(String[] args) {
        CircularLinkedListImpl cll = new CircularLinkedListImpl();
        cll.insert(5);
        cll.insert(15);
        cll.insert(55);
        cll.insert(52);
        cll.display();
    }
}
