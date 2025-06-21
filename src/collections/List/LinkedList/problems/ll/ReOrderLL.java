package collections.List.LinkedList.problems.ll;

public class ReOrderLL {
    private ListNode head;
    private int size;

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

//    https://leetcode.com/problems/reorder-list/            143. Reorder List
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }
        ListNode mid = getMid(head);
        ListNode secondHead = reverse(mid.next);
        mid.next = null;

        ListNode firstHead = head;
        while(firstHead != null && secondHead != null) {
            ListNode temp1 = firstHead.next;
            ListNode temp2 = secondHead.next;

            firstHead.next = secondHead;
            secondHead.next = temp1;

            firstHead = temp1;
            secondHead = temp2;
        }
    }

    public ListNode reverse(ListNode node) {
        if(node == null || node.next == null) {
            return node;
        }
        ListNode prev = null;
        ListNode current = node;
        while(current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }
        return prev;
    }

    public ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
