package collections.List.LinkedList.problems.ll;

public class ReverseAlternativeKNodes {
    private ListNode head;
    private int size;

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode revereAlternateKNodes(ListNode head, int k) {
        if(head == null || k <= 1) return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prevNodeLast = dummyHead;

        while(true) {
            ListNode kth = getKthNode(prevNodeLast, k);
            if(kth == null) break;
            ListNode currentNodeLast = kth;
            ListNode nextNodeStart = kth.next;
            ListNode Current = prevNodeLast.next;
            ListNode tempCurrentNodeStart = prevNodeLast.next;
            ListNode tempNextNodeStart = kth.next;
            while(tempCurrentNodeStart != nextNodeStart) {
                ListNode next = tempCurrentNodeStart.next;
                tempCurrentNodeStart.next = tempNextNodeStart;
                tempNextNodeStart = tempCurrentNodeStart;
                tempCurrentNodeStart = next;
            }
            prevNodeLast.next = currentNodeLast;
            prevNodeLast = Current;
        }
        return dummyHead.next;
    }

    private ListNode getKthNode(ListNode start, int k) {
        while(start != null && k > 0) {
            start = start.next;
            k--;
        }
        return start;
    }
}
