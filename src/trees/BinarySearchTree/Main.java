package trees.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        BSTInternaImplementation bst = new BSTInternaImplementation();
        int[] nums = {9,13, 15, 1,12,3,4,5,16,7,8,9};
        bst.populate(nums);
        bst.display();
    }
}
