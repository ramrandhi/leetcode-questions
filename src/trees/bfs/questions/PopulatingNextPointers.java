package trees.bfs.questions;

//  https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/

public class PopulatingNextPointers {
    public Node connect(Node root) {
        if(root == null) return root;
        Node leftMost = root;
        while(leftMost.left != null) {
            Node current = leftMost;
            while(current != null) {
                current.left.next = current.right;
                if(current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }

    private class Node {
        private Node left;
        private Node right;
        private int val;
        private Node next;
    }
}
