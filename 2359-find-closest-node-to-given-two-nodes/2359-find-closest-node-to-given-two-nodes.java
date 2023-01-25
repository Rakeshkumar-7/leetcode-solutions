class Solution {
    private void DFS(int[] edges, int cur, int[] vis, int dist){
        vis[cur] = dist;
        int neighbor = edges[cur];
        if(neighbor != -1 && vis[neighbor] == -1){
            DFS(edges, neighbor, vis, dist + 1);
        }
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);
        DFS(edges, node1, dist1, 0);
        DFS(edges, node2, dist2, 0);

        int max = -1;
        for(int i=0; i<n; i++){
            if(dist1[i] != -1 && dist2[i] != -1){
                if(max == -1){
                    max = i;
                }else{
                    int maxDist = Math.max(dist1[max], dist2[max]);
                    int curMax = Math.max(dist1[i], dist2[i]);
                    if(curMax < maxDist){
                        max = i;
                    }
                }
            }
        }

        return max;
    }
}