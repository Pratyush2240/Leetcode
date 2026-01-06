import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;

        double maxSum = Double.NEGATIVE_INFINITY; // Use double to handle extreme int values
        int bestLevel = 1;
        int currentLevel = 1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int nodesAtLevel = queue.size();
            long currentLevelSum = 0; // Use long to prevent overflow during summation

            // Iterate through all nodes at the current depth
            for (int i = 0; i < nodesAtLevel; i++) {
                TreeNode node = queue.poll();
                currentLevelSum += node.val;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            // Update the result if this level's sum is strictly greater
            if (currentLevelSum > maxSum) {
                maxSum = currentLevelSum;
                bestLevel = currentLevel;
            }

            currentLevel++;
        }

        return bestLevel;
    }
}