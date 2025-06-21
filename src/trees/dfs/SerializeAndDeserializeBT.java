package trees.dfs;

//  https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/

public class SerializeAndDeserializeBT {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return sb.toString();
    }

    private void helper(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("null,");
            return;
        }
        sb.append(String.valueOf(root.val)).append(",");
        helper(root.left, sb);
        helper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        int[] index = new int[1];
        return buildTree(tokens, index);
    }

    private TreeNode buildTree(String[] tokens, int[] index) {
        if (index[0] >= tokens.length || tokens[index[0]].equals("null")) {
            index[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(tokens[index[0]++]));
        node.left = buildTree(tokens, index);
        node.right = buildTree(tokens, index);
        return node;
    }

    private class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int val;
        private TreeNode(int data) {
            this.val = data;
        }
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBT codec = new SerializeAndDeserializeBT();

        // Manually create a sample tree:
        //       1
        //      / \
        //     2   3
        //        / \
        //       4   5
        TreeNode root = codec.new TreeNode(1);
        root.left = codec.new TreeNode(2);
        root.right = codec.new TreeNode(3);
        root.right.left = codec.new TreeNode(4);
        root.right.right = codec.new TreeNode(5);

        // Serialize
        String serialized = codec.serialize(root);
        System.out.println("Serialized Tree: " + serialized);

        // Deserialize
        TreeNode deserializedRoot = codec.deserialize(serialized);
        System.out.println("Deserialized Tree Root Value: " + deserializedRoot.val);
        System.out.println("Left Child: " + (deserializedRoot.left != null ? deserializedRoot.left.val : "null"));
        System.out.println("Right Child: " + (deserializedRoot.right != null ? deserializedRoot.right.val : "null"));
        System.out.println("Right->Left: " + (deserializedRoot.right.left != null ? deserializedRoot.right.left.val : "null"));
        System.out.println("Right->Right: " + (deserializedRoot.right.right != null ? deserializedRoot.right.right.val : "null"));
    }
}
