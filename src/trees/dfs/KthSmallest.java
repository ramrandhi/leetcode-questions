package trees.dfs;

public class KthSmallest {
    int counter = 0;
    public int kthSmallest(TreeNode root, int k) {
        return helper(root, k).val;
    }
    private TreeNode helper(TreeNode node, int k) {
        if(node == null) return null;
        TreeNode left = helper(node.left, k);
        if(left != null) return left;
        counter++;
        if(counter == k) return node;
        return helper(node.right, k);
    }

    private class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int val;
    }
}
