package trees.AVLTrees;

public class AVLTreeImplementation {
    public Node root;
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
    public AVLTreeImplementation() {}

    public int height() {
        return height(root);
    }

    public int height(Node node) {
        if(node == null) return -1;
        return node.height;
    }

    public void insert(int val) {
        root = insert(val, root);
    }

    public Node insert(int val, Node node) {
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
        return rotate(node);
    }

    public Node rotate(Node node) {
        if(height(node.left) - height(node.right) > 1) {
            // left heavy case
            if(height(node.left.left) - height(node.left.right) > 0) {
                // left left case
                return rightRotate(node);
            }
            if(height(node.left.left) - height(node.left.right) < 0) {
                // left right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if(height(node.left) - height(node.right) < -1) {
//            right heavy
            if(height(node.right.left) - height(node.right.right) < 0) {
//                right right case
                return leftRotate(node);
            }
            if(height(node.right.left) - height(node.right.right) > 0) {
//                right left case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    private Node rightRotate(Node parent) {
        Node child = parent.left;
        Node grandChild = child.right;

        child.right = parent;
        parent.left = grandChild;

        parent.height = Math.max(height(parent.left), height(parent.right)) + 1;
        child.height = Math.max(height(child.left), height(child.right)) + 1;
        return child;
    }

    private Node leftRotate(Node child) {
        Node parent = child.right;
        Node grandChild = parent.left;

        parent.left = child;
        child.right = grandChild;

        parent.height = Math.max(height(parent.left), height(parent.right)) + 1;
        child.height = Math.max(height(child.left), height(child.right)) + 1;
        return parent;
    }

    public void populate(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            insert(nums[i]);
        }
    }

    public void populateSorted(int[] nums, int start, int end) {
        if(start >= end) {
            return;
        }
        int mid = start + (end - start) /2;
        insert(nums[mid]);
        populateSorted(nums, start, mid);
        populateSorted(nums, mid+1, end);
    }

    private boolean balanced(Node node) {
        if(node == null) return true;
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void display() {
        display(root, "Root Node : ");
    }

    private void display(Node node, String details) {
        if(node == null) return;
        System.out.println(details + node.getData());
        display(node.left, "left child of " + node.getData() + " : ");
        display(node.right, "Right child of " + node.getData() + " : ");
    }

}
