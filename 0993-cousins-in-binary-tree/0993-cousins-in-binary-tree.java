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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<Pair<TreeNode, Integer>> bfs = new LinkedList<>();
        bfs.add(new Pair<>(root, -1));
        
        while(bfs.size() > 0){
            int foundX = -1;
            int foundY = -1;
            List<Pair<TreeNode, Integer>> next = new LinkedList<>();
            while(bfs.size() > 0){
                Pair<TreeNode, Integer> cur = bfs.poll();
                if(cur.getKey() == null) continue;
                if(cur.getKey().val == x){
                    foundX = cur.getValue();
                }else if(cur.getKey().val == y){
                    foundY = cur.getValue();
                }
                next.add(new Pair<>(cur.getKey().left, cur.getKey().val));
                next.add(new Pair<>(cur.getKey().right, cur.getKey().val));
            }
            if(foundX != -1 && foundY != -1){
                if(foundX == foundY){
                    return false;
                }else{
                    return true;
                }
            }
            for(Pair<TreeNode, Integer> i: next){
                bfs.add(i);
            }
        }
        return false;
    }

}