package trees.dfs;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftMost = maxDepth(root.left);
        int rightMost = maxDepth(root.right);
        int maxHeight = Math.max(leftMost, rightMost) + 1;
        return maxHeight;
    }

    private class TreeNode {
        private TreeNode left;
        private TreeNode right;
    }
}
