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
    private void inorderTraversal(TreeNode root, List<Integer> inorder){
        if(root == null){
            return;
        }
        inorderTraversal(root.left, inorder);
        inorder.add(root.val);
        inorderTraversal(root.right, inorder);
    }
    public int minDiffInBST(TreeNode root) {
        List<Integer> inorder = new LinkedList<>();
        inorderTraversal(root, inorder);
        int min = Integer.MAX_VALUE;
        for(int i=0; i<inorder.size() - 1; i++){
            min = Math.min(min, inorder.get(i+1) - inorder.get(i));
        }
        return min;
    }
}