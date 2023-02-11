class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
            int answer[] = new int[n];
            Map<Integer, List<int[]>> adj = new HashMap<>();
            for(int[] edge: redEdges){
                adj.computeIfAbsent(edge[0], val -> new ArrayList<int[]>()).add(new int[]{edge[1], 0});
            }
            for(int[] edge: blueEdges){
                adj.computeIfAbsent(edge[0], val -> new ArrayList<int[]>()).add(new int[]{edge[1], 1});
            }

            Arrays.fill(answer, -1);
            boolean vis[][] = new boolean[n][2];
            vis[0][0] = true;
            vis[0][1] = true;

            Queue<int[]> bfs = new LinkedList<>();
            bfs.add(new int[]{0, 0, -1});
            
            while(bfs.size() > 0){
                int cur = bfs.peek()[0];
                int dist = bfs.peek()[1];
                int prevColor = bfs.peek()[2];
                bfs.remove();
                
                if(prevColor != -1){
                    vis[cur][prevColor] = true;
                }
                
                if(answer[cur] == -1){
                    answer[cur] = dist;
                }

                // Checking for no outgoing edges
                if(!adj.containsKey(cur)){
                    continue;
                }

                for(int[] neighborPair: adj.get(cur)){
                    int neighbor = neighborPair[0];
                    int edgeColor = neighborPair[1];
                    if(!vis[neighbor][edgeColor] && edgeColor != prevColor){
                        bfs.add(new int[]{neighbor, dist + 1, edgeColor});
                    }
                }

            }

            return answer;
    }
}