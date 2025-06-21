package trees.bfs.questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//  https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean reverse = false;
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<size;i++) {
                TreeNode current = queue.poll();
                list.add(current.val);
                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
            }
            result.add(0, list);
        }
        return result;
    }

    private class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int val;
    }
}
