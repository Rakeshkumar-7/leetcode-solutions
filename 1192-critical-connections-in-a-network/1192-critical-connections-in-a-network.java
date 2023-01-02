class Solution {
    private void DFS(List<List<Integer>> adj, List<List<Integer>> bridges, int cur, int time, int[] vis, int[] disc, int[] low, int[] parent){
        vis[cur] = 1;
        disc[cur] = time;
        low[cur] = time;
        for(int neighbor: adj.get(cur)){
            if(vis[neighbor] == 0){
                parent[neighbor] = cur;
                DFS(adj, bridges, neighbor, time + 1, vis, disc, low, parent);
                low[cur] = Math.min(low[cur], low[neighbor]);
            }else{
                // If the edge is not pointing to parent
                if(neighbor != parent[cur]){
                    low[cur] = Math.min(low[cur], low[neighbor]);
                }
            }
            if(low[neighbor] > disc[cur]){
                List<Integer> edge = new ArrayList<>();
                edge.add(cur);
                edge.add(neighbor);
                bridges.add(edge);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        System.out.println(connections);
        List<List<Integer>> adj = new ArrayList();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(List<Integer> edge: connections){
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }
        List<List<Integer>> bridges = new ArrayList();
        int[] vis = new int[n];
        int[] disc = new int[n];
        int[] low = new int[n];
        int[] parent = new int[n];
        // parent[0] = -1;
        DFS(adj, bridges, 0, 1, vis, disc, low, parent);
        return bridges;
    }
}