package collections.List.LinkedList.problems.ll;

import collections.List.LinkedList.internalImplementations.SinglyLinkedList;

public class ReverseLinkedList {

    private ListNode head;
    private ListNode tail;
    private int size;

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void reverseRecursive(ListNode node) {
        if(node == tail) {
            head = tail;
            return;
        }
        reverseRecursive(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    public void reverse() {
        head = reverseRecursiveByGpt(head);
    }

    // without using tail
    private ListNode reverseRecursiveByGpt(ListNode node) {
        if (node == null || node.next == null) {
            return node; // New head
        }

        ListNode newHead = reverseRecursiveByGpt(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }

    public ListNode reverseLinkedListIterative(ListNode node) {
        if(node == null || node.next == null) {
            return node;
        }
        ListNode prev = null;
        ListNode current = node;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return prev;
    }

    public void add(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
//            tail.next = newNode;
//            tail = newNode;
            ListNode current = head;
            while(current != null && current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

//    https://leetcode.com/problems/reverse-linked-list-ii/description/

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = null;
        ListNode current = head;

        for(int i=0; current != null && i < left - 1; i++) {
            prev = current;
            current = current.next;
        }
        ListNode last = prev;
        ListNode firstInSub = current;
        ListNode next = current.next;

        for(int i=0; current != null && i < right - left +1;i++) {
            current.next = prev;
            prev = current;
            current = next;
            if(next != null) {
                next = next.next;
            }
        }

        if(last != null) {
            last.next = prev;
        } else {
            head = prev;
        }
        firstInSub.next = current;
        return head;
    }

    public ListNode reverseBetweenByGpt(ListNode head, int left, int right) {
        if(head == null || left == right) return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;

        for(int i = 0;i<left-1;i++) {
            prev = prev.next;
        }

        ListNode current = prev.next;
        ListNode next = null;

        for(int i=0;i< right - left;i++) {
            next = current.next;
            current.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dummyHead.next;
    }

    public boolean isPalindrome(ListNode head) {
        boolean isPalindrome = true;
        ListNode middleNode = getMiddle(head);
        ListNode secondReversedHalf = reverseLinkedListIterative(middleNode);
        ListNode reversedHead = secondReversedHalf;
        while(head != null && secondReversedHalf != null) {
            if(head.val != secondReversedHalf.val) {
                isPalindrome = false;
                break;
            }
            head = head.next;
            secondReversedHalf = secondReversedHalf.next;
        }
        reverseLinkedListIterative(reversedHead);
        return isPalindrome;
    }

    public ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public void display() {
        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
    
    public static void main(String[] args) {
        ReverseLinkedList ll = new ReverseLinkedList();
        for(int i = 6;i>0;i--) {
            ll.add(i);
        }
        ll.display();
        ll.reverse();
        ll.display();
    }

}
