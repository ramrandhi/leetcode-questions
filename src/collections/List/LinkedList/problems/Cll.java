package collections.List.LinkedList.problems;

import collections.List.LinkedList.internalImplementations.CircularLinkedListImpl;
import collections.List.LinkedList.internalImplementations.SinglyLinkedList;

public class Cll {

    private class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // find if there is a cycle
    public boolean detectCyclePresents(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    // find the length of cycle in singly linked list
    public int findLengthOfCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow) {
                Node temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                } while(temp != slow);
                return length;
            }
        }
        return 0;
    }

    public Node findStartOfCycle(Node head) {
        int length = 0;
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if(fast == slow) {
                Node temp = slow;
                do {
                    temp = temp.next;
                    length++;
                } while(temp != slow);
            }
        }

        Node f = head;
        Node s = head;
        while(length > 0) {
            s = s.next;
            length--;
        }

        while(f != s) {
            f = f.next;
            s = s.next;
        }

        return s;
    }
}
