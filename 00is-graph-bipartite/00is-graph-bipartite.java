class Solution {
    private boolean DFS(int[][] graph, int vis[], int cur, int code){
        vis[cur] = code;
        for(int neighbor: graph[cur]){
            if(vis[neighbor] == 0){
                if(DFS(graph, vis, neighbor, (code == 1)?2:1) == false){
                   return false;
                }
            }else if(vis[neighbor] == code){
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int vis[] = new int[graph.length];
        Boolean ans = true;
        for(int i=0; i<graph.length; i++){
            if(vis[i] == 0){
                ans = ans && DFS(graph, vis, i, 1);
            }
        }
        // System.out.println(Arrays.toString(vis));
        return ans;
    }
}