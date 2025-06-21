package trees.dfs;

//  https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/submissions/1663084262/

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;
        TreeNode leftMost = lowestCommonAncestor(root.left, p, q);
        TreeNode rightMost = lowestCommonAncestor(root.right, p, q);
        if(leftMost != null && rightMost != null) return root;
        return leftMost == null ? rightMost : leftMost;
    }

    private class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int val;
    }
}
