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
    private Pair<Integer, Integer> dfs(TreeNode node, int x, int d){
        if(node == null){
            return new Pair<>(-1, -1);
        }
        if(node.val == x){
            return new Pair<>(d, -1);
        }
        if(node.left != null && node.left.val == x){
            return new Pair<>(d+1, node.val);
        }
        if(node.right != null && node.right.val == x){
            return new Pair<>(d+1, node.val);
        }
        Pair<Integer, Integer> left = dfs(node.left, x, d+1);
        Pair<Integer, Integer> right = dfs(node.right, x, d+1);
        if(left.getKey() == -1){
            return right;
        }

        return left;
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        Pair<Integer, Integer> X = this.dfs(root, x, 0);
        Pair<Integer, Integer> Y = this.dfs(root, y, 0);
        
        return (X.getKey() == Y.getKey()) && (X.getValue() != Y.getValue());
    }
}