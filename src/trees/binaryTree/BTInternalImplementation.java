package trees.binaryTree;

import java.util.Scanner;

public class BTInternalImplementation {
    public BTInternalImplementation(){}

    private static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
        }
        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;

//   insert elements
    public void populate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the root node value: ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node) {
        System.out.println("Do you want to enter left of: " + node.data);
        boolean left = scanner.nextBoolean();
        if(left) {
            System.out.println("Enter the value of left of: " + node.data);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }
        System.out.println("Do you want to enter right of: " + node.data);
        boolean right = scanner.nextBoolean();
        if(right) {
            System.out.println("Enter the value of right of: " + node.data);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }

    public void display() {
        display(root, "");
    }
    private void display(Node node, String indent) {
        if(node == null) return;
        System.out.println(indent + node.data);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if(node == null) return;
        System.out.println(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        preOrder(root);
    }

    private void inOrder(Node node) {
        if(node == null) return;
        preOrder(node.left);
        System.out.println(node.data + " ");
        preOrder(node.right);
    }

    public void postOrder() {
        preOrder(root);
    }

    private void postOrder(Node node) {
        if(node == null) return;
        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.data + " ");
    }

    public static void main(String[] args) {
        BTInternalImplementation bt = new BTInternalImplementation();
        bt.populate();
        bt.display();
    }
}
