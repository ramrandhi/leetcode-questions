package collections.List.LinkedList.problems.ll;

public class SortList148 {

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode firstHalf = sortList(head);
        ListNode secondHalf = sortList(mid);
        return merge(firstHalf, secondHalf);
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(prev != null) {
            prev.next = null;
        }
        return slow;
    }

    private ListNode merge(ListNode firstHalf, ListNode secondhalf) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;

        while(firstHalf != null && secondhalf != null) {
            if(firstHalf.val < secondhalf.val) {
                tail.next = firstHalf;
                firstHalf = firstHalf.next;
                tail = tail.next;
            } else {
                tail.next = secondhalf;
                secondhalf = secondhalf.next;
                tail = tail.next;
            }
        }
        tail.next = (firstHalf != null) ? firstHalf : secondhalf;
        return dummyHead.next;
    }
}
