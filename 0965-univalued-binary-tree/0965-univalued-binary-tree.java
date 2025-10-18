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
    int value;
    boolean helper(TreeNode root){
        if(root == null) return true;
        
        if(root.val != value) return false;

        boolean left = helper(root.left);
        boolean right = helper(root.right);

        return (left && right)?true:false;
    }
    public boolean isUnivalTree(TreeNode root) {
        value = root.val;

        return helper(root);
    }
}