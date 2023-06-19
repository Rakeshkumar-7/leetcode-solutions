class Solution {
    private int[] getOrder(int n, int[][] pr){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int[] course: pr){
            adj.get(course[1]).add(course[0]);
        }
        int indegree[] = new int[n];
        for(ArrayList<Integer> neighbors: adj){
            for(Integer neighbor: neighbors){
                indegree[neighbor]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        ArrayList<Integer> order = new ArrayList<>();
        int m = 0;
        while(q.size() > 0){
            int node = q.poll();
            m++;
            for(int neighbor: adj.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) q.add(neighbor);
            }
            order.add(node);
        }
        if(m != n){
            order.clear();
        }
        int[] result = new int[order.size()];
        int i = 0;
        for(int x: order){
            result[i] = x;
            i++;
        }
        return result;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        return getOrder(numCourses, prerequisites);
    }
}