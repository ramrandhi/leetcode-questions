package collections.List.LinkedList.problems.ll;

public class SwapNodesInLL {
    private ListNode head;
    private int size;

    public static class ListNode {
        private ListNode next;
        private int data;

        public ListNode(int data) {
            this.data = data;
        }

        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }

    public static ListNode swapTwoNodes(ListNode head, int x, int y) {
        if(head == null || x == y) return head;

        ListNode currX = head;
        ListNode prevX = null;
        while( currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        ListNode currY = head;
        ListNode prevY = null;
        while(currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        if(currX != null && currY != null) return head;

        if(prevX != null) {
            prevX.next = currY;
        } else {
            head = currY;
        }

        if(prevY != null) {
            prevY.next = currX;
        } else {
            head = currX;
        }

        ListNode temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;

        return head;
    }
}
