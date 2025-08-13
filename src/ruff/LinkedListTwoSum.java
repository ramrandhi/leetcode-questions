package ruff;

import collections.List.LinkedList.problems.ll.ReverseLinkedList;

public class LinkedListTwoSum {
    private static ListNode head;

    private class ListNode {
        private ListNode next;
        private int val;

        public ListNode(int data) {
            this.val = data;
        }
    }

    public static void main(String[] args) {
        LinkedListTwoSum llt = new LinkedListTwoSum();
        llt.add(5);
        llt.add(4);
        llt.add(2);
        llt.add(1);
        System.out.println(llt.pairSum(head));

    }

    public int pairSum(ListNode head) {
        ListNode mid = getMid(head);
        ListNode reverseFromMid = reverseFromMid(mid);
        int max = 0;
        while(head != null && reverseFromMid != null) {
            int value = head.val+reverseFromMid.val;
            max = Math.max(max, value);
            head = head.next;
            reverseFromMid = reverseFromMid.next;
        }
        return max;
    }

    private ListNode getMid(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseFromMid(ListNode mid) {
        if(mid == null || mid.next == null) return mid;
        ListNode prev = null;
        ListNode current = mid;
        while(current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public void add(int val) {
        ListNode newNode = new ListNode(val);
        if(head == null) {
            head = newNode;
            return;
        } else {
            ListNode temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
}
