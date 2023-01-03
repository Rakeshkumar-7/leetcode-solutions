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
    int maxDiff = 0;
    private void maxDiff(TreeNode root, int min, int max){
        if(root == null){
            return;
        }
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        maxDiff = Math.max(maxDiff, Math.abs(max - min));
        maxDiff(root.left, min, max);
        maxDiff(root.right, min, max);
    }  
    public int maxAncestorDiff(TreeNode root) {
        maxDiff(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
        return maxDiff;
    }
}