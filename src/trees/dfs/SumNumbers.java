package trees.dfs;

import trees.bfs.questions.CousinsInBinaryTree;

// https://leetcode.com/problems/sum-root-to-leaf-numbers/submissions/1663808264/
public class SumNumbers {
    public int sumNumbers(TreeNode root) {
        return helperFun(root, 0);
    }
    private int helperFun(TreeNode root, int sum) {
        if(root == null) return 0;
        sum = sum*10 + root.val;
        if(root.left == null && root.right == null) return sum;
        return helperFun(root.left, sum) + helperFun(root.right, sum);
    }

    private class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int val;
    }
}
