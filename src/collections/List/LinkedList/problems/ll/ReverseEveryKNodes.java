package collections.List.LinkedList.problems.ll;

public class ReverseEveryKNodes {
    private ListNode head;
    private int size;

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1 || head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;
        while(true) {
            ListNode kth = getKthNode(prevGroupEnd, k);
            if(kth == null) break;
            ListNode groupStart = prevGroupEnd.next;
            ListNode groupEndNext = kth.next;
            ListNode prev = kth.next;
            ListNode current = groupStart;
            while (current != groupEndNext) {
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            prevGroupEnd.next = kth;
            prevGroupEnd = groupStart;
        }

        return dummy.next;
    }

    private ListNode getKthNode(ListNode start, int k) {
        while(start != null && k > 0) {
            start = start.next;
            k--;
        }
        return start;
    }
}
