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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> bfs = new LinkedList<>();
        if(root == null){
            return bfs;
        }
        Deque<Integer> level = new LinkedList<>();
        q.add(root);
        Boolean left = false;
        while(q.size() > 0){
            if(q.peek() == null){
                q.poll();
                continue;
            }
            TreeNode cur = null;
            level = new LinkedList<>();
            Queue<TreeNode> nextQ = new LinkedList<>();
            while(q.size() > 0){
                cur = q.poll();
                if(cur != null){
                    if(left){
                        level.addFirst(cur.val);                
                    }else{
                        level.addLast(cur.val);
                    }
                    nextQ.add(cur.left);
                    nextQ.add(cur.right);
                }
            }
            if(level.size() > 0){
                bfs.add((List)level);
            }
            q = nextQ;
            left = !left;
        }

        return bfs;
    }
}