package trees.dfs;

//  https://leetcode.com/problems/flatten-binary-tree-to-linked-list/submissions/1662057101/

public class FlattenBTtoSkewedTree {

    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode current = root;
        while(current != null) {
            if(current.left != null) {
                TreeNode temp = current.left;
                while(temp.right != null) {
                    temp = temp.right;
                }
                temp.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }

    private class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int val;
    }
}
