package trees.BinarySearchTree;

public class BSTInternaImplementation {
    private class Node {
        private Node left;
        private Node right;
        private int data;
        private int height;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }
    }

    private Node root;
    public BSTInternaImplementation() {}

    public int height(Node node) {
        if(node == null) return -1;
        return node.height;
    }

    public void insert(int val) {
        root = insert(val, root);
    }

    private Node insert(int val, Node node) {
        if(node == null) {
            node = new Node(val);
            return node;
        }

        if(val < node.data) {
            node.left = insert(val, node.left);
        }
        if(val > node.data) {
            node.right = insert(val, node.right);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public void populate(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            insert(nums[i]);
        }
    }

        public void populateSorted(int[] nums) {
        populateSorted(nums, 0, nums.length);
    }

    private void populateSorted(int[] nums, int start, int end) {
        if(start >= end) {
            return;
        }
        int mid = start + (end-start)/2;
        insert(nums[mid]);
        populateSorted(nums, start, mid);
        populateSorted(nums, mid+1, end);
    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if(node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void display() {
        display(root, "Root Node: ");
    }

    private void display(Node node, String details) {
        if(node == null) return;
        System.out.println(details + node.getData());
        display(node.left, "left child of " + node.getData() + " : ");
        display(node.right, "Right child of " + node.getData() + " : ");
    }
}
