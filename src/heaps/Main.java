package heaps;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>();
        heap.insert(34);
        heap.insert(42);
        heap.insert(35);
        heap.insert(11);
        heap.insert(45);
        heap.insert(28);
        heap.insert(57);
        System.out.println("Original heap:");
        heap.display();

        ArrayList<Integer> sorted = heap.heapSort();
        System.out.println("Sorted list using heap sort:");
        System.out.println(sorted);

        System.out.println("Heap after sorting (should be unchanged):");
        heap.display();  // original heap remains intact
    }
}
