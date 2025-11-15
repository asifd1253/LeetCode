/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans;
    int[] dfs(TreeNode root){
        if(root == null){
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int leftSubTree[] = dfs(root.left);
        int rightSubTree[] = dfs(root.right);

        if(leftSubTree[1] < root.val && root.val < rightSubTree[0]){
            int curSum = leftSubTree[2] + rightSubTree[2] + root.val;

            ans = Math.max(ans, curSum);

            int minVal = Math.min(root.val, leftSubTree[0]);
            int maxVal = Math.max(root.val, rightSubTree[1]);

            return new int[]{minVal, maxVal, curSum};
        }

        int maxSum = Math.max(leftSubTree[2], rightSubTree[2]);
        return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, maxSum};
    }
    public int maxSumBST(TreeNode root) {
        ans = 0;
        dfs(root);

        return ans;
    }
}