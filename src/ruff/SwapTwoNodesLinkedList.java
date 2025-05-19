package ruff;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}


public class SwapTwoNodesLinkedList {
        Node head;

        // Add node at the end
        void add(int data) {
            if (head == null) {
                head = new Node(data);
                return;
            }

            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }

            curr.next = new Node(data);
        }

        // Print list
        void print() {
            Node curr = head;
            while (curr != null) {
                System.out.print(curr.data + " ");
                curr = curr.next;
            }
            System.out.println();
        }

        // Swap nodes by position (index)
        void swapNodes(int i, int j) {
            if (i == j) return;

            Node prevX = null, currX = head;
            for (int k = 0; currX != null && k < i; k++) {
                prevX = currX;
                currX = currX.next;
            }

            Node prevY = null, currY = head;
            for (int k = 0; currY != null && k < j; k++) {
                prevY = currY;
                currY = currY.next;
            }

            if (currX == null || currY == null) return;

            // Update previous pointers
            if (prevX != null) {
                prevX.next = currY;
            } else {
                head = currY;
            }

            if (prevY != null) {
                prevY.next = currX;
            } else {
                head = currX;
            }

            // Swap next pointers
            Node temp = currX.next;
            currX.next = currY.next;
            currY.next = temp;
        }

        // Main
        public static void main(String[] args) {
            SwapTwoNodesLinkedList list = new SwapTwoNodesLinkedList();
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            list.add(5);

            System.out.print("Before swapping: ");
            list.print();

            list.swapNodes(1, 3);  // Swap nodes at index 1 and 3 (2 and 4)

            System.out.print("After swapping: ");
            list.print();
        }
}
