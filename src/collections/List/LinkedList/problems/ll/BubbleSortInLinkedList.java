package collections.List.LinkedList.problems.ll;

import collections.List.LinkedList.internalImplementations.SinglyLinkedList;

public class BubbleSortInLinkedList {
    private ListNode head;
    private int size;

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode get(int index) {
        ListNode temp = head;
        for(int i =0;i<index;i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void bubbleSort() {
        bubbleSort(size-1, 0);
    }

    public void bubbleSort(int row, int column) {
        if(row == 0) {
            return;
        }
        if(column < row) {
            ListNode first = get(column);
            ListNode second = get(column+1);
            if(first.val > second.val) {
                if(first == head) {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else {
                    ListNode prev = get(column-1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSort(row, column+1);
        } else {
            bubbleSort(row-1, 0);
        }
    }

    public void bubbleSortByChatGpt() {
        if (head == null || head.next == null) return;

        boolean swapped;
        do {
            swapped = false;
            ListNode current = head;
            while (current != null && current.next != null) {
                if (current.val > current.next.val) {
                    int temp = current.val;
                    current.val = current.next.val;
                    current.next.val = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

}
